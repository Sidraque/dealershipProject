package Sale;

import Sale.Sale;
import java.sql.*;

public class SaleRules {
    public void registerSale(Sale Sale) throws Exception {

        if ((Sale.getNumNote() == null) || (Sale.getNumNote().trim().equals("") == true)) {
            throw new Exception("Informar o nome do Salee");
        }

        if ((Sale.getPaymentMethod() == null) || (Sale.getPaymentMethod().trim().equals("") == true)) {
            throw new Exception("Informar o Rg do Salee");
        }

        if (Sale.getNumNote().trim().length() > 10) {
            throw new Exception("O numero da nota deverá ter 10  caracteres");
        }

        if (Sale.getPaymentMethod().trim().length().equals("1") || Sale.getPaymentMethod().trim().length().equals("2")) {
            throw new Exception("O metodo de pagamento devera ser: \n1 - a vista\n2 - a prazo");
        }

        SaleData SaleData = new SaleData();
        SaleData.registerSale(Sale);


    }

}
