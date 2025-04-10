package mx.uam.tsis.ejemplobackend.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Component
public class ApiHealthIndicator implements HealthIndicator {

    private final RestTemplate restTemplate;

    public ApiHealthIndicator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Health health() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:8080/v1/alumnos", String.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                return Health.up()
                    .withDetail("api", "Alumnos API")
                    .withDetail("status", "operational")
                    .withDetail("responseCode", response.getStatusCodeValue())
                    .build();
            } else {
                return Health.down()
                    .withDetail("api", "Alumnos API")
                    .withDetail("status", "unavailable")
                    .withDetail("responseCode", response.getStatusCodeValue())
                    .build();
            }
        } catch (Exception e) {
            return Health.down()
                .withDetail("api", "Alumnos API")
                .withDetail("error", e.getMessage())
                .build();
        }
    }
} 