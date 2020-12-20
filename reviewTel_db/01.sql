CREATE TABLE countries (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cities (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100)  NOT NULL,
    country_id SMALLINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE hotels (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255)  NOT NULL,
    city_id SMALLINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE guests_compositions (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    guests_composition VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE room_types (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    room_type VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reviews (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    hotel_id SMALLINT  NOT NULL,
    date DATE NOT NULL,
    national_id SMALLINT  NOT NULL,
    positive_review VARCHAR(5000) NOT NULL,
    negative_review VARCHAR(5000) NOT NULL,
    score FLOAT,
    trip_type VARCHAR(100)  NOT NULL,
    guests_composition_id SMALLINT NOT NULL,
    room_type_id SMALLINT NOT NULL,
    vacation_length SMALLINT,
    PRIMARY KEY (id),
    FOREIGN KEY (hotel_id) REFERENCES hotels(id),
    FOREIGN KEY (national_id) REFERENCES countries(id),
    FOREIGN KEY (guests_composition_id) REFERENCES guests_compositions(id),
    FOREIGN KEY (room_type_id) REFERENCES room_types(id)
);

LOAD DATA LOCAL INFILE "~/reviewTel_db/countries_table.csv" INTO TABLE countries
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,name);

LOAD DATA LOCAL INFILE "~/reviewTel_db/cities_table.csv" INTO TABLE cities
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,name,country_id);

LOAD DATA LOCAL INFILE "~/reviewTel_db/hotels_table.csv" INTO TABLE hotels
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,name,address,city_id);

LOAD DATA LOCAL INFILE "~/reviewTel_db/guests_compositions_table.csv" INTO TABLE guests_compositions
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,guests_composition);

LOAD DATA LOCAL INFILE "~/reviewTel_db/room_types_table.csv" INTO TABLE room_types
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,room_type);

LOAD DATA LOCAL INFILE "~/reviewTel_db/reviews_table.csv" INTO TABLE reviews
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id,hotel_id,@datevar,national_id,negative_review,positive_review,score,trip_type,guests_composition_id,room_type_id,vacation_length)
set date=STR_TO_DATE(@datevar, '%m/%d/%Y');