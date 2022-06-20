package Client;

public class ClientRules {



    public void registerClient(Client Client) throws Exception {

        if ((Client.getName() == null)||(Client.getName().trim().equals("") == true)) {
            throw new Exception("Informar o nome do Cliente");
        }

        if ((Client.getRg() == null)||(Client.getRg().trim().equals("") == true)) {
            throw new Exception("Informar o Rg do Cliente");
        }

        if (Client.getName().trim().length() > 100) {
            throw new Exception("O nome do cliente deverá ter menos de 100  caracteres");
        }

        if (Client.getRg().trim().length() != 9) {
            throw new Exception("O Rg da cliente deverá ter 9 caracteres");
        }

        ClientData ClientData = new ClientData();
        ClientData.registerClient(Client);

    }

}

