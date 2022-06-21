package Seller;

import Seller.Seller;
import Sale.Sale;

public class SellerRules {

    public void registerSeller(Seller Seller) throws Exception {

        if ((Seller.getName() == null)||(Seller.getName().trim().equals("") == true)) {
            throw new Exception("Informar o nome do Seller");
        }

        if ((Seller.getRg() == null)||(Seller.getRg().trim().equals("") == true)) {
            throw new Exception("Informar o Rg do Seller");
        }

        if (Seller.getName().trim().length() > 100) {
            throw new Exception("O nome do Seller deverá ter menos de 100  caracteres");
        }

        if (Seller.getRg().trim().length() != 9) {
            throw new Exception("O Rg da Seller deverá ter 9 caracteres");
        }

        SellerData SellerData = new SellerData();
        SellerData.registerSeller(Seller);

    }

}
