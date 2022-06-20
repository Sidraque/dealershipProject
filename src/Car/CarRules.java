package Car;

import Car.Car;

public class CarRules {

    public void registerCar(Car Car) throws Exception {

        if ((Car.getNumChassi() == null)||(Car.getNumChassi().trim().equals("") == true)) {
            throw new Exception("Informar o NumChassi do Carro");
        }

        if ((Car.getLicensePlate() == null)||(Car.getLicensePlate().trim().equals("") == true)) {
            throw new Exception("Informar o LicensePlate do Carro");
        }



        if (Car.getNumChassi().trim().length() > 17) {
            throw new Exception("O nome do Carro deverá ter menos de 100  caracteres");
        }

        if (Car.getLicensePlate().trim().length() != 7) {
            throw new Exception("A LicensePlate do Carro deverá ter 7 caracteres");
        }



        CarData CarData = new CarData();
        CarData.registerCar(Car);

    }

}
