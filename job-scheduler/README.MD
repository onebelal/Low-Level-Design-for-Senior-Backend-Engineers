# Job Scheduler

## Overview

This project implements an in-memory **Job Scheduler** using Java. It demonstrates how production schedulers manage job scheduling, execution, retries, and lifecycle management while following Object-Oriented Design principles and common design patterns.

The implementation is modular, extensible, and focuses on clean abstractions rather than framework-specific implementations.

## Functional Requirements

The scheduler supports the following operations:

* Schedule a job for immediate execution.
* Schedule a job after a configurable delay.
* Schedule recurring jobs.
* Execute jobs asynchronously using a worker thread pool.
* Pause a scheduled job.
* Resume a paused job.
* Cancel a scheduled job.
* Retry failed jobs using configurable retry strategies.
* Track job execution status.

## Non-Functional Requirements

* Thread-safe scheduling.
* Extensible scheduling mechanism.
* Extensible retry strategies.
* Separation of concerns.
* Easy to replace in-memory storage with persistent storage.
* Clean object-oriented design.

## Design Patterns Used

### Command Pattern

Every job encapsulates executable business logic behind a common interface.

Examples:

* Email Job
* Report Generation Job
* Cleanup Job

### Strategy Pattern

Used for interchangeable retry policies.

Examples:

* Fixed Retry Strategy
* Exponential Backoff (can be added)
* No Retry Strategy


### Polymorphism

Different trigger implementations encapsulate their own scheduling behavior.

* ImmediateTrigger
* DelayedTrigger
* RecurringTrigger

The scheduler never needs to know which trigger it is executing.


## Core Components

### Job

Represents a schedulable unit of work.

Responsibilities:

* Holds job metadata
* Maintains execution status
* Associates executor and trigger


### JobTrigger

Determines when a job should execute.

Implementations:

* ImmediateTrigger
* DelayedTrigger
* RecurringTrigger


### JobExecutor

Encapsulates business logic executed by the scheduler.

### RetryStrategy

Determines how failed jobs should be retried.

### JobRepository

Stores scheduled jobs using an in-memory concurrent map.


### JobScheduler

Coordinates scheduling, execution, retries, and job lifecycle.


## Project Structure

```
job-scheduler
├── entity
│   ├── Job
│   ├── JobStatus
│   └── JobTrigger
│
├── trigger
│   ├── ImmediateTrigger
│   ├── DelayedTrigger
│   └── RecurringTrigger
│
├── scheduler
│   ├── Scheduler
│   └── DefaultJobScheduler
│
├── repository
│   └── JobRepository
│
├── executor
│   ├── JobExecutor
│   └── EmailJobExecutor
│
├── retry
│   ├── RetryStrategy
│   └── FixedRetryStrategy
│
└── JobSchedulerDemo
```

---

## Future Improvements

* Cron expression support
* Priority-based scheduling
* Distributed scheduler
* Persistent job store
* Dead Letter Queue (DLQ)
* Exponential backoff retry policy
* Metrics and monitoring
* Graceful scheduler shutdown
* Job dependency management

