# Story1

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
# Story2

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

---
# Story3

**Given** parking boy who has 2 parking lots 10 cars

**When** check parking order

**Then** return 1 full parking lot 1 empty parking lot

---
**Given** parking boy who has 2 parking lots 12 cars

**When** check parking order

**Then** return 1 full parking lot 1 parking lot has 2 cars

# Story4

**Given** parking lots has 2 cars and 0 cars 1 car

**When** check parking order

**Then** return parking lots has 2 cars and 1 car

---
**Given** parking lots has 0 cars and 2 cars 1 car

**When** check parking order

**Then** return parking lots has 1 car and 2 cars

---
**Given** parking lots has 1 cars and 1 cars 1 car

**When** check parking order

**Then** return parking lots has 2 cars and 1 car