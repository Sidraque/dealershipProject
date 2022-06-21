package Automaker;

import Main.ConnectionDB;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutomakerData extends ConnectionDB {
    public void registerAutomaker(Automaker automaker) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "INSERT INTO automaker (name, address, cnpj, phone)  VALUES ((?), (?), (?), (?))";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, automaker.getCodAutomaker());
        preparedStatement.setString(1, automaker.getName());
        preparedStatement.setString(2, automaker.getAddress());
        preparedStatement.setString(3, automaker.getCnpj());
        preparedStatement.setString(4, automaker.getPhone());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Automaker> automakerArrayList() throws Exception {

        ArrayList<Automaker> automakerArrayList = new ArrayList<>();

        //instrução sql listando
        String sql = " select codAutomaker, name, address, cnpj, phone ";
        sql += " from automaker ";
        sql += " where automaker.codAutomaker > 0 ";
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //executando a instrução sql
        ResultSet reader = preparedStatement.executeQuery();
        //lendo os resultados
        Automaker a = null;
        while (reader.next()) {
            a = new Automaker();
            a.setCodAutomaker(Integer.parseInt(String.valueOf(reader.getInt("codAutomaker"))));
            a.setName(reader.getString("name"));
            a.setAddress(reader.getString("address"));
            a.setCnpj(reader.getString("cnpj"));
            a.setPhone(reader.getString("phone"));
            automakerArrayList.add(a);
        }

        //fechando a conexão com o banco de dados
        super.disconnect();
        return automakerArrayList;
    }

    public void deleteAutomaker(Automaker a) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "DELETE FROM automaker WHERE codAutomaker = ?";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, a.getCodAutomaker());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public void updateAutomaker(Automaker a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE automaker SET name = ?, address = ?, cnpj = ?, phone = ?, codCar = ? WHERE codAutomaker = ?";

        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, a.getName());
        preparedStatement.setString(2, a.getAddress());
        preparedStatement.setString(3, a.getCnpj());
        preparedStatement.setString(4, a.getPhone());

        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }
}
