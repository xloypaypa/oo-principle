**GIVEN** a car and the parking lot with available space  
**WHEN** the car go into parking lot  
**THEN** let it go in, and give a ticket 

---
**GIVEN** a car and the parking lot without available space  
**WHEN** the car go into parking lot  
**THEN** not let it go in, and not give ticket  

---
**GIVEN** a valid ticket and a parking lot
**WHEN** use this ticket to pick up car  
**THEN** show "Successfully." and give the car

----
**GIVEN** a invalid ticket and a parking lot
**WHEN** use this ticket to pick up car  
**THEN** show "Invalid ticket."  