create database Lab_Data;

use Lab_Data;

create table blood_test(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    WBC DECIMAL(5,2),
    RBC DECIMAL(5,2),
    HAEMOGLOBIN DECIMAL(5,2),
    HEMATOCRIT DECIMAL(5,2),
    MCV DECIMAL(5,2),
    MCH DECIMAL(5,2),
    MCHC DECIMAL(5,2),
    RDW_CV DECIMAL(5,2),
    PLATELET_COUNT DECIMAL(5,2),
    MPV DECIMAL(5,2)
);

create table Urinalysis(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    COLOR_URINE VARCHAR(10),
    PROTEIN_URINE VARCHAR(10),
    GLUCOSE_URINE_IRIS VARCHAR(10),
    KETONE_URINE VARCHAR(10),
    BILIRUBIN_URINE VARCHAR(10),
    NITRITE_URINE VARCHAR(10),
    LEUKOCYTE_ESTERASE_URINE VARCHAR(10),
    UROBILINOGEN_URINE DECIMAL(5,2),
    PH_URINE DECIMAL(5,2)
);

create table thyroid(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    T4 DECIMAL(5,2),
    T3 DECIMAL(5,2),
    TSH DECIMAL(5,2)
);

create table diabetes(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    Fasting_Blood_Sugar DECIMAL(5,2),
    Post_Prandial_Blood_Sugar DECIMAL(5,2),
    HAEMOGLOBIN_A1c DECIMAL(5,2)
);

create table Sexual_Disease(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    Herpes_Simplex_1 VARCHAR(9) default "NEGATIVE",
    Herpes_Simplex_2 VARCHAR(9) default "NEGATIVE",
    HIV VARCHAR(9) default "NEGATIVE",
    Chlamydia VARCHAR(9) default "NEGATIVE",
    Gonorrhea VARCHAR(9) default "NEGATIVE",
    Syphilis VARCHAR(9) default "NEGATIVE",
    Hepatitis_A VARCHAR(9) default "NEGATIVE",
    Hepatitis_B VARCHAR(9) default "NEGATIVE",
    Hepatitis_C VARCHAR(9) default "NEGATIVE"
);

CREATE TABLE Cholesterol(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    Total_Cholesterol DECIMAL(5,2),
    LDL_Cholesterol DECIMAL(5,2),
    HDL_Cholesterol DECIMAL(5,2),
    Triglycerides DECIMAL(5,2),
    Non_HDL_Cholesterol DECIMAL(5,2),
    TG_To_HDL_Ratio DECIMAL(5,2)
);

CREATE TABLE Drug(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    AMPHETAMINES DECIMAL(5,2),
    BARBITURATES DECIMAL(5,2),
    BENZODIAZEPINES DECIMAL(5,2),
    COCAINE_METABOLITES DECIMAL(5,2),
    MARIJUANA_METABOLITES DECIMAL(5,2),
    MATHADONE DECIMAL(5,2),
    METHAQUALONE DECIMAL(5,2),
    OPIATES DECIMAL(5,2),
    PHENCYCLIDINE DECIMAL(5,2),
    PROPOXYPHENE DECIMAL(5,2)
);

CREATE TABLE Allergy(
    patient_id int primary key,
    name varchar(40),
    age INT,
    sex varchar(7),
    Scallop DECIMAL(5,2),
    Cashew_Nut DECIMAL(5,2),
    Egg_White DECIMAL(5,2),
    Cow_Milk DECIMAL(5,2),
    CodFish DECIMAL(5,2),
    Wheat DECIMAL(5,2),
    Sesame_Seed DECIMAL(5,2),
    Peanut DECIMAL(5,2),
    Soybean DECIMAL(5,2),
    Almond DECIMAL(5,2),
    Shrimp DECIMAL(5,2),
    Tuna DECIMAL(5,2),
    Salmon DECIMAL(5,2),
    Walnut DECIMAL(5,2)
);
