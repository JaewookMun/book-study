package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_set_duplicate_env;

public class Address {
    private String city;
    private String location;

    public Address(String city, String location) {
        this.city = city;
        this.location = location;
    }

    public String getCity() {
        return city;
    }
}
