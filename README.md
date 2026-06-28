# Low-Level Design for Senior Backend Engineers

**Learning Approach**

This repository focuses on two categories of low-level design problems commonly encountered in backend engineering interviews.

The focus is not on memorizing solutions or design patterns. Instead, it demonstrates a structured approach to analyzing requirements, modeling the domain, and building clean, extensible, and maintainable object-oriented systems.

# Problems Covered

* ✅ Gym Slot Booking
* ✅ BookMyShow
* ✅ Elevator System
* ✅ Payment Gateway
* ✅ Job Scheduler


# Problem Solving Framework

After solving multiple real-world LLD problems, I observed that most interview questions can be approached using one of the following design frameworks.

## 1. Concurrency & Storage-Oriented Systems

These systems revolve around coordinating multiple users or threads while maintaining consistency over shared state.

### Characteristics

* Shared mutable state
* Concurrent access
* Storage abstraction
* Synchronization and locking
* Service-oriented architecture
* Scheduling and coordination

### Examples

* Gym Slot Booking
* BookMyShow
* Job Scheduler


## 2. Object-Oriented Domain Modeling

These systems primarily evaluate object-oriented design skills rather than concurrency.

The emphasis is on creating a clean domain model and applying design patterns only where they naturally fit.

### Characteristics

* Rich domain modeling
* SOLID principles
* Encapsulation
* Composition over inheritance
* Extensible business rules
* Strategy and Factory patterns
* State management

### Examples

* Elevator System
* Payment Gateway


# Design Process

Every solution in this repository follows the same design process.

1. Understand and clarify the requirements.
2. Identify the core domain entities.
3. Model relationships between entities.
4. Define business behaviors.
5. Introduce service classes where responsibilities grow.
6. Apply design patterns only when they solve a real design problem.
7. Discuss trade-offs and future extensibility.

This mirrors how production systems are designed instead of forcing design patterns into every solution.


# Design Patterns Covered

* Strategy
* Factory
* Command
* State
* Template Method
* Chain of Responsibility
* Decorator
* Observer


# Software Design Principles

* SOLID Principles
* Composition over Inheritance
* Dependency Injection
* Encapsulation
* Separation of Concerns
* Extensibility


# Goal

The objective of this repository is to build a reusable design mindset rather than memorizing interview solutions.

The same design principles and thought process can be applied to unfamiliar Low-Level Design problems encountered in backend engineering interviews and real-world production systems.
