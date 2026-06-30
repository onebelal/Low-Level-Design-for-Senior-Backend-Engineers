# Pluggable In-Memory Cache

## Overview

This project implements a simple **in-memory cache** with configurable eviction policies and per-entry **Time-To-Live (TTL)**. The design is modular and extensible, making it easy to plug in new eviction strategies.

---

## Functional Requirements

The cache supports the following operations:

* `put(key, value, ttl)` – Store a key-value pair with an optional TTL.
* `get(key)` – Retrieve a value if it exists and has not expired.
* Configurable maximum cache capacity.
* Automatic eviction when capacity is reached.
* Automatic removal of expired entries.
* Pluggable eviction strategies.
* Background TTL cleanup

---

## Non-Functional Requirements

* Generic key and value types.
* Bounded in-memory storage.
* Extensible eviction framework.
* Clean Object-Oriented Design.

---

## Design Patterns Used

* **Strategy Pattern** – Pluggable eviction policies (LRU, LFU, FIFO).
* **Factory Pattern** – Creates cache with different eviction strategies.

---


## Future Improvements

* Thread-safe implementation
* LFU Implementation
* Cache statistics (Hit/Miss)
* Distributed cache support
* Write-through / Write-back caching
