package Menu;

import java.text.ParseException;
import java.util.Scanner;

public class menu {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int opt;
		boolean menu = true;

		while (menu) {
			System.out.println("-------------------------------");
			System.out.println("|   Revendedora de Veiculos   |");
			System.out.println("-------------------------------");
			System.out.println("" + "\n1 - Cadastrar Veiculo " + "\n2 - Listar Veiculos " + "\n3 - Atualizar Veiculo "
					+ "\n4 - Remover Veiculo " + "\n5 - Vender Veiculo " + "\n6 - Cadastrar Cliente "
					+ "\n7 - Consultar Cliente " + "\n8 - Cadastrar Vendedor " + "\n9 - Consultar Vendedor "
					+ "\n10 - Cadastrar Venda " + "\n0 - Sair");
			System.out.println();
			System.out.println("Informe a Opção a Seguir: ");

			opt = in.nextInt();
			in.nextLine();
			System.out.println();
			switch (opt) {
			case 1:
				cadastrarVeiculo();
				System.out.println();
				break;
			case 2:
				listarVeiculo();
				System.out.println();
				break;
			case 3:
				atualizarVeiculo(in.nextLine());
				System.out.println();
				break;
			case 4:
				removerVeiculo();
				System.out.println();
				break;
			case 5:
				try {
					System.out.println("Digite a placa do carro que deseja vender:");
					venderVeiculo(in.nextLine());
					System.out.println();
				} catch (ParseException e) {
					System.out.println("Falha na venda do veiculo");
				}
				break;
			case 6:
				cadastrarCliente();
				System.out.println();
				break;
			case 7:
				consultarCliente();
				System.out.println();
				break;
			case 8:
				cadastrarVendedor();
				System.out.println();
				break;
			case 9:
				ConsultarVendedor();
				System.out.println();
				break;
			case 10:
				CadastrarVenda();
				System.out.println();
				break;

			case 0:
				menu = false;
				break;
			default:
				break;
			}
		}
		in.close();
	}
}
