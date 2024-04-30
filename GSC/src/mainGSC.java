import java.util.ArrayList;
import java.util.Scanner;

public class mainGSC {
	
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		
		int op=0, icontrola = 0;
		boolean confirmacao = false;
		String confirmaAtt, novoNome;
		
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
					// Cadastro de contas;
					
					Conta i = new Conta();
					System.out.println(" =/=/=/=CADASTRO=/=/=/=" + "\n");
					System.out.println("Digite o seu nome:");
					String nome = leitura.nextLine();
					i.setNome(nome); 
					
					System.out.println("Digite o numero da conta:");
					String numeroContatxt = leitura.nextLine();
					int numeroConta = Integer.valueOf(numeroContatxt);
					
					// Verificação de numero da conta:
					for (Conta conta : Cadastro) {
						if(numeroConta == conta.getNumeroConta()) {
							icontrola++;
						}
					}
					if(icontrola != 0) {
						while(icontrola != 0 ) {
							//deixar a mensagem bonita:
							icontrola = 0;
							System.out.println("Numero de conta ja existente!");
							System.out.println("Digite um outro numero:");
							numeroContatxt = leitura.nextLine();
							numeroConta = Integer.valueOf(numeroContatxt);
							for (Conta conta : Cadastro) {
								if(numeroConta == conta.getNumeroConta()) {
									icontrola++;
								}
							}
						}
					}
					i.setNumeroConta(numeroConta);
					
					System.out.println("Digite seu numero de telefone:");
					String numeroTelefonetxt = leitura.nextLine();
					int numeroTelefone = Integer.valueOf(numeroTelefonetxt);
					i.setNumeroTelefone(numeroTelefone);
					
					System.out.println("Digite seu endereco:");
					
					System.out.println("Bairro:");
					String bairro = leitura.nextLine();
					i.setBairro(bairro);
					
					System.out.println("Rua:");
					String rua = leitura.nextLine();
					i.setRua(rua);
					
					System.out.println("Digite um complemento:");
					String complemento = leitura.nextLine();
					i.setComplemento(complemento);
					
					System.out.println("Digite o numero da casa:");
					String numeroCasatxt = leitura.nextLine();
					int numeroCasa = Integer.valueOf(numeroCasatxt);
					i.setNumeroCasa(numeroCasa);
					
					System.out.println("Digite o cep:");
					String ceptxt = leitura.nextLine();
					int cep = Integer.valueOf(ceptxt);
					i.setCep(cep);
					
					System.out.println("Digite valor do saldo: ");
					String valorSaldotxt = leitura.nextLine();
					float valorSaldo = Float.valueOf(valorSaldotxt);
					i.setValorSaldo(valorSaldo);
					Cadastro.add(i);
					
					break;
			
				case 2:
					
					//Buscar uma conta;
					//deixar as mensagem bonitas;
					System.out.println("Busca:");
					System.out.println("Digite o N° da conta que vc quer encontrar: ");
					numeroContatxt = leitura.nextLine();
					int numeroContaBusca = Integer.valueOf(numeroContatxt);
					icontrola = 0;
					for (Conta conta : Cadastro) {
						if(numeroContaBusca == conta.getNumeroConta()) {
							
							System.out.println(conta.getNome());
							System.out.println(conta.getNumeroConta());
							System.out.println(conta.getNumeroTelefone());
							System.out.println(conta.getBairro());
							System.out.println(conta.getRua());
							System.out.println(conta.getComplemento());
							System.out.println(conta.getNumeroCasa());
							System.out.println(conta.getCep());
							System.out.println(conta.getValorSaldo()+"\n");
							icontrola++;
						}
					}
					if(icontrola == 0) {
						System.out.println("N° da conta nao encontrado!");
					}else {
						System.out.println("Busca concluida com sucesso!");
						System.out.println("Voce deseja atualizar os dados da conta?(responda com sim ou nao, qualquer outra escrita resultara em uma falha)");
						confirmaAtt = leitura.nextLine();
						System.out.println(confirmaAtt);
						if(confirmaAtt.equals("sim")) {
						
							// fazer menu e deixar os negocio bonito
							System.out.println("Menu de atualiacao: ");
							//1-nome;2-n° de telefone;3-endereço;4-valor do saldo;
							System.out.println("Digite a opcao desejada:");
							String op2txt = leitura.nextLine();
							int op2 = Integer.valueOf(op2txt);
							
							if(op2 == 1) {
								//atualizar nome da conta
								
								for (Conta conta : Cadastro) {
									if(numeroContaBusca == conta.getNumeroConta()) {
										System.out.println("Nome da conta antiga: "+conta.getNome());
										System.out.println("Digite o nome que ira substituir: ");
										novoNome = leitura.nextLine();
										if(novoNome.equals(conta.getNome())) {
											System.out.println("O novo nome é igual ao registrado nessa conta! ");
											System.out.println("Voce deseja digitar um novo nome valido?");
											confirmaAtt = leitura.nextLine();
											if(confirmaAtt.equals("sim")) {
												while(confirmaAtt.equals("sim")) {
													System.out.println("Nome da conta antiga: "+conta.getNome());
													System.out.println("Digite o nome que ira substituir: ");
													novoNome = leitura.nextLine();
													if(novoNome.equals(conta.getNome())) {
														System.out.println("O novo nome é igual ao registrado nessa conta! ");
														System.out.println("Voce deseja digitar um novo nome valido?");
														confirmaAtt = leitura.nextLine();
													}
												}
												conta.setNome(novoNome);
											}
											
											break;
										}else {
											conta.setNome(novoNome);
											break;
										}
									}
								}
							}
							
							if(op2 == 2) {
								//atualizar n° de telefone
							}
							
							if(op2 == 3) {
								//atualizar endereço completo
							}
							
							if(op2 == 4) {
								//atualizar valor do saldo
							}
						
						}
					}
					
					
					break;
					
				case 3:
					
					//Excluir uma conta;
					
					break;
					
				case 4:
				    System.out.println("Listagem de conta"+"\n");
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

