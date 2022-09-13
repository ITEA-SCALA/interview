package com.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @see https://vertex-academy.com/tutorials/ru/java-8-stream-map
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AM1111BE", 2009),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("AI5601CC", 2015),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .filter(car -> car.getYear() >= 2010)                  // выбираем только машины, выпущенные с 2010 года
                .map(Car::getNumber)                                   // преобразовываем Stream машин в Stream номеров
                .filter(number -> number != null && !number.isEmpty()) // выбираем только не пустые номера
                .forEach(System.out::println);
    }
}

class Car {
    private String number;
    private int year;

    public Car(String number, int year) {
        this.number = number;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }
}