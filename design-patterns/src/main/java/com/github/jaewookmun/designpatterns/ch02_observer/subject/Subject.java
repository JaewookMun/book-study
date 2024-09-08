package com.github.jaewookmun.designpatterns.ch02_observer.subject;

import com.github.jaewookmun.designpatterns.ch02_observer.observer_n_display.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);

    /**
     * 주체 객체의 상태가 변경되었을 때 모든 옵저버들한테 알리기 위해 호출되는 메소드
     */
    void notifyObservers();
}
