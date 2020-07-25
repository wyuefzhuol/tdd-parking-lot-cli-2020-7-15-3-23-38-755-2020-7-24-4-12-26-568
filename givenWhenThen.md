---
**Given** parking boy 1 car

**When** parking boy parking car

**Then** return 1 ticket

---
**Given** parking boy 1 ticket 1 car in parking lot

**When** parking boy fetch car

**Then** return 1 car

---
**Given** parking boy 2 cars

**When** parking boy parking car

**Then** return 2 tickets

---
**Given** parking boy 2 tickets 2 cars in parking lot

**When** parking boy fetch car

**Then** return 2 cars

---
**Given** parking boy wrong ticket

**When** parking boy fetch car

**Then** return the ticket is wrong

---
**Given** parking boy used ticket

**When** parking boy fetch car

**Then** return the ticket has been used

---
**Given** parking boy parking lot car

**When** parking boy parking car

**Then** return parking lot has no position

---
**Given** parking boy wrong ticket

**When** check ticket

**Then** return unrecognized parking ticket

---
**Given** parking boy used ticket

**When** check ticket

**Then** return unrecognized parking ticket

---
**Given** parking boy

**When** check ticket

**Then** return please provide your parking ticket

---
**Given** parking boy parking lot car

**When** check parking lot position 

**Then** return not enough position