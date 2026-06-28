package com.fit.service;

public enum MembershipTier {

    SILVER, GOLD, PLATINUM;

    public boolean isHigherOrEqual(MembershipTier membershipTier) {
        return this.ordinal() >= membershipTier.ordinal();
    }
}
