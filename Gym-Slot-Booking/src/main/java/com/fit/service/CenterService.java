package com.fit.service;

import com.fit.domain.Center;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CenterService {
    private Map<String, Center> centers = new HashMap<>();

    public void addCenter(Center center) {
        centers.put(center.getId(), center);
    }

    public Center getCenter(String centerId) {
        return centers.get(centerId);
    }

    public Collection<Center> getAll() {
        return centers.values();
    }
}