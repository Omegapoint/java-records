package com.omegapoint.kompetenspass.registration.model;

import java.util.Objects;
import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.Validate.notBlank;

public class User {
    private final int userId;
    private final int id;
    private final String title;
    private final boolean completed;

    public User(final int userId,
                final int id,
                final String title,
                final boolean completed) {
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
        return userId == user.userId && id == user.id && completed == user.completed && Objects.equals(title, user.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, completed);
    }
}
