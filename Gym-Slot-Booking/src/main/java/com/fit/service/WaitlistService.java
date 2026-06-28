package com.fit.service;

import com.fit.domain.Slot;
import com.fit.domain.User;

public class WaitlistService {

    public void add(Slot slot, User user) {
        slot.getWaitlist().add(user);
    }

    public User next(Slot slot) {
        return slot.getWaitlist().poll();
    }
}