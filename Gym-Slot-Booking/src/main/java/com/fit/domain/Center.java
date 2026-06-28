package com.fit.domain;

import com.fit.service.MembershipTier;

public class Center {

   private String id;
   private String name;
   private MembershipTier tier;
   private String location;


    public Center(String id, String name, MembershipTier tier, String location) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.location=location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public String getLocation() {
        return location;
    }
}
