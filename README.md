# Multi-threaded web server
A multi-threaded (e.g. file-based) web server with thread-pooling
implemented in Java.

Any class that implements `WebApp` interface can be plugged as the handler application. In this example
I'm using `FileServingApp` (serves static files from a document root) as my handler application. The single method
that must be implemented is `HttpResponse handle(HttpRequest request)`.

### Request flow
1. Server receives a request.
2. Server creates a Handler (Runnable) for this request.
2. Handler parses the request into a HttpRequest.
3. Handler passes the HttpRequest to the handler application.
4. Handler writes the response received from the handler application to the output stream.
5. Handler closes the streams.

A compiled version `webserver-1.0-SNAPSHOT.jar` can be found in the root directory.
 
`WebServer` - listens for connections and delegates them to worker threads.

`Handler` - handles a single request, by parsing it and sending it to the handler application.

`ExecutorMonitor` - prints server status once every 10 seconds.

`FileServingApp` - an application that serves static files from it's document root.

## Run the server using IDE / Usage
Import the project in your IDE as general Java project.

After successful import, set the following properties in "server.properties" file. properties file located at webserver >> src >> resources >> server.properties
numThreads // numner of thread which you want to execute in parallel.
port // port number on which this application will serve the request.
filePath //local directory from where do you want to consume the files.
e.g.
numThreads=14
port=8030
filePath=C:\\Users\\mohammad.raza\\Pictures\\


Successful start will print following on console.
me.homework.server.workers.ExecutorMonitor - [7/10] Active: 0, Completed: 0, Task: 0, queueSize: 0

Now open the browser and browse the http://localhost:8020/ and append any file name with extension, which is available in your directory. e.g. http://localhost:8020/payload.txt

## Installation
`gradle build`

## 
`java -jar webserver-<version> <port> <threads> <document root>`
e.g java -jar webserver-1.0-SANPSHOT 8020 10 C:/Users/mohammad.raza/Pictures/
