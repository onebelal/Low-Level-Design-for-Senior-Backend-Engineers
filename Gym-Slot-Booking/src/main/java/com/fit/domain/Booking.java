package com.fit.domain;

public class Booking {
    private String userId;
    private String slotId;
    private BookingStatus status;
    private int price;

    public Booking(String userId, String slotId, BookingStatus status, int price) {
        this.userId = userId;
        this.slotId = slotId;
        this.status = status;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public String getSlotId() {
        return slotId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public void setStatus(BookingStatus bookingStatus) {
        this.status=bookingStatus;
    }
}
