USE booking;

INSERT INTO accommodation (id, type, bed_type, max_guests, description)
VALUES
    (1, 'Hotel Room', 'Queen', 2, 'A cozy hotel room with queen bed.'),
    (2, 'Suite', 'King', 4, 'A luxurious suite with a king-size bed and living area.'),
    (3, 'Single Room', 'Single', 1, 'A small room with a single bed for one guest.');

INSERT INTO room_fair (id, value, season)
VALUES
    (1, 100.0, 'Summer'),
    (2, 150.0, 'Winter'),
    (3, 75.0, 'Spring');

INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);
