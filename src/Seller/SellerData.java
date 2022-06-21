package Seller;

import Car.Car;
import Main.ConnectionDB;
import Sale.Sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SellerData extends ConnectionDB {
    public void registerSeller(Seller seller) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "INSERT INTO seller (rg, name, expYear, phone)  VALUES ((?), (?), (?), (?))";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, seller.getCodSeller());
        preparedStatement.setString(1, seller.getRg());
        preparedStatement.setString(2, seller.getName());
        preparedStatement.setInt(3, seller.getExpYear());
        preparedStatement.setString(4, seller.getPhone());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Seller> sellerArrayList(Seller seller) throws Exception {

        ArrayList<Seller> sellerArrayList = new ArrayList<>();

        //instrução sql listando
        String sql = " select codSeller, rg, name, expYear, phone";
        sql += " from seller ";
        sql += " where seller.codSeller > 0 ";
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //executando a instrução sql
        ResultSet reader = preparedStatement.executeQuery();
        //lendo os resultados
        Seller s = null;
        while (reader.next()) {
            s = new Seller();
            s.setCodSeller(Integer.parseInt(String.valueOf(reader.getInt("codSeller"))));
            s.setRg(reader.getString("rg"));
            s.setName(reader.getString("name"));
            s.setExpYear(reader.getInt("expYear"));
            s.setPhone(reader.getString("phone"));
            sellerArrayList.add(s);
        }

        //fechando a conexão com o banco de dados
        super.disconnect();
        return sellerArrayList;
    }

    public void deleteSeller(Seller s) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "DELETE FROM seller WHERE codSeller = ?";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, s.getCodSeller());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }
}
