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
					i.setNumeroTelefone(numeroTelefone);
				
					
					Cadastro.add(i);
					break;
			
				case 2:
					
					//Buscar uma conta;
					
					break;
					
				case 3:
					
					//Excluir uma conta;
					
					break;
					
				case 4:
				    System.out.println("Listagem de conta");
					for (Conta conta : Cadastro) {
						
						System.out.println(conta.getNome());
						System.out.println(conta.getNumeroConta());
						System.out.println(conta.getNumeroTelefone());
						System.out.println(conta.getBairro());
						System.out.println(conta.getRua());
						System.out.println(conta.getComplemento());
						System.out.println(conta.getNumeroCasa());
						System.out.println(conta.getCep());
						System.out.println(conta.getValorSaldo()+"\n");
  					
					}
					break;
				
			}
			
		}while(op!=5);
	}

}
