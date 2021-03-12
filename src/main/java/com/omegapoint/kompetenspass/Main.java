package com.omegapoint.kompetenspass;

import com.omegapoint.kompetenspass.pythagoras.PythagorasService;
import com.omegapoint.kompetenspass.registration.UserRegistrationService;
import java.io.IOException;

public class Main {
    enum ServiceToRun {
        USER,
        PYTHAGORAS
        }

    private final static ServiceToRun SERVICE_TO_RUN = ServiceToRun.USER;

    public static void main(String[] args) throws IOException, InterruptedException {
        switch (SERVICE_TO_RUN) { // Look at the brand new, good-looking switch cases in Java 15!
            case USER -> new UserRegistrationService().run();
            case PYTHAGORAS -> new PythagorasService().run();
        }
    }
}
