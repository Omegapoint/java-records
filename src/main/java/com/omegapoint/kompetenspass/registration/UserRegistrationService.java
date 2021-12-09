package com.omegapoint.kompetenspass.registration;

import com.omegapoint.kompetenspass.registration.model.Result;
import com.omegapoint.kompetenspass.registration.model.User;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class UserRegistrationService {
    final List<User> registeredUsers;
    final HttpClient httpClient = HttpClient.newHttpClient();

    // TODO Uppgift 1: Använd Records för User och Result istället för klasser!

    public UserRegistrationService() {
        registeredUsers = fetchRegisteredUsers();
    }

    public void run() throws IOException, InterruptedException {
        final User user = registrationRequest();
        final Result result = signUpForNewsLetter(user);
        respond(result, user);
    }

    /**
     * Servern som används här: https://jsonplaceholder.typicode.com
     */
    private User registrationRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        final JSONObject jsonObject = new JSONObject(response.body());

        return new User(
                jsonObject.getInt("userId"),
                jsonObject.getInt("id"),
                jsonObject.getString("title"),
                jsonObject.getBoolean("completed")
        );
    }

    private Result signUpForNewsLetter(final User user) {
        final List<User> registeredUsers = fetchRegisteredUsers();

        if (!registeredUsers.contains(user)) {
            registeredUsers.add(user);
            return new Result(true);
        } else {
            return new Result(false);
        }
    }

    private List<User> fetchRegisteredUsers() {
        List<User> registeredUsers = new ArrayList<>();
        registeredUsers.add(new User(1, 23, "Homer", false));
        registeredUsers.add(new User(2, 27, "Marge", true));
        registeredUsers.add(new User(3, 5, "Peter", true));
        registeredUsers.add(new User(4, 91, "Bart", true));
        // TODO: Avkommentera nedan för att få ett annat utfall
        // registeredUsers.add(new User(1, 1, "delectus aut autem", false));

        return registeredUsers;
    }

    private void respond(final Result result, final User user) {
        if (result.isSuccess()) {
            System.out.println("User: " + user.getTitle() + " was successfully registered for the newsletter!");
        } else {
            System.out.println("User: " + user.getTitle() + " already exists.");
        }
    }
}
