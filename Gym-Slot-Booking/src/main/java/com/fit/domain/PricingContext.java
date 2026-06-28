package com.fit.domain;

public class PricingContext {
    private User user;
    private Slot slot;
    private Center center;

    public PricingContext(User user, Slot slot, Center center) {
        this.user = user;
        this.slot = slot;
        this.center=center;
    }

    public User getUser() {
        return user;
    }

    public Slot getSlot() {
        return slot;
    }

    public Center getCenter() {
        return center;
    }
}