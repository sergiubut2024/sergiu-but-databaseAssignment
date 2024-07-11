-- Crearea bazei de date
CREATE DATABASE IF NOT EXISTS booking;

-- Utilizarea bazei de date
USE booking;

-- Crearea tabelelor
CREATE TABLE IF NOT EXISTS accommodation (
    id INT PRIMARY KEY,
    type VARCHAR(32),
    bed_type VARCHAR(32),
    max_guests INT,
    description VARCHAR(512)
);

CREATE TABLE IF NOT EXISTS room_fair (
    id INT PRIMARY KEY,
    value DOUBLE,
    season VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS accommodation_room_fair_relation (
    id INT PRIMARY KEY,
    accommodation_id INT,
    room_fair_id INT,
    FOREIGN KEY (accommodation_id) REFERENCES accommodation(id),
    FOREIGN KEY (room_fair_id) REFERENCES room_fair(id)
);

-- Inserarea datelor în tabelul accommodation
INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES
    (1, 'Hotel Room', 'Queen', 2, 'A cozy hotel room with queen bed.'),
    (2, 'Suite', 'King', 4, 'A luxurious suite with a king-size bed and living area.'),
    (3, 'Single Room', 'Single', 1, 'A small room with a single bed for one guest.');

-- Inserarea datelor în tabelul room_fair
INSERT INTO room_fair (id, value, season) VALUES
    (1, 100.0, 'Summer'),
    (2, 150.0, 'Winter'),
    (3, 75.0, 'Spring');

-- Inserarea datelor în tabelul accommodation_room_fair_relation
INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);
