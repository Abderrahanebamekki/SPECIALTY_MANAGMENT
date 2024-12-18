# Specialties Management Project

## Description
This project is a web-based application designed for managing students and their chosen specialties. It includes functionalities for CRUD operations on students, specialties, and student choices, as well as search and filtering capabilities.

## Features

### Student Management:
- Add, update, delete, and retrieve students.
- Search students by name or ID.
- Retrieve student choices and assigned specialties.

### Specialty Management:
- Add, update, delete, and retrieve specialties.
- Search specialties by name.

### Choice Management:
- Add, update, and delete student choices for specialties.

## API Endpoints

### Student API

#### Add Student
- **Endpoint:** `POST /student/addStudent`
- **Description:** Adds a new student.
- **Request Body:**
  ```json
  {
  "numStudent": "String",
  "firstName": "String",
  "lastName": "String",
  "avgS1": double,
  "avgS2": double,
  "avgS3": double,
  "avgS4": double
}
```