package Car;

import java.util.ArrayList;

public class CarRules {

    public void registerCar(Car car) throws Exception {
        CarData CarData = new CarData();
        CarData.registerCar(car);
    }

    public void updateCar(Car car) throws Exception {
        CarData c = new CarData();
        c.updateCar(car);
    }

    public ArrayList<Car> carArrayList(Car car) throws Exception {
        CarData c = new CarData();
        ArrayList<Car> carArrayList = new ArrayList();
        carArrayList = c.carArrayList(car);
        return carArrayList;
    }

}
