package com.fit.service;

import com.fit.domain.Center;
import com.fit.domain.Slot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotService {
    private Map<String, Slot> slots = new HashMap<>();
    private Map<String, List<Slot>> slotsByCenter = new HashMap<>();

    public void addSlot(Slot slot) {
        slots.put(slot.getId(), slot);
        slotsByCenter.computeIfAbsent(slot.getCenterId(), k -> new ArrayList<>()).add(slot);
    }

    public Slot getSlot(String slotId) {
        return slots.get(slotId);
    }

    public List<Slot> getSlotByCenter(String centerId) {
        return slotsByCenter.get(centerId);
    }
    public List<Slot> searchByDateAndLocation(String location, LocalDate date, CenterService centerService) {
        List<Slot> result = new ArrayList<>();

        for (Center center : centerService.getAll()) {
            if (center.getLocation().equalsIgnoreCase(location)) {
                for (Slot slot : slotsByCenter.getOrDefault(center.getId(), List.of())) {
                    if (slot.getDate().equals(date)) {
                        result.add(slot);
                    }
                }
            }
        }
        return result;
    }
    public List<Slot> searchByDate(LocalDate date, CenterService centerService) {
        List<List<Slot>> result = centerService.getAll().stream().map(s->slotsByCenter.getOrDefault(s.getId(), List.of())).toList();
        return result.stream().flatMap(s->s.stream().filter(slot -> slot.getDate().equals(date))).toList();
    }
}