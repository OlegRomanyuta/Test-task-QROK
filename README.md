The application is launched from the Main class. The database is automatically created and filled with data.
GET requests do not require authorization. PUT and POST requests require authorization 
(via postman: Authorization tab - Basic Auth. Username: admin, Password: admin).
Request examples:
For Authors

Get all authors
Postman: GET localhost:8080/authors/  
cURL:curl -X GET \
       http://localhost:8080/authors/ \
       -H 'cache-control: no-cache' \
       -H 'postman-token: 8e4d23cc-0e33-fc0d-8d5a-3e9d364e4b81'
       
Get author by id
Postman: GET localhost:8080/authors/
cURL:curl -X GET \
       http://localhost:8080/authors/1 \
       -H 'cache-control: no-cache' \
       -H 'postman-token: 7f0033ae-e707-e2d7-065a-0067c20db078'
       
Endpoint short info
Postman: GET localhost:8080/authors/info/short/3
cURL:curl -X GET \
       http://localhost:8080/authors/info/short/3 \
       -H 'cache-control: no-cache' \
       -H 'postman-token: 7404ee8c-bb73-15aa-74b5-24b0f1da0afb'
          
Create author
Postman: POST localhost:8080/authors/
  {
          "lastName": "Perry",
          "firstName": "Alex",
          "sex": "male",
          "birthDate": "1990-11-11",
          "books": [],
          "rewards": []
  }  
cURL:curl -X POST \
       http://localhost:8080/authors/ \
       -H 'cache-control: no-cache' \
       -H 'content-type: application/json' \
       -H 'postman-token: 97da1959-9762-999e-fa41-6928e7c849af' \
       -d ' {
             "lastName": "Perry",
             "firstName": "Alex",
             "sex": "male",
             "birthDate": "1990-11-11",
             "books": [],
             "rewards": []
         }'
                   
Update author
Postman: PUT localhost:8080/authors/
 {
        "lastName": "Carter",
        "id": 1,
        "firstName": "John",
        "sex": "male",
        "birthDate": "1966-11-11",
        "books": [],
        "rewards": []
 } 
  
                    
                    
For Books

Get all Books
Postman: GET localhost:8080/books/  
cURL:curl -X GET \
       http://localhost:8080/books \
       -H 'cache-control: no-cache' \
       -H 'postman-token: 282508fd-1889-1d45-317b-fa041ac3ecab'
       
Get book by id
Postman: GET localhost:8080/books/1
cURL:curl -X GET \
       http://localhost:8080/books/1 \
       -H 'cache-control: no-cache' \
       -H 'postman-token: eb0d6af0-de46-778f-3a17-2bc127005e2f'
       
          
Create book
Postman: POST localhost:8080/books/
{
        "title": "War and Peace",
        "isbn": "123456789",
        "genre": "scientific",
        "authors": []
                   }  
cURL:curl -X POST \
       http://localhost:8080/books/ \
       -H 'authorization: Basic YWRtaW46YWRtaW4=' \
       -H 'cache-control: no-cache' \
       -H 'content-type: application/json' \
       -H 'postman-token: 399898d9-1894-88a1-fb52-8ddb49a1ac11' \
       -d '{
             "title": "War and Peace",
             "isbn": "123456789",
             "genre": "scientific",
             "authors": []
                 }'
                   
Update book
Postman: PUT localhost:8080/book/
 {
         "title": "War and War",
         "id": 1,
         "isbn": "123456789",
         "genre": "scientific",
         "authors": []
 }              
cURL:curl -X PUT \
       http://localhost:8080/books/ \
       -H 'authorization: Basic YWRtaW46YWRtaW4=' \
       -H 'cache-control: no-cache' \
       -H 'content-type: application/json' \
       -H 'postman-token: eb3d76b3-33aa-ebde-630a-0f74e6a47029' \
       -d '{
             "title": "War and War",
             "id": 1,
             "isbn": "123456789",
             "genre": "scientific",
             "authors": []
                 }'   
    