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
				System.out.println("Opção digitada nao encontrada!");
				System.out.println("Digite novamente:");
				opcao = leitura.nextLine();
				op = Integer.valueOf(opcao);
			}
			
			switch(op) {
				case 1:
				
					
					break;
			
				case 2:
					
					
					break;
					
				case 3:
					
					
					break;
					
				case 4:
				
					
					break;
				
			}
			
		}while(op!=5);
	}

}
