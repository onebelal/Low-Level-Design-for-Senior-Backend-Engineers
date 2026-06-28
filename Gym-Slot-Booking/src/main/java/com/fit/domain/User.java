package com.fit.domain;

import com.fit.service.MembershipTier;

public class User {
    private String id;
    private MembershipTier tier;

    public User(String id, MembershipTier tier) {
        this.id = id;
        this.tier = tier;
    }

    public String getId() {
        return id;
    }

    public MembershipTier getTier() {
        return tier;
    }

}
