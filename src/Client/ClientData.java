package Client;

import Automaker.Automaker;
import Car.Car;
import Main.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientData extends ConnectionDB {

    public void registerClient(Client client) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "INSERT INTO client (rg, name, phone, address)  VALUES ((?), (?), (?), (?))";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, client.getCodClient());
        preparedStatement.setString(1, client.getRg());
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, client.getPhone());
        preparedStatement.setString(4, client.getAddress());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Client> clientArrayList(Client client) throws Exception {

        ArrayList<Client> clientArrayList = new ArrayList<>();

        //instrução sql listando
        String sql = " select codClient, rg, name, phone, address";
        sql += " from client ";
        sql += " where client.codClient > 0 ";
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //executando a instrução sql
        ResultSet reader = preparedStatement.executeQuery();
        //lendo os resultados
        Client c = null;
        while (reader.next()) {
            c = new Client();
            c.setCodClient(Integer.parseInt(String.valueOf(reader.getInt("codClient"))));
            c.setRg(reader.getString("rg"));
            c.setName(reader.getString("name"));
            c.setPhone(reader.getString("phone"));
            c.setAddress(reader.getString("address"));
            clientArrayList.add(c);
        }

        //fechando a conexão com o banco de dados
        super.disconnect();
        return clientArrayList;
    }

    public void updateClient(Client c) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "UPDATE client SET rg = ?, name = ?, phone = ?, address = ? WHERE codClient = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, c.getCodClient());
        preparedStatement.setString(2, c.getRg());
        preparedStatement.setString(3, c.getName());
        preparedStatement.setString(4, c.getPhone());
        preparedStatement.setString(5, c.getAddress());

        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }


}
