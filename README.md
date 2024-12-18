# Specialties Management Project
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
- **Request Body:**
  ```json
  {
    "numStudent": "String",
    "firstName": "String",
    "lastName": "String",
    "avgS1": "double",
    "avgS2": "double",
    "avgS3": "double",
    "avgS4": "double"
  }
 - **Response Body:**
   ```json
    {
    "message": "Success message or error message"
   }
   

#### Update Student
- **Endpoint:** `PUT /student/update`
- **Request Body:**
  ```json
  {
    "numStudent": "String",
    "firstName": "String",
    "lastName": "String",
    "avgS1": "double",
    "avgS2": "double",
    "avgS3": "double",
    "avgS4": "double"
  }
 - **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
   }

#### DELETE Student
- **Endpoint:** `DELETE /student/delete/{id}`
- **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
   }
#### Retrive All Students
- **Endpoint:** `GET /student/gelAll`
- **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
      "data":[
               {
                  "firstName": "String",
                  "numStudent": "String",
                  "lastName": "String",
                  "avgS1": "double",
                  "avgS2": "double",
                  "avgS3": "double",
                  "avgS4": "double"
               }
             ]
   }

#### Get All Student With choices
- **Endpoint:** `GET /student/student_choices`
 - **Response Body:**
   ```json
    {
     "message" : "get student with choices successfully",
      "data":[
                 {
		     "numStudent": "String",
		     "firstName": "String",
		     "lastName": "String",
		     "average": double,
		     "choice1": "String",
		     "choice2": "String",
		     "choice3": "String",
		     "choice4": "String"
		 }
             ]
   }
   
   
#### Get All Student With Affected Speciality
- **Endpoint:** `GET /student/Affected_spe`
 - **Response Body:**
   ```json
    {
     "message" : "affected spe",
      "data":[
                 {
                     "numStudent": "String",
		     "firstName": "String",
		     "lastName": "String",
		     "average": double,
		     "choice1": "String",
		      "choice2": "String",
		      "choice3": "String",
		      "choice4": "String",
                      "assignedSpeciality": "String"
		  }
             ]
   }

### Specialities API

#### Add Specialty
- **Endpoint:** `POST /speciality/new_speciality`
- **Request Body:**
  ```json
  {
    "name": "String",
    "firstNanumberOfPlacesme": double
  }
 - **Response Body:**
   ```json
    {
    "message": "Success message or error message"
   }
   

#### Update Specialty
- **Endpoint:** `PUT /speciality/update_speciality`
- **Request Body:**
  ```json
  {
    "name": "String",
    "firstNanumberOfPlacesme": double
  }
 - **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
   }

#### DELETE Specialty
- **Endpoint:** `DELETE /speciality/delete_speciality/{id}`
- **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
   }
#### Retrive All Specialities
- **Endpoint:** `GET /speciality/specialities`
- **Response Body:**
   ```json
    {
     "message" : "Success message or error message"
      "data":[
               {
                  "firstName": "String",
                  "numStudent": "String",
                  "lastName": "String",
                  "avgS1": "double",
                  "avgS2": "double",
                  "avgS3": "double",
                  "avgS4": "double"
               }
             ]
   }

#### Get All Student With choices
- **Endpoint:** `GET /student/student_choices`
 - **Response Body:**
   ```json
    {
     "message" : "get student with choices successfully",
      "data":[
                 {
                    "id"Long
		    "name": "String",
		    "numberOfPlaces": double
		 }
             ]
   }
   
   
     
   
