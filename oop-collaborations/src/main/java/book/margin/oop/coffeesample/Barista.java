package book.margin.oop.coffeesample;

import java.util.List;

public interface Barista {
    void orderCoffeeBean(String beanName);
}

class SimpleBarista implements Barista {
    private BeanShop shop;

    public void orderCoffeeBean(String beanName) {
        List<CoffeeBean> beans = shop.sellBean(beanName);
        //...
    }
}

class BeanShop {
    List<CoffeeBean> sellBean(String beanName) { return null;}
}

class CoffeeBean {}