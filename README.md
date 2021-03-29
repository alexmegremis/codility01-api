# codility01

This is the API portion.

The pom file specifies Java 11, but this should work just as well in Java 8.

A simple `mvn spring-boot:run` should launch the API.

Ensure that port 8080 is free. 

The API returns a `Access-Control-Allow-Origin: *` header.

No actual testing is provided with this submission.

### Requirements as provided:

Please create a UI which allows the user to enter a letter and will show the number of
cities beginning with that letter from the endpoint
`https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&amp;appid=b
6907d289e10d714a6e88b30761fae22`.
- Back end should be a Java/Kotlin program (java &gt;= 8)
- Front end can be plain HTML/JS or React
- Provide a Readme.md file which explains how the project can be built and run.
