package Car;

import Main.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarData extends ConnectionDB {

    public void registerCar(Car car) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "INSERT INTO car (numChassi, licensePlate, brand, model, color, year)  VALUES ((?), (?), (?), (?), (?), (?))";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, car.getCodCar());
        preparedStatement.setInt(1, car.getNumChassi());
        preparedStatement.setString(2, car.getLicensePlate());
        preparedStatement.setString(3, car.getBrand());
        preparedStatement.setString(4, car.getModel());
        preparedStatement.setString(5, car.getColor());
        preparedStatement.setInt(6, car.getYear());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Car> carArrayList(Car car) throws Exception {

        ArrayList<Car> carArrayList = new ArrayList<>();

        //instrução sql listando
        String sql = " select codCar, numChassi, licensePlate, brand, model, color, year";
        sql += " from car ";
        sql += " where car.codCar > 0 ";
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //executando a instrução sql
        ResultSet reader = preparedStatement.executeQuery();
        //lendo os resultados
        Car c = null;
        while (reader.next()) {
            c = new Car();
            c.setCodCar(Integer.parseInt(String.valueOf(reader.getInt("codCar"))));
            c.setNumChassi(Integer.parseInt(String.valueOf(reader.getInt("numChassi"))));
            c.setLicensePlate(reader.getString("licensePlate"));
            c.setBrand(reader.getString("brand"));
            c.setModel(reader.getString("model"));
            c.setColor(reader.getString("color"));
            c.setYear(reader.getInt("year"));
            carArrayList.add(c);
        }

        //fechando a conexão com o banco de dados
        super.disconnect();
        return carArrayList;
    }

    public void deleteCar(Car c) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "DELETE FROM car WHERE codCar = ?";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, c.getCodCar());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public void updateCar(Car c) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "UPDATE car SET numChassi = ?, licensePlate = ?, brand = ?, model = ?, color = ?, year = ?, codSale = ? WHERE codCar = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, c.getNumChassi());
        preparedStatement.setString(2, c.getLicensePlate());
        preparedStatement.setString(3, c.getBrand());
        preparedStatement.setString(4, c.getModel());
        preparedStatement.setString(5, c.getColor());
        preparedStatement.setInt(6, c.getYear());

        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

}
