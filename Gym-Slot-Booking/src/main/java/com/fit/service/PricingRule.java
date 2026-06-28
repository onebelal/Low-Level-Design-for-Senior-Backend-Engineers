package com.fit.service;

import com.fit.domain.PricingContext;

public interface PricingRule {
    int calculatePrice(PricingContext pricingContext, int currentPrice);
}