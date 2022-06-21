package Sale;

import Automaker.Automaker;
import Car.Car;
import Main.ConnectionDB;
import Seller.Seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleData extends ConnectionDB{
    public void registerSale(Sale sale) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "INSERT INTO sale (numNote, totalValue, paymentMethod)  VALUES ((?), (?), (?))";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, sale.getCodSale());
        preparedStatement.setString(1, sale.getNumNote());
        preparedStatement.setFloat(2, sale.getTotalValue());
        preparedStatement.setString(3, sale.getPaymentMethod());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }

    public ArrayList<Sale> saleArrayList(Sale sale) throws Exception {

        ArrayList<Sale> saleArrayList = new ArrayList<>();

        //instrução sql listando
        String sql = " select codSale, numNote, totalValue, paymentMethod";
        sql += " from sale ";
        sql += " where sale.codSale > 0 ";
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //executando a instrução sql
        ResultSet reader = preparedStatement.executeQuery();
        //lendo os resultados
        Sale s = null;
        while (reader.next()) {
            s = new Sale();
            s.setCodSale(Integer.parseInt(String.valueOf(reader.getInt("codSale"))));
            s.setNumNote(reader.getString("numNote"));
            s.setTotalValue(reader.getFloat("totalValue"));
            s.setPaymentMethod(reader.getString("paymentMethod"));
            saleArrayList.add(s);
        }

        //fechando a conexão com o banco de dados
        super.disconnect();
        return saleArrayList;
    }

    public void deleteSale(Sale s) throws SQLException, Exception {
        //instrução a ser executada
        String sql = "DELETE FROM sale WHERE codSale = ?";
        //preparando a instrução
        PreparedStatement preparedStatement = super.toConnect().prepareStatement(sql);
        //passando os valores para os param
        preparedStatement.setInt(0, s.getCodSale());
        // execute insert SQL statement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.disconnect();
    }
}
