# LetsBloom-Library-Assignment
An REST Api application to manage books in a library.

# Library/Tools used <br>
    1. Spring Boot
    2. Spring Data JPA
    3. Lombok
    4. MySQL Database
    5. Intellij IDEA IDE


# Running the Application
    1. Move to the root directory of the application
    2. Run the "mvn clean install" command to build a jar file of the application
    3. A folder with the name "target" will be created.
    4. Move inside the target folder that contains the jar file "library-0.0.1-SNAPSHOT.jar"
    5. Before running the application make sure that mysql service is running
    6. Run the command "java -jar library-0.0.1-SNAPSHOT.jar" to run the application
    7. The application is running on the port 8080.

# API Description
    1.Fetching all books:- Returns the list of books
        
        URL: http://localhost:8080/api/books
        Method: GET
        Response: [
            {
                "id": 1,
                "title": "Java",
                "description": "Core Java Book",
                "sbin": "java_6t4376ty",
                "author": "Java Author updated",
                "publicationDate": "2020-12-06",
                "creationTimestamp": "2023-12-09T19:17:35.481605"
            },
            {
                "id": 5,
                "title": "Advance Java",
                "description": "Core Java Book",
                "sbin": "adv_java_6t4376ty",
                "author": "Java Adv Author",
                "publicationDate": "2020-01-06",
                "creationTimestamp": "2023-12-09T19:51:53.216437"
            }
        ]

    2. Adding new book:- Create a new book in database with given details. 
       And throws an exception if there are duplicate entry for "sbin" fields.
       Also throws the validation exception if any of them [title, author,sbin,publication] is null. 
        
        URL: http://localhost:8080/api/books
        Method: POST
        Request: {
            "title":"Advance Java",
            "description":"Core Java Book",
            "sbin":"adv_java_6t4376ty",
            "author":"Java Adv Author",
            "publicationDate":"2020-01-06"
        }
        Response: {
            "id": 5,
            "title": "Advance Java",
            "description": "Core Java Book",
            "sbin": "adv_java_6t4376ty",
            "author": "Java Adv Author",
            "publicationDate": "2020-01-06",
            "creationTimestamp": "2023-12-09T19:51:53.216437"
        }

        When validation fails
        Request: {
            "title":null,
            "description":null,
            "sbin":null,
            "author":null,
            "publicationDate":null
        }
        Response: {
            "timestamp": "09-12-2023 10:31:55",
            "status": 400,
            "error": "[publicationDate: must not be null, sbin: must not be blank, title: must not be blank, author: must not be blank]"
        }

    3. Updating a book: Update a book with given id and new details.

        URL: http://localhost:8080/api/books/5
        Method: PUT
        Request: {
            "title":"Advance Java Update",
            "author":"Java Adv Author Update"
        }
        Response: {
            "id": 5,
            "title": "Advance Java Update",
            "description": "Core Java Book",
            "sbin": "adv_java_6t4376ty",
            "author": "Java Adv Author Update",
            "publicationDate": "2020-01-06",
            "creationTimestamp": "2023-12-09T19:51:53.216437"
        }
