package com.amboss.assignment;

import static java.lang.System.getenv;

// Set As system property or env variable
public enum Configuration {
    BROWSER("BROWSER", "chrome"),
    TEST_ENV("URL", "https://qa-assignment.us.next.medicuja.de/us/"),
    OS("OS", "linux"),
    USERNAME("USERNAME", "qa+assignment01@medicuja.com"),
    PASSWORD("PASSWORD", "Gottafindthemall!"),
    IMPLICIT_WAIT("WAIT_TIME", "10"),
    TOPIC("TOPIC", "Systems"),
    SEARCH_OPTIONS("SEARCH_OPTIONS", "Behavioral Health");

    private final String value;

    Configuration(String mode, String defaultValue) {
        if (getenv(mode) != null)
            this.value = getenv(mode);
        else
            this.value = defaultValue;
    }

    public String getValue() {
        return this.value;
    }
}
