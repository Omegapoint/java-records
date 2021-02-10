package com.omegapoint.kompetenspass.registration.model;

import java.util.Objects;
import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.Validate.notBlank;

public class User {
    private final double userId;
    private final double id;
    private final String title;
    private final boolean completed;

    public User(final double userId,
                final double id,
                final String title,
                final boolean completed) {
        Validate.notNaN(userId);
        Validate.notNaN(id);
        Validate.notBlank(title);
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public double getUserId() {
        return userId;
    }

    public double getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Double.compare(user.userId, userId) == 0 && Double.compare(user.id, id) == 0 && completed == user.completed && Objects.equals(title, user.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, completed);
    }
}
