package designpatterns.di;


public class Car {

    private final Motor motor;
    private AirConditioner airConditioner;

//    public Car() {}

    public Car(Motor motor) {
        this.motor = motor;
    }

    public void setAirConditioner(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void startCar() {
        motor.combust();

        if(airConditioner != null) {
            airConditioner.turnAcOn();
        }
    }
}
