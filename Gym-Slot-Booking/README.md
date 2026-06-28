# Gym Slot Booking System

## Problem Statement

Design and implement the backend for a premium fitness booking platform that connects users with multiple gyms and fitness centers.

The objective is to build the core booking engine capable of managing workout inventory, bookings, membership privileges, dynamic pricing, and waitlists.

The solution should be highly extensible so that independent business rules (such as membership benefits and surge pricing) can evolve without impacting existing functionality. It should also be thread-safe and capable of handling concurrent booking requests without data corruption.

---

# Functional Requirements

## A. Center & Inventory Management

The system should support onboarding multiple fitness centers.

Examples:

* FitGym Bellandur, Bangalore
* Gold's Gym Koramangala, Bangalore

Each fitness center can offer multiple workout categories such as:

* Weights
* Cardio
* Yoga
* Swimming

Every workout consists of one or more time slots.

Example:

* 6:00 AM – 7:00 AM Yoga

Each workout slot has a fixed capacity, which determines the maximum number of users allowed to book that slot.

The capacity remains fixed for a given workout and time slot.

The system should allow users to:

* View workout availability for a particular day.
* Search available workouts based on date and location.
* Book a workout.
* View their workout schedule for a specific day.
* Cancel an existing booking.

---

## B. User & Membership Model

The platform supports multiple membership tiers.

* Silver
* Gold
* Platinum

Memberships follow the hierarchy:

Platinum > Gold > Silver

### Booking Privileges

A user can book workout slots belonging to gyms at their own membership tier (or lower) without paying the base booking fee.

If a user books a workout at a higher-tier gym, the configured base price must be paid.

Example:

* Gold member → Gold Gym → Free
* Platinum member → Gold Gym → Free
* Silver member → Gold Gym → Base Price

---

## C. Dynamic Pricing & Booking Engine

The booking engine should evaluate multiple independent business rules before determining the final booking status and price.

### Membership Rule

Apply membership privileges to determine whether the base booking price should be charged.

### Surge Pricing

When the occupancy of a workout slot exceeds 80%, an additional surge charge is applied.

Example:

* Base Price = ₹500
* Surge Charge = ₹100

The surge charge applies to every user, including members who would otherwise receive complimentary bookings.

### Waitlist

When a workout slot reaches full capacity:

* New users should be added to a waitlist.
* If a confirmed booking is cancelled, the first user in the waitlist is automatically promoted.
* The booking price should be recalculated during promotion because pricing conditions may have changed.

For example, a user promoted from the waitlist may no longer be charged surge pricing if the occupancy has dropped below the configured threshold.

---

# Constraints

* Write clean, modular, and maintainable code.
* Focus on object-oriented design and extensibility.
* Use appropriate design patterns wherever applicable.
* Handle concurrent booking requests safely.
* Use only in-memory data structures.
* No external database is required.
* No user interface is required.
* Provide a simple Driver/Main class demonstrating multiple scenarios.

---

# Evaluation Focus

The implementation should emphasize:

* Functional correctness
* Code readability
* Proper entity modeling
* Separation of concerns
* Modularity
* Extensibility
* Appropriate abstractions
* Thread safety
* Use of suitable design patterns

---

# Sample Scenarios

## Scenario 1 – Membership Pricing

### Setup

Create a Gold-tier gym with a base booking price of ₹500.

### Action A

A Gold member books a workout slot.

### Expected

Booking Successful

Price: ₹0

### Action B

A Silver member books the same workout slot.

### Expected

Booking Successful

Price: ₹500

---

## Scenario 2 – Surge Pricing

### Setup

Create a Platinum-tier workout slot with a capacity of 10 seats.

Current occupancy: 8 seats (80%).

### Action

A Platinum member books the workout.

### Expected

Booking Successful

Price: ₹100

Although the membership covers the base booking fee, surge pricing still applies.

---

## Scenario 3 – Waitlist Promotion

### Setup

The workout slot has reached maximum capacity.

User A is currently in the waitlist.

### Action

A confirmed booking is cancelled.

### Expected

User A is automatically promoted from the waitlist to a confirmed booking.

---

## Scenario 4 – Concurrent Booking

### Setup

Only one seat remains in a workout slot.

### Action

Ten concurrent booking requests attempt to reserve the remaining seat.

### Expected

* Exactly one booking succeeds.
* Remaining users either fail or join the waitlist.
* Slot capacity remains consistent with no data corruption.

