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
        String sql = "INSERT INTO automaker (name)  VALUES (?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setString(0, automaker.getName());
        preparedStatement.setString(1, automaker.getAddress());
        preparedStatement.setString(2, automaker.getCnpj());
        preparedStatement.setString(3, automaker.getPhone());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Automaker> automakerArrayList() throws Exception {

        ArrayList<Automaker> automakerArrayList = new ArrayList<>();

        //instrução sql listando os tipos
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
            a.setName(String.valueOf(reader.getInt("codAutomaker")));
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
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }
}
