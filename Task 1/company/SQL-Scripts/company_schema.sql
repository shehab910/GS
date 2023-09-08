CREATE TABLE "students_departments"(
    "student_id" INTEGER NOT NULL,
    "department_id" INTEGER NOT NULL
);
CREATE TABLE "departments"(
    "id" INTEGER NOT NULL,
    "name" VARCHAR(4326) NOT NULL,
    "boss" VARCHAR(4326) NOT NULL
);
ALTER TABLE
    "departments" ADD PRIMARY KEY("id");
CREATE TABLE "students"(
    "id" INTEGER NOT NULL,
    "name" VARCHAR(4326) NOT NULL,
    "birthdate" DATE NOT NULL,
    "grade" VARCHAR(4326) NOT NULL,
    "faculty_serial_number" INTEGER NOT NULL
);
ALTER TABLE
    "students" ADD PRIMARY KEY("id");
ALTER TABLE
    "students" ADD CONSTRAINT "students_faculty_serial_number_unique" UNIQUE("faculty_serial_number");

ALTER TABLE
    "students_departments" ADD CONSTRAINT "students_departments_student_id_foreign" FOREIGN KEY("student_id") REFERENCES "students"("id") ON DELETE CASCADE;
ALTER TABLE
    "students_departments" ADD CONSTRAINT "students_departments_department_id_foreign" FOREIGN KEY("department_id") REFERENCES "departments"("id") ON DELETE CASCADE;