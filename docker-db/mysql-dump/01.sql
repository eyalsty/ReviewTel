CREATE TABLE countries (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name TINYTEXT  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cities (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name TINYTEXT  NOT NULL,
    country_id TINYTEXT  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE hotels (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    name TINYTEXT  NOT NULL,
    address TINYTEXT  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reviews (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    hotel_id TINYTEXT  NOT NULL,
    national_id TINYTEXT  NOT NULL,
    positive_review TEXT NOT NULL,
    negative_review TEXT NOT NULL,
    score FLOAT,
    trip_type TINYTEXT  NOT NULL,
    composition SMALLINT NOT NULL,
    vacation_length SMALLINT,
    PRIMARY KEY (id)
);

CREATE TABLE compositions (
    id SMALLINT NOT NULL AUTO_INCREMENT,
    guests_composition TINYTEXT  NOT NULL,
    room_type TINYTEXT  NOT NULL,
    PRIMARY KEY (id)
);

LOAD DATA LOCAL INFILE "//tables//reviews_table.csv" INTO TABLE reviews
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
(id,hotel_id,date,national_id,negative_review,positive_review,score,trip_type,composition,vacation_length)
set date=STR_TO_DATE(@datevar, '%m%d%Y');

LOAD DATA LOCAL INFILE "//tables//cities_table.csv" INTO TABLE cities
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
(id,name,country_id);

LOAD DATA LOCAL INFILE "//tables//countries_table.csv" INTO TABLE countries
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
(id,name);

LOAD DATA LOCAL INFILE "//tables//hotels_table.csv" INTO TABLE hotels
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
(id,name,address);
