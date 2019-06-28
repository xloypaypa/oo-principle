**GIVEN** a car and the parking lot with available space  
**WHEN** the car go into parking lot  
**THEN** let it go in, and give a ticket to driver

---
**GIVEN** a car and the parking lot without available space  
**WHEN** the car go into parking lot  
**THEN** not let it go in, and not give ticket to driver

---
**GIVEN** a valid ticket and a parking lot
**WHEN** use this ticket to pick up car  
**THEN** give the car to driver

----
**GIVEN** a invalid ticket and a parking lot
**WHEN** use this ticket to pick up car  
**THEN** no give the car to driver  