package designpatterns;

import org.junit.jupiter.api.Test;

import designpatterns.di.Car;
import designpatterns.di.Motor;
import designpatterns.di.NormalMotor;

public class DiTest {

    @Test
    public void test() {
//        Car car = new Car();

        Car car = new Car(new NormalMotor());
        car.startCar();
    }

//    public void testNoParam() {
//        Car car = new Car();
//        car.setMotor(new NormalMotor());
//        car.startCar();
//    }
}
