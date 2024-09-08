package com.github.jaewookmun.designpatterns.ch02_observer;

import com.github.jaewookmun.designpatterns.ch02_observer.observer_n_display.CurrentConditionsDisplay;
import com.github.jaewookmun.designpatterns.ch02_observer.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
