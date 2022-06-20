package Automaker;

import Main.ConnectionDB;

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
}
