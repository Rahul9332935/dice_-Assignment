# WeatherApp

WeatherApp is a Spring Boot application that provides weather forecasts using external APIs. It allows users to retrieve forecast summaries and hourly forecasts for specific locations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 8 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

## API Endpoints

The API endpoints provide weather forecasts in JSON format. They require authentication using a client ID and client secret passed in the request headers.

### Summary Endpoint

- **URL:** `/weather/summary/{location}`
- **Method:** `GET`
- **Description:** Retrieves a summary of weather forecast for a specific location.
- **Request Headers:**
  - `X-Client-ID`: Your client ID
  - `X-Client-Secret`: Your client secret
- **Response:**
  - Status Code 200 OK: Returns the weather forecast data in JSON format.
  - Status Code 401 Unauthorized: If the provided credentials are invalid.
  - Status Code 404 Not Found: If the forecast data for the specified location is not found.

### Hourly Endpoint

- **URL:** `/weather/hourly/{location}`
- **Method:** `GET`
- **Description:** Retrieves hourly weather forecast for a specific location.
- **Request Headers:**
  - `X-Client-ID`: user
  - `X-Client-Secret`: user
- **Response:**
  - Status Code 200 OK: Returns the hourly weather forecast data in JSON format.
  - Status Code 401 Unauthorized: If the provided credentials are invalid.
  - Status Code 404 Not Found: If the forecast data for the specified location is not found.

## UI Endpoints

The UI endpoints provide user-friendly interfaces to view weather forecasts.

### Summary UI Endpoint

- **URL:** `/ui/weather/summary/{location}`
- **Method:** `GET`
- **Description:** Displays a summary of weather forecast for a specific location.
- **Response:** Renders a web page with the weather forecast summary.

### Hourly UI Endpoint

- **URL:** `/ui/weather/hourly/{location}`
- **Method:** `GET`
- **Description:** Displays hourly weather forecast for a specific location.
- **Response:** Renders a web page with the hourly weather forecast.

## Authentication

The API endpoints require authentication using a client ID and client secret provided in the request headers. Please ensure to include the appropriate headers when making requests to the API endpoints.

### Installing

1. Clone the repository:
```git clone https://github.com/rahul9332935/weatherApp.git```

2. Open the project in your preferred IDE.

3. Configure the API keys:

   - Open the `application.properties` file located in the `src/main/resources` directory.
   - Replace the placeholder values with your actual API keys:
   - `spring.application.name`: Name of the application.
   - `X-RapidAPI-Key`: [API key for accessing the weather data service](https://rapidapi.com/wettercom-wettercom-default/api/forecast9).
   - `weather.apiKey`: [API key for accessing weather data](https://openweathermap.org/forecast5#geo5).
   - `X-RapidAPI-Host : forecast9.p.rapidapi.com`
   - `server.port : 8084`.
   - `auth.clientId: user`
   - `auth.clientSecret : user`


## How to Access the Application

To access the weather forecasts, you need to pass the following headers with your requests:

- **X-Client-ID**: user
- **X-Client-Secret**: user

These headers are required for authentication purposes. Without these headers, you will not be able to access the weather forecasts.

4. Run the application:

   You can run the application directly from your IDE.


5. Access the application:

   Once the application is running, you can access it at [http://localhost:8084](http://localhost:8084) in your web browser.


## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Java framework for building web applications
- [Thymeleaf](https://www.thymeleaf.org/) - Server-side Java template engine
- [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) - Spring's HTTP client for consuming RESTful web services

## Authors

- [Rahul Kumar](https://github.com/rahul9332935)



   

