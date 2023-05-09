package m.example.modern.functional;

import m.example.modern.stream.Apple;

public class AppleStringFormatter implements  AppleFormatter {

    @Override
    public String format(Apple apple) {
        return apple.getWeight() > 150 ? "heavy" : "light";
    }
}
