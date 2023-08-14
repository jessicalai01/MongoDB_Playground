## Mongo DB Project

### Context:
1. This is a book storage system where users can operate to save, delete, and read all books from the database.
2. The simple application is built with Java, Spring Boot framework, and MangoDB.
3. User can interact with the database with Postman API.
4. This is a simple starter playground to help you familiarise Mongodb from Java.

### How to run the code:
1. Clone the repo.
2. Set up your local Mongodb.
    - after installing, run the below from your terminal:
    - ```$ mongod```
    - ```$ mongo```
3. when the MongoDB starts running, you can start to run the application from the IDE. 
4. Finally, you can go to Postman to test the API.

### Testing the API:
1. Get all saved books by sending a get request to ```localhost:8080/book/```
2. You can test the save functions by sending a post request to:
   ```localhost:8080/book/save``` in JSON.
    Example request: <br /> 
    ``` 
   {
   "bookId": 5,
   "name":"The Story of a New Name",
   "genre":"female growth",
   "author": "Elena Ferrante",
   "rating" : 9.5
   } 
   ```
    

New Features:
My Book list:
user can browse the book available from the allbooks api
users can add the book to their own book list 





