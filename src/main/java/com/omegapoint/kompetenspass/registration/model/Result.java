package com.omegapoint.kompetenspass.registration.model;

import java.util.Objects;

public class Result {
    private final boolean success;

    public Result(final boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result that = (Result) o;
        return success == that.success;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }
}
