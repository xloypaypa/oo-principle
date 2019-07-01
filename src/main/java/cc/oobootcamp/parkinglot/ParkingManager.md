**Given** the parking manager mange the parking boy who have available parking lot
**When** the parking manager park the car
**Then** the car is parked by the parking boy and give a ticket

---
**Given** the parking manager have available parking lot, the parking boys not have available parking lot 
**When** the parking boy park the car
**Then** the car is parked by the manager and give a ticket

---
**Given** both manager and parking boy not have available space
**When** the parking boy park the car
**Then** should get a error and not give any ticket

---
**Given** there is a ticket is matching the car which was parked by parking manager 
**When** use this ticket to get a car from parking manager
**Then** should get a car

---
**Given** there is a ticket isn't matching any car parked by parking manager
**When** use this ticket to get a car from parking manager
**Then** should get a error and not get any car
