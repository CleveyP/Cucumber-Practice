

package org.example.infrastructure;

import org.example.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class BackendLifeCycle {

    private static ConfigurableApplicationContext context;
    private static  final String backendBaseUrl = "http://localhost:8080";


    @BeforeSuite(alwaysRun = true)
    protected static void startBackend() throws Exception {
        System.out.println("Starting Backend!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // Start Spring Boot programmatically
        context = SpringApplication.run(Main.class);

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(backendBaseUrl + "/health"))
                .timeout(Duration.ofSeconds(2))
                .GET()
                .build();

        // Polling loop
        int retries = 10;
        boolean backendReady = false;

        while (retries > 0) {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200 && "OK".equals(response.body())) {
                    backendReady = true;
                    break; // backend is ready
                }
            } catch (Exception e) {
                // Ignore; likely connection refused because backend is still starting
            }

            Thread.sleep(1000); // wait 1 second before retry
            retries--;
        }

        if (!backendReady) {
            throw new ExceptionInInitializerError("Backend did not start within 10 seconds");
        }

        System.out.println("Backend started and healthy");
    }

    @AfterSuite(alwaysRun = true)
    protected static void stopBackend() {
        if (context != null) {
            context.close(); // shuts down the backend
            System.out.println("Backend stopped");
        }
    }
}
