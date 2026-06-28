package com.fit.service;

import com.fit.domain.*;

public class BookingService {

    private PricingService pricingService;
    private CenterService centerService;
    private WaitlistService waitlistService;

    public BookingService(PricingService pricingService,
                          CenterService centerService,
                          WaitlistService waitlistService) {
        this.pricingService = pricingService;
        this.centerService = centerService;
        this.waitlistService = waitlistService;
    }

    public Booking book(User user, Slot slot) {

        slot.getLock().lock();
        try {
            Center center = centerService.getCenter(slot.getCenterId());

            if (slot.getBookedCount() < slot.getCapacity()) {

                int price = pricingService.calculatePrice(user, slot, center);

                Booking booking = new Booking(user.getId(), slot.getId(), BookingStatus.BOOKED, price);
                slot.getBookings().put(user.getId(), booking);
                slot.increaseBookedCount();
                return booking;

            } else {
                waitlistService.add(slot, user);
                return new Booking(user.getId(), slot.getId(), BookingStatus.WAITLISTED, 0);
            }

        } finally {
            slot.getLock().unlock();
        }
    }

    public void cancel(User user, Slot slot) {

        slot.getLock().lock();
        try {
            Booking booking = slot.getBookings().get(user.getId());
            if (booking == null || booking.getStatus() != BookingStatus.BOOKED) return;

            booking.setStatus(BookingStatus.CANCELLED);
            slot.decreaseBookedCount();

            User next = waitlistService.next(slot);
            if (next != null) {
                Center center = centerService.getCenter(slot.getCenterId());

                int price = pricingService.calculatePrice(next, slot, center);

                Booking newBooking = new Booking(next.getId(), slot.getId(), BookingStatus.BOOKED, price);
                slot.getBookings().put(next.getId(), newBooking);
                slot.increaseBookedCount();

                System.out.println("Promoted: " + next.getId() + " price=" + price);
            }

        } finally {
            slot.getLock().unlock();
        }
    }
}