CREATE TABLE room(
    roomid VARCHAR(3) CONSTRAINT pk_roomid PRIMARY KEY,
    roomnumber VARCHAR(3),
    hasfirstaidkit BOOLEAN);

CREATE TABLE gp(
    gpid VARCHAR(3) CONSTRAINT pk_gpid PRIMARY KEY,
    firstname VARCHAR(24),
    lastname VARCHAR(24),
    employeesince DATE);

CREATE TABLE patient(
    patientid VARCHAR(7) CONSTRAINT pk_patientid PRIMARY KEY,
    firstname VARCHAR(24),
    lastname VARCHAR(24),
    dob DATE);

CREATE TABLE appointment(
    appointmentid VARCHAR(10) CONSTRAINT pk_appointmentid PRIMARY KEY,
    apptime TIMESTAMP,
    roomid VARCHAR(3),
    gpid VARCHAR(3),
    patientid VARCHAR(7),
    CONSTRAINT fk_appointment_roomid FOREIGN KEY (roomid) REFERENCES room(roomid),
    CONSTRAINT fk_appointment_gpid FOREIGN KEY (gpid) REFERENCES gp(gpid),
    CONSTRAINT fk_appointment_patientid FOREIGN KEY (patientid) REFERENCES patient(patientid));

CREATE TABLE prescription(
    prescriptionid VARCHAR(10) CONSTRAINT pk_prescriptionid PRIMARY KEY,
    substance VARCHAR(30),
    gpid VARCHAR(3),
    patientid VARCHAR(7),
    CONSTRAINT fk_prescription_gpid FOREIGN KEY (gpid) REFERENCES gp(gpid),
    CONSTRAINT fk_prescription_patientid FOREIGN KEY (patientid) REFERENCES patient(patientid));
