package com.algos.practice.experiments;

/**
 * Created by cdeshpande on 9/3/17.
 */
public class CarExp {

    public static void main(String[] args) {
        Car car = Car.builder().make("Honda").model("Accord").build();
        String carS = car.toString();
        System.out.println(carS);
    }
}
