package Automaker;

public class AutomakerRules {

    public void registerAutomaker(Automaker automaker) throws Exception {

        if ((automaker.getName() == null)||(automaker.getName().trim().equals("") == true)) {
            throw new Exception("Informar o nome da montadora");
        }

        if ((automaker.getCnpj() == null)||(automaker.getCnpj().trim().equals("") == true)) {
            throw new Exception("Informar o cnpj da montadora");
        }

        if (automaker.getName().trim().length() > 200) {
            throw new Exception("O nome da montadora deverá ter menos de 200 caracteres");
        }

        if (automaker.getCnpj().trim().length() != 11) {
            throw new Exception("O cnpj da montadora deverá ter 11 caracteres");
        }

        AutomakerData automakerData = new AutomakerData();
        automakerData.registerAutomaker(automaker);

    }

}
