CREATE DATABASE IF NOT EXISTS booking;

USE booking;

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