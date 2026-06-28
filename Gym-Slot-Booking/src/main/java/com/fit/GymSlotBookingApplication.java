package com.fit;

import com.fit.domain.Booking;
import com.fit.domain.Center;
import com.fit.domain.Slot;
import com.fit.domain.User;
import com.fit.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GymSlotBookingApplication {
    public static void main(String[] args) throws Exception {

        CenterService centerService = new CenterService();
        SlotService slotService = new SlotService();
        WaitlistService waitlistService = new WaitlistService();

        PricingService pricingService = new PricingService(
                List.of(new MembershipRule(), new SurgePricingRule())
        );

        BookingService bookingService =
                new BookingService(pricingService, centerService, waitlistService);


        System.out.println("=== Scenario 1 ===");

        Center goldGym = new Center("C1", "Gold Gym", MembershipTier.GOLD,"Bangalore");
        Slot slot1 = new Slot("S1", "C1", LocalDate.now(), LocalTime.of(9,00), LocalTime.of(10,00), "Yoga", 10, 500);
        centerService.addCenter(goldGym);
        slotService.addSlot(slot1);

        User goldUser = new User("U1", MembershipTier.GOLD);
        User silverUser = new User("U2", MembershipTier.SILVER);

        System.out.println(bookingService.book(goldUser, slot1).getPrice());
        System.out.println(bookingService.book(silverUser, slot1).getPrice());


        System.out.println("=== Scenario 2 ===");

        Center platinumGym = new Center("C2", "Platinum Gym",  MembershipTier.PLATINUM,"Bangalore");
        centerService.addCenter(platinumGym);

        Slot slot2 = new Slot("S2", "C2", LocalDate.now(), LocalTime.of(10,00), LocalTime.of(11,00),"Cardio", 10, 500);
        slotService.addSlot(slot2);

        for (int i = 0; i < 8; i++) {
            bookingService.book(new User("X" + i, MembershipTier.PLATINUM), slot2);
        }

        User pUser = new User("P1", MembershipTier.PLATINUM);
        System.out.println(bookingService.book(pUser, slot2).getPrice());


        System.out.println("=== Scenario 3 ===");

        Slot slot3 = new Slot("S3", "C1", LocalDate.now(), LocalTime.of(12,00), LocalTime.of(13,00), "Yoga", 1, 500);
        slotService.addSlot(slot3);

        User u1 = new User("A", MembershipTier.GOLD);
        User u2 = new User("B", MembershipTier.GOLD);

        bookingService.book(u1, slot3);
        bookingService.book(u2, slot3);

        bookingService.cancel(u1, slot3);

        Slot slot4 = new Slot("S4", "C1",LocalDate.of(2026,03,18), LocalTime.of(7,00), LocalTime.of(8,00), "Yoga", 1, 500);
        slotService.addSlot(slot4);


        System.out.println("=== Scenario 4 ===");

        System.out.println(slotService.getSlot(slot4.getId()));

        System.out.println("=== Scenario 5 ===");

        System.out.println(slotService.getSlotByCenter("C1"));

        System.out.println("=== Scenario 6 ===");

        System.out.println(slotService.searchByDateAndLocation("Bangalore",LocalDate.parse("2026-03-18"),centerService));

        System.out.println("=== Scenario 7 ===");

        System.out.println(slotService.searchByDate(LocalDate.parse("2026-03-18"),centerService));

        System.out.println("=== Scenario 8 ===");
        Runnable task = () -> {
            User user = new User(UUID.randomUUID().toString(), MembershipTier.GOLD);
            Booking b = bookingService.book(user, slot4);
            System.out.println(Thread.currentThread().getName() + " -> " + b.getStatus());
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(task);
            threads.add(t);
            t.start();
        }


    }

}
