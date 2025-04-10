# Spring Boot Backend with DevOps Features

This project is a Spring Boot backend application with comprehensive DevOps features including CI/CD, monitoring, and observability.

## Features

### 1. Continuous Integration & Deployment
- GitHub Actions workflow for automated builds and deployments
- Automated Docker image creation and publishing
- Integration with GitHub Container Registry
- Automated testing with JaCoCo coverage reports
- SonarQube integration for code quality analysis

### 2. Monitoring & Observability
- Spring Boot Actuator for application metrics
- Prometheus for metrics collection
- Grafana for metrics visualization
- Custom health indicators for:
  - Database connectivity
  - API availability
  - System resources

### 3. Security
- Basic authentication
- OpenAPI (Swagger) documentation
- Secure endpoints
- Environment-specific configurations

### 4. Containerization
- Multi-stage Docker builds
- Jib Maven plugin for containerization
- Optimized container images
- Health checks and readiness probes

## Getting Started

### Prerequisites
- Java 17
- Maven
- Docker
- Docker Compose

### Local Development

1. Clone the repository:
```bash
git clone <repository-url>
cd minidevops
```

2. Build the application:
```bash
mvn clean package
```

3. Run the application:
```bash
java -jar target/ejemplobackend-0.0.1-SNAPSHOT.jar
```

### Running with Docker

1. Build the Docker image:
```bash
mvn compile jib:dockerBuild
```

2. Run the container:
```bash
docker run -p 8080:8080 minidevops:0.0.1-SNAPSHOT
```

### Monitoring Stack

1. Start the monitoring services:
```bash
docker-compose up -d
```

2. Access the monitoring tools:
- Grafana: http://localhost:3000 (admin/admin)
- Prometheus: http://localhost:9090

## API Documentation

Access the OpenAPI documentation at:
```
http://localhost:8080/swagger-ui.html
```

## Monitoring Endpoints

### Actuator Endpoints
- Health: `/actuator/health`
- Metrics: `/actuator/metrics`
- Prometheus: `/actuator/prometheus`

### Custom Health Checks
- Database Health: `/actuator/health/db`
- API Health: `/actuator/health/api`

## CI/CD Pipeline

The GitHub Actions workflow (`/.github/workflows/ci-cd.yml`) includes:

1. Build and Test:
   - Compiles the application
   - Runs unit tests
   - Generates JaCoCo coverage reports
   - Runs SonarQube analysis

2. Docker Build and Push:
   - Builds Docker image
   - Pushes to GitHub Container Registry
   - Tags with version and latest

## Monitoring Dashboard

The Grafana dashboard includes:

1. System Metrics:
   - CPU Usage
   - Memory Usage
   - HTTP Request Counts

2. Application Metrics:
   - JVM Statistics
   - Database Connection Status
   - API Health Status

## Security

### Authentication
Default credentials:
- Username: admin
- Password: admin

### Endpoints Security
- Public: `/swagger-ui/**`, `/v3/api-docs/**`
- Protected: All other endpoints require authentication

## Development Tools

### Code Quality
- JaCoCo for code coverage (minimum 50%)
- SonarQube for static code analysis
- OpenAPI for API documentation

### Container Tools
- Jib for containerization
- Multi-stage Docker builds
- Optimized container images

## Contributing

1. Create a feature branch
2. Make your changes
3. Run tests: `mvn test`
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
