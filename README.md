# Altice Labs Sequence Challenge

This repository represents a work in response to a challenge made by Altice Labs.

## Getting Started

To get started with this project, you can run the application using Docker. Below are the steps to set up and run the project.

### Prerequisites

Make sure you have the following installed on your machine:

- [Docker](https://www.docker.com/get-started) (and Docker Compose)

### Sequence Algorithm
 - n=0 => l(0) = 0
 - n=1 => l(1) = 1
 - n=2 => l(2) = 0
 - n=3 => l(3) = 1
 - n>3 => l(n) = l(n - 4) + l(n - 3)

### Running the Application

To run the application using Docker Compose, use the following command:

```bash
docker-compose up --build
```

It will create the necessary containers and install all the necessary dependencies.

### REST API Documentation

Once the project is running, it is possible to test the results of the implemented sequence.
It is possible to test with one of the next steps:

#### Terminal
```bash
curl -s -w "\n" localhost:8080/labseq/10
```

### Swagger UI
- [Backend Swagger UI with the endpoint](https://localhost:8080/swagger-ui)

### Application Web Interface

To facilitate this process to user, there is a user interface that can be used to test the sequence. That interface is available at:
- [Angular Web Interface](https://localhost:4200/)
