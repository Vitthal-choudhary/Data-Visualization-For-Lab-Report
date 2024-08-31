CREATE DATABASE lab_reports;
USE lab_reports;

CREATE TABLE blood_test (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result FLOAT,
    normal_range VARCHAR(20),
    unit VARCHAR(10)
);

INSERT INTO blood_test (attribute, your_result, normal_range, unit)
VALUES 
('WBC', NULL, '4.5 - 11.0', 'K/UL'),
('RBC', NULL, '3.5 - 5.5', 'MIL/UL'),
('HAEMOGLOBIN', NULL, '12.0 - 15.0', 'G/DL'),
('HEMATOCRIT', NULL, '36.0 - 48.0', '%'),
('MCV', NULL, '79.0 - 101.0', 'FL'),
('MCH', NULL, '25.0 - 35.0', 'PG'),
('MCHC', NULL, '31.0 - 37.0', '%'),
('RDW-CV', NULL, '11.0 - 16.0', 'FL'),
('PLATELET COUNT', NULL, '150 - 420', 'K/UL'),
('MPV', NULL, '7.0 - 10.0', 'FL');


CREATE TABLE urinalysis (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result FLOAT,
    normal_range VARCHAR(20)
);

INSERT INTO urinalysis (attribute, your_result, normal_range)
VALUES 
('COLOR URINE', NULL, ''),
('APPEARANCE URINE', NULL, 'CLEAR'),
('SPECIFIC GRAVITY URINE IRIS', NULL, '1.001-1.035'),
('PH URINE', NULL, '5.0-8.0'),
('PROTIEN URINE', NULL, 'NEGATIVE'),
('GLUCOSE URINE IRIS', NULL, 'NEGATIVE'),
('KETONE URINE', NULL, 'NEGATIVE'),
('BILIRUBIN URINE', NULL, 'NEGATIVE'),
('BLOOD URINE', NULL, 'NEGATIVE'),
('NITRITE URINE', NULL, 'NEGATIVE'),
('UROBILINOGEN URINE', NULL, '<2mg/dL'),
('LEUKOCYTE ESTERASE URINE', NULL, 'NEGATIVE');

CREATE TABLE thyroid_test (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result FLOAT,
    normal_range VARCHAR(20),
    unit VARCHAR(10)
);

INSERT INTO thyroid_test (attribute, your_result, normal_range, unit)
VALUES 
('T4', NULL, '11.0-21.0', 'pmol/L'),
('T3', NULL, '3.1-6.0', 'pmol/L'),
('TSH', NULL, '0.5-5.0', 'mU/L');

CREATE TABLE diabetes_test_report (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result FLOAT,
    normal_range VARCHAR(20),
    unit VARCHAR(10)
);

INSERT INTO diabetes_test_report (attribute, your_result, normal_range, unit)
VALUES 
('FASTING BLOOD SUGAR (FBS)', NULL, 'Less than 100', 'mg/dL'),
('POSTPRANDIAL BLOOD SUGAR (PPBS)', NULL, 'Less than 140', 'mg/dL'),
('HAEMOGLOBIN A1c (HbA1c)', NULL, 'Less than 5.7', '%');

SELECT * FROM diabetes_test_report;

CREATE TABLE sexually_transmitted_test (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result VARCHAR(20),
    normal_range VARCHAR(20)
);

INSERT INTO sexually_transmitted_test (attribute, your_result, normal_range)
VALUES 
('HERPES SIMPLEX 1', NULL, 'NEGATIVE'),
('HERPES SIMPLEX 2', NULL, 'NEGATIVE'),
('HIV', NULL, 'NEGATIVE'),
('CHLAMYDIA', NULL, 'NEGATIVE'),
('GONORRHEA', NULL, 'NEGATIVE'),
('SYPHILLIS', NULL, 'NEGATIVE'),
('HEPATITIS A', NULL, 'NEGATIVE'),
('HEPATITIS B', NULL, 'NEGATIVE'),
('HEPATITIS C', NULL, 'NEGATIVE');

CREATE TABLE CholesterolTest (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result DECIMAL(5,2) NULL,
    normal_range VARCHAR(50) NULL,
    unit VARCHAR(10) DEFAULT 'mg/dL'
);

INSERT INTO CholesterolTest (attribute, your_result, normal_range, unit) VALUES
('TOTAL CHOLESTROL', NULL, 'Less than 200', 'mg/dL'),
('LDL CHOLESTROL', NULL, 'Less than 130', 'mg/dL'),
('HDL CHOLESTROL', NULL, 'Greater than 60', 'mg/dL'),
('TRIGLYCERIDES', NULL, 'Less than 150', 'mg/dL'),
('NON-HDL-C', NULL, 'Less than 130', 'mg/dL'),
('TG TO HDL RATIO', NULL, 'Less than 3', 'mg/dL');

SELECT * FROM CholesterolTest;

CREATE TABLE DrugTest (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result DECIMAL(5,2) NULL,
    normal_range VARCHAR(50) NULL,
    unit VARCHAR(10) DEFAULT 'ng/mL'
);

INSERT INTO DrugTest (attribute, your_result, normal_range, unit) VALUES
('AMPHETAMINES', NULL, '1000', 'ng/mL'),
('BARBITURATES', NULL, '300', 'ng/mL'),
('BENZODIAZEPINES', NULL, '300', 'ng/mL'),
('COCAINE METABOLITES', NULL, '300', 'ng/mL'),
('MARIJUANA METABOLITES', NULL, '50', 'ng/mL'),
('MATHADONE', NULL, '300', 'ng/mL'),
('METHAQUALONE', NULL, '300', 'ng/mL'),
('OPIATES', NULL, '300', 'ng/mL'),
('PHENCYCLIDINE', NULL, '25', 'ng/mL'),
('PROPOXYPHENE', NULL, '300', 'ng/mL');

CREATE TABLE AllergyTest (
    attribute VARCHAR(50) PRIMARY KEY,
    your_result DECIMAL(5,2) NULL,
    normal_range VARCHAR(100) NULL,
    unit VARCHAR(10) DEFAULT 'kU/L'
);


INSERT INTO AllergyTest (attribute, your_result, normal_range, unit) VALUES
('Scallop', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Cashew Nut', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Egg White', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Cow\'s Milk', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('CodFish', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Wheat', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Sesame Seed', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Peanut', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Soybean', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Almond', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Shrimp', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Tuna', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Salmon', NULL, '<0.10  [If more than that, then allergic]', 'kU/L'),
('Walnut', NULL, '<0.10  [If more than that, then allergic]', 'kU/L');










