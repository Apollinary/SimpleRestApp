# SimpleRestApp
SimpleRestApp

DataSource properties are in ApplicationConfig class, change it to appropriate.
Database, schema should be created manually.
To create the table "users" execute commands from "sql_table.sql" file.

To get user by id: send get request to  /SimpleRest/users/{userId}

To update status by userId: send patch request to /SimpleRest/updateUser/{userId}/userStatus/{userStatus}

To add new user: send post request to /SimpleRest/users/add/ Example body: 
{
    "firstName":"Vasya",
    "lastName":"Pupkin",
    "age":"18",
    "email":"vasya@test.com",
    "phoneNumber":"89123456780",
    "status":"ONLINE"
}