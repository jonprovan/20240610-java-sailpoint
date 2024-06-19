# WEB ARCHITECTURE AT A GLANCE
Everything we've done so far in Java is working in the "backend"
Meaning, the server to which our frontend server will connect
And the server which will connect to our database

## CLIENT-SERVER ARCHITECTURE
Client = a computer making a request
Server = a computer receiving a request and returning a response

Each time a new computer reaches out to another, the reacher is the client, the other is the server

Spring uses an embedded Apache Tomcat server, which is then available upon running your program to receive requests - port 8080
MySQL uses MySQL Server - port 3306
Angular uses an embedded Node.js server - port 4200

You can limit which ports you open
You can also limit which clients/ports are allowed to connect to your server

Your PC runs HTML, CSS, JS
That code is served from the frontend server -- you'll write HTML/CSS/JS to be stored on and served from your Angular app
The Spring Boot app (Java) is stored on the backend server
Angular and Spring Boot communicate primarily via JSON objects
The Spring Boot app has a driver that allows it to communicate with our MySQL server

# HTTP REQUESTS
HTTP = Hypertext Transfer Protocol
How we send information across the web

HTTPS = same thing, plus encryption (requires a certificate)

POST -- to create record (Create)
GET -- to get one or more records (Read)
PUT -- to edit a record (Update)
DELETE -- to delete a record (Delete)

### not gonna focus on these as much
PATCH -- partially update a record
OPTIONS -- to set something up or get some information

# OVERALL PROCESS
- the client sends a request
- this is wrapped in an HTTP Request object
    - this can contain several different elements
- the server processes the request
- the server sends back an HTTP Response
- the client processes the response in some way

# URI vs. URL vs. URN
URI -- Uniform Resource Identifier = a combo of the below two
URL -- Uniform Resource Locator = where to locate a specific resource
URN -- Uniform Resource Name = a unique identifier, but not a location

# WHAT AN HTTP REQUEST CAN CONTAIN
- type/method (GET, POST, etc.)
- headers = information about the request/metadata
    - token/cookie value
    - date/time
    - where the request is being redirected from
- body = content of the request, if any
- param(s) = these are key/value pairs in the URL that can be parsed
    - http://www.website.com/index.html?name=jon&age=29
- path variables = parts of the URL that we can process directly
    - http://www.website.com/items/45/v1/ -- maybe this lets me get version 1 of item 45

# WHAT AN HTTP RESPONSE CAN CONTAIN
- doesn't have a method/type
- headers
- body
- response code = information about the success/failure of the response
- can be an HTTPReponse OR an HTTPErrorResponse
- Access-Control-Allow-Origin -- a message re: CORS from your server
    - Cross-Origin Resource Sharing = where you set up which clients are allowed to talk to your server
    - we'll set this up in our backend server
- a cookie and/or token

# HTTP RESPONSE CODES
- 100-199 = Informational Messages
- 200-299 = Successful Action
- 300-399 = Redirection
- 400-499 = Client Error
- 500-599 = Server Error

# WHAT IS A REST API?
REST (or ReST) = Representational State Transfer

API = Application Programming Interface
- an agreed-upon set of rules for communicating between servers and applications
- if you make a properly-formatted request to one of the endpoints I've opened up, I will give you a predictable response

A RESTful API will have these six principles:
1. Uniform Interface
    - URLs that uniquely/specifically identify resources
    - similar resources in responses are represented similarly
    - it behaves and responds predictably and consistently from resource to resource
2. Client-Server Architecture
    - when reaching out from a client to the API, it acts as a server
    - when the API reaches out, it acts as a client
3. Stateless
    - it's idle until a request is made
    - requests must include ALL relevant information needed to process them, because...
    - previous requests, state, database information, sessions, etc. ARE NOT STORED on the API
4. Cacheable
    - an API should indicate whether or not a response is cacheable
5. Layered System(s)
    - each API only knows what's happening internally and what's being communicated with it
6. Code On Demand (optional)
    - APIs can allow the client to download and run certain pieces of code on client-side


# IDEMPOTENCY
Main Concept = two identical requests made to a database have the same end result in terms of database state
- not all CRUD methods are idempotent

PUT/UPDATE should be idempotent
GET/READ as well
DELETE/DELETE as well
POST/CREATE is NOT idempotent ****

ID  Name    Age         
1   Joe     40          UPDATE employees SET name = "Joseph" WHERE id = 1;

1   Joseph  40          UPDATE employees SET name = "Joseph" WHERE id = 1;

1   Joseph  40

