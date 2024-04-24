import java.util.ArrayList;
import java.util.Scanner;

public class mainGSC {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		int op=0;
		do {
			System.out.println(" =/=/=/=/MENU/=/=/=/=" + "\n\n" + "1-Cadastrar uma conta;" + "\n" + "2-Buscar uma conta;" + "\n" + "3-Excluir uma conta;" + "\n" + "4-Listar contas cadastradas;" + "\n" + "5-Encerrar o programa." + "\n");
			System.out.println("Digite a opção desejada:");
			String opcao = leitura.nextLine();
			op = Integer.valueOf(opcao);
			
			while((op<0)||(op>5)) {
				System.out.println("Opção digitada não encontrada!");
				System.out.println("Digite novamente:");
				opcao = leitura.nextLine();
				op = Integer.valueOf(opcao);
			}
			
			switch(op) {
				case 1:
					
					ArrayList<Conta> Cadastro = new ArrayList<>();
					
					Conta i = new Conta(); 
					System.out.println(" =/=/=/=CADASTRO=/=/=/=" + "\n");
					System.out.println("Digite o seu nome:");
					String n = leitura.nextLine();
					i.setNome(n); 
					
					break;
			
				case 2:
					
					//Buscar uma conta;
					
					break;
					
				case 3:
					
					//Excluir uma conta;
					
					break;
					
				case 4:
					
				    //Listagem das contas cadastradas;
					
					break;
				
			}
			
		}while(op!=5);
	}

}
