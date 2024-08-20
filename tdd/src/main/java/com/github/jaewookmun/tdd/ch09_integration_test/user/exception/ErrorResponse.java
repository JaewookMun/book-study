package com.github.jaewookmun.tdd.ch09_integration_test.user.exception;

public class ErrorResponse {
    private final String message;
    private final String errorType;

    public ErrorResponse(String message, String errorType) {
        this.message = message;
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorType() {
        return errorType;
    }

    public static ErrorResponse error(Exception ex) {
        return new ErrorResponse(ex.getMessage(), ex.getClass().getSimpleName());
    }
}
