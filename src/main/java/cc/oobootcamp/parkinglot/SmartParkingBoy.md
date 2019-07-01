**Given** there are two parking lots with different space
**When** the parking boy park the car
**Then** the car is parked to the parking lot with more space

---
**Given** there are two parking lots with same space
**When** the parking boy park the car
**Then** the car is parked to first parking lot

---
**Given** there are two parking lot both of them not have space
**When** the parking boy park the car
**Then** should get a error and not give any ticket

---
**Given** there is a ticket is matching the car which was parked by parking boy 
**When** use this ticket to get a car from parking boy
**Then** should get a car

---
**Given** there is a ticket isn't matching any car parked by parking boy 
**When** use this ticket to get a car from parking boy
**Then** should get a error and not get any car
