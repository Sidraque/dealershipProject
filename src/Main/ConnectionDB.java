package Main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

    public static void closeConnection(com.mysql.cj.jdbc.Driver con, PreparedStatement pstm, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private Statement stmt;
    public Connection conn;
    private final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
    private final String LOCAL_SERVIDOR = "127.0.0.1";
    private final String BANCO_DE_DADOS = "dealerShip";
    private final String PORTA_BANCO = "3306";
    private final String USUARIO = "root";
    private final String SENHA = "";

    public Connection toConnect() throws Exception {
        return this.conectarMySql();
    }

    public void disconnect() throws SQLException {
        conn.close();
    }

    private Connection conectarMySql() throws Exception {
        Class.forName(DRIVER_MYSQL).newInstance();
        String url = "jdbc:mysql://" + LOCAL_SERVIDOR + ":" + PORTA_BANCO + "/" + BANCO_DE_DADOS;
        conn = (Connection) DriverManager.getConnection(url, USUARIO, SENHA);
        return conn;
    }

}
