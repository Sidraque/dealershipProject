package Sale;

public class SaleRules {

    public void registerSale(Sale sale) throws Exception {

        if ((sale.getPaymentMethod() == null) || (sale.getPaymentMethod().trim().equals("") == true)) {
            throw new Exception("Informar a forma de pagamento");
        }

        SaleData saleData = new SaleData();
        saleData.registerSale(sale);

    }
}
