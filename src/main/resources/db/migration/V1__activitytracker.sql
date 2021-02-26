CREATE TABLE activities
		(id BIGINT AUTO_INCREMENT,
		start_time TIMESTAMP,
		activity_desc VARCHAR(255),
		activity_type VARCHAR(255),
        PRIMARY KEY (id));

CREATE TABLE track_points (
    id bigint AUTO_INCREMENT,
    activ_time DATE,
    lat DOUBLE,
    lon DOUBLE,
    activ_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (activ_id) REFERENCES activities (id)
);