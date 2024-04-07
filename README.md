# WeatherApp

WeatherApp is a Spring Boot application that provides weather forecasts using external APIs. It allows users to retrieve forecast summaries and hourly forecasts for specific locations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 8 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installing

1. Clone the repository:
```git clone https://github.com/rahul9332935/weatherApp.git```

2. Open the project in your preferred IDE.

3. Configure the API keys:

   - Open the `application.properties` file located in the `src/main/resources` directory.
   - Replace the placeholder values with your actual API keys:
   - ```X-RapidAPI-Key=738e943283msha9dfc0bc496552p1b1c1ajsn0d92c4b15f5e ```
   - ``` weather.apiKey=59a12c019546f4ec2825de768f692dc ```
   - ```X-RapidAPI-Host=forecast9.p.rapidapi.com ```


4. Run the application:

   You can run the application directly from your IDE.


5. Access the application:

   Once the application is running, you can access it at [http://localhost:8084](http://localhost:8084) in your web browser.

## Endpoints

The application provides the following REST endpoints:

- `/` : For Homepage.
- `/weather/summary/{location}`: Retrieves the forecast summary for a specific location.
- `/weather/hourly/{location}`: Retrieves hourly forecasts for a specific location.


## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Java framework for building web applications
- [Thymeleaf](https://www.thymeleaf.org/) - Server-side Java template engine
- [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) - Spring's HTTP client for consuming RESTful web services

## Authors

- [Rahul Kumar](https://github.com/rahul9332935)



   

