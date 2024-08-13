package com.github.jaewookmun.tdd.ch07_mock.autodebit.dto;

public class RegisterResult {
    private boolean success;
    private CardValidity validity;

    public RegisterResult(boolean success, CardValidity validity) {
        this.success = success;
        this.validity = validity;
    }

    public CardValidity getValidity() {
        return validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(false, validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(true, CardValidity.VALID);
    }
}
