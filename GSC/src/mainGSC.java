import java.util.ArrayList;
import java.util.Scanner;

public class mainGSC {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		int op=0;
		ArrayList<Conta> Cadastro = new ArrayList<>();
		do {
			System.out.println(" =/=/=/=/MENU/=/=/=/=" + "\n\n" + "1-Cadastrar uma conta;" + "\n" + "2-Buscar uma conta;" + "\n" + "3-Excluir uma conta;" + "\n" + "4-Listar contas cadastradas;" + "\n" + "5-Encerrar o programa." + "\n");
			System.out.println("Digite a opcao desejada:");
			String optxt = leitura.nextLine();
			op = Integer.valueOf(optxt);
			
			while((op<0)||(op>5)) {
				System.out.println("Opcao digitada não encontrada!");
				System.out.println("Digite novamente:");
				optxt = leitura.nextLine();
				op = Integer.valueOf(optxt);
			}
			
			switch(op) {
				case 1:
					
					Conta i = new Conta(); 
					System.out.println(" =/=/=/=CADASTRO=/=/=/=" + "\n");
					System.out.println("Digite o seu nome:");
					String nome = leitura.nextLine();
					i.setNome(nome); 
					
					System.out.println("Digite o numero da conta:");
					String numeroContatxt = leitura.nextLine();
					int numeroConta = Integer.valueOf(numeroContatxt);
					i.setNumeroConta(numeroConta);
					
					System.out.println("Digite seu numero de telefone:");
					String numeroTelefonetxt = leitura.nextLine();
					int numeroTelefone = Integer.valueOf(numeroTelefonetxt);
					i.setNumeroTelefone(numeroConta);
					
					System.out.println("Digite ");
					break;
			
				case 2:
					
					//Buscar uma conta;
					
					break;
					
				case 3:
					
					//Excluir uma conta;
					
					break;
					
				case 4:
					//deixa bunito
				    //System.out.println("Listagem de conta");
					for (Conta conta : Cadastro) {
						System.out.println(conta.getNome());
					}
					
					break;
				
			}
			
		}while(op!=5);
	}

}
