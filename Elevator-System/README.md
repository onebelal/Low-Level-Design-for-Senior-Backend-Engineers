# Elevator System

## Functional Requirements

The system should support:

* Create a building with configurable floors and elevators.
* Each elevator maintains its own state.
* A user on any floor can request an elevator by pressing:

    * **UP**
    * **DOWN**
* The scheduler assigns the most appropriate elevator.
* Once inside the elevator, the passenger selects the destination floor.
* The elevator moves one floor at a time.
* The elevator door opens when the destination floor is reached.
* After passengers enter or exit, the door closes.
* The elevator continues serving the remaining requests.
* Idle elevators remain at their last served floor until a new request arrives.

---

## Non-Functional Requirements

* No two elevators should be assigned the same external request.
* The scheduler should minimize passenger waiting time.
* The elevator should avoid unnecessary direction changes.
* The elevator should complete all requests in the current direction before reversing whenever possible.
* The design should be extensible to support multiple scheduling algorithms.
