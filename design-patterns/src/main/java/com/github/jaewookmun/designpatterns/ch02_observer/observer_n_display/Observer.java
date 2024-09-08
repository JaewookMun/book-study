package com.github.jaewookmun.designpatterns.ch02_observer.observer_n_display;

public interface Observer {
    /**
     * params : 기상 정보가 변경되었을 때 옵저버한테 전달되는 상태값
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);
}
