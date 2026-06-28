package com.fit.service;


import com.fit.domain.PricingContext;

public class MembershipRule implements PricingRule {
    @Override
    public int calculatePrice(PricingContext pricingContext, int price) {
        if (pricingContext.getUser().getTier().isHigherOrEqual(pricingContext.getCenter().getTier())) {
            return 0;
        }
        return pricingContext.getSlot().getBasePrice();
    }
}