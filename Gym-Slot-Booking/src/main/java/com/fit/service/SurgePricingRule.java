package com.fit.service;

import com.fit.domain.PricingContext;

public class SurgePricingRule implements PricingRule {

    @Override
    public int calculatePrice(PricingContext pricingContext, int price) {
        double occupancy = (double) pricingContext.getSlot().getBookedCount() / pricingContext.getSlot().getCapacity();

        if (occupancy >= 0.8) {
            return price + 100;
        }
        return price;
    }
}