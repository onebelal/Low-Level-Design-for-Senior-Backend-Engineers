package com.fit.service;

import com.fit.domain.Center;
import com.fit.domain.PricingContext;
import com.fit.domain.Slot;
import com.fit.domain.User;

import java.util.*;

public class PricingService {

    private List<PricingRule> rules;

    public PricingService(List<PricingRule> rules) {
       this.rules = rules;
    }

    public int calculatePrice(User user, Slot slot, Center center) {
        PricingContext pricingContext = new PricingContext(user, slot, center);
        int price = 0;
        for (PricingRule rule : rules) {
            price = rule.calculatePrice(pricingContext, price);
        }
        return price;
    }
}