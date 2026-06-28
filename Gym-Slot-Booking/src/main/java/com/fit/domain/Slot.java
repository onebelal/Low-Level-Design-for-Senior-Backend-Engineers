package com.fit.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Slot {
    private String id;
    private int capacity;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String centerId;
    private int bookedCount = 0;
    private int basePrice;
    private Queue<User> waitlist;
    private Map<String, Booking> bookings;
    private ReentrantLock lock ;
    private String workoutType;

    public Slot(String id, String centerId, LocalDate date, LocalTime startTime,  LocalTime endTime,
                String workoutType, int capacity, int basePrice) {
        this.id = id;
        this.centerId = centerId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workoutType = workoutType;
        this.capacity = capacity;
        this.basePrice = basePrice;
        this.waitlist= new LinkedList<>();
        this.bookings= new HashMap<>();
        this.lock=new ReentrantLock();
    }

    public void increaseBookedCount(){
        this.bookedCount++;
    }
    public void decreaseBookedCount(){
        this.bookedCount--;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public int getBasePrice() {
        return basePrice;
    }


    public Queue<User> getWaitlist() {
        return waitlist;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public String getCenterId() {
        return centerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", centerId='" + centerId + '\'' +
                ", bookedCount=" + bookedCount +
                ", basePrice=" + basePrice +
                ", waitlist=" + waitlist +
                ", bookings=" + bookings +
                ", lock=" + lock +
                ", workoutType='" + workoutType + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", capacity=" + capacity +
                ", basePrice=" + basePrice +
                '}';
    }
}
