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
					
					System.out.println("Digite o numero para a conta(o numero precisa ser maior que 0):");
					String numeroContatxt = leitura.nextLine();
					int numeroConta = Integer.valueOf(numeroContatxt);
					if(numeroConta < 0 ) {
						while(numeroConta < 0) {
							System.out.println("Numero da conta invalido!");
							System.out.println("Digite um numero de conta valido:");
							numeroContatxt = leitura.nextLine();
							numeroConta = Integer.valueOf(numeroContatxt);
						}
					}
					// Verificação de numero da conta:
					for (Conta conta : Cadastro) {
						icontrola = 0;
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
					
					System.out.println("\n"+"Conta cadastrada ccom sucesso!");
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
							
							System.out.println("Nome: "+conta.getNome());
							System.out.println("Numero da conta: "+conta.getNumeroConta());
							System.out.println("Numero de telefone: "+conta.getNumeroTelefone());
							System.out.println("Bairro: "+conta.getBairro());
							System.out.println("Rua: "+conta.getRua());
							System.out.println("Complemento: "+conta.getComplemento());
							System.out.println("Numero da casa: "+conta.getNumeroCasa());
							System.out.println("Cep: "+conta.getCep());
							System.out.println("Valor do saldo: "+conta.getValorSaldo()+"\n");
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
							//1-nome;2-n° de telefone;3-endereço completo;4-valor do saldo;5-cancelar atualização; acima disso nao funciona;
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
													}else {
														confirmaAtt = "nao";
													}
												}if(!confirmaAtt.equals("sim")) {
													System.out.println("Atualização cancelada com sucesso!");
													break;
												}else {
													conta.setNome(novoNome);
													System.out.println("Conta atualizada com sucesso!");
													break;
												}
											}else {
												System.out.println("Atualização cancelada com sucesso!");
												break;
											}
										}else {
											conta.setNome(novoNome);
											System.out.println("Conta atualizada com sucesso!");
											break;
										}
									}
								}
							}
							
							if(op2 == 2) {
								//atualizar n° de telefone
								
								for (Conta conta : Cadastro) {
									if(numeroContaBusca == conta.getNumeroConta()) {
										System.out.println("N° de telefone da conta antiga: "+conta.getNumeroTelefone());
										System.out.println("Digite o n° de telefone que ira substituir: ");
										String novoTelefonetxt = leitura.nextLine();
										int novoTelefone = Integer.valueOf(novoTelefonetxt);
										if(novoTelefone == conta.getNumeroTelefone()) {
											System.out.println("O novo n° de telefone é igual ao registrado nessa conta! ");
											System.out.println("Voce deseja digitar um novo n° de telefone valido?");
											confirmaAtt = leitura.nextLine();
											if(confirmaAtt.equals("sim")) {
												while(confirmaAtt.equals("sim")) {
													System.out.println("N° de telefone da conta antiga: "+conta.getNumeroTelefone());
													System.out.println("Digite o n° de telefone que ira substituir: ");
													novoTelefonetxt = leitura.nextLine();
													novoTelefone = Integer.valueOf(novoTelefonetxt);
													if(novoTelefone == conta.getNumeroTelefone()) {
														System.out.println("O novo n° de telefone é igual ao registrado nessa conta! ");
														System.out.println("Voce deseja digitar um novo n° de telefone valido?");
														confirmaAtt = leitura.nextLine();
													}else {
														confirmaAtt = "nao";
													}
												}if(!confirmaAtt.equals("sim")) {
													System.out.println("Atualização cancelada com sucesso!");
													break;
												}else {
													conta.setNumeroTelefone(novoTelefone);
													System.out.println("Conta atualizada com sucesso!");
													break;
												}
											}else {
												System.out.println("Atualização cancelada com sucesso!");
												break;
											}
										}else {
											conta.setNumeroTelefone(novoTelefone);
											System.out.println("Conta atualizada com sucesso!");
											break;
										}
									}
								}
							}
							
							
							if(op2 == 3) {
								//atualizar endereço completo
								//Fazer um menu caso ele queira atualizar so uma parte do endereço?
								
							}
							
							if(op2 == 4) {
								//atualizar valor do saldo
								for (Conta conta : Cadastro) {
									if(numeroContaBusca == conta.getNumeroConta()) {
										System.out.println("Valor de saldo da conta antiga: "+conta.getValorSaldo());
										System.out.println("Digite o valor de saldo que ira substituir: ");
										String novoSaldotxt = leitura.nextLine();
										int novoSaldo = Integer.valueOf(novoSaldotxt);
										if(novoSaldo == conta.getValorSaldo()) {
											System.out.println("O novo valor de saldo é igual ao registrado nessa conta! ");
											System.out.println("Voce deseja digitar um novo valor de saldo valido?");
											confirmaAtt = leitura.nextLine();
											if(confirmaAtt.equals("sim")) {
												while(confirmaAtt.equals("sim")) {
													System.out.println("Valor de saldo da conta antiga: "+conta.getValorSaldo());
													System.out.println("Digite o valor de saldo que ira substituir: ");
													novoSaldotxt = leitura.nextLine();
													novoSaldo = Integer.valueOf(novoSaldotxt);
													if(novoSaldo == conta.getValorSaldo()) {
														System.out.println("O novo valor de saldo é igual ao registrado nessa conta! ");
														System.out.println("Voce deseja digitar um novo valor de saldo  valido?");
														confirmaAtt = leitura.nextLine();
													}else {
														confirmaAtt = "nao";
													}
												}if(!confirmaAtt.equals("sim")) {
													System.out.println("Atualização cancelada com sucesso!");
													break;
												}else {
													conta.setValorSaldo(novoSaldo);
													System.out.println("Conta atualizada com sucesso!");
													break;
												}
												
											}else {
												System.out.println("Atualização cancelada com sucesso!");
												break;
											}
										}else {
											conta.setValorSaldo(novoSaldo);
											System.out.println("Conta atualizada com sucesso!");
											break;
										}
									}
								}
								
							}
							if(op2 == 5) {
								System.out.println("Atualização cancelada com sucesso!");
								break;
							}
							if((op2<0)||(op2>5)) {
								System.out.println("Opção digitada nao foi encontrada!");
							}
						
						}
					}
					
					
					break;
					
				case 3:
					//Excluir uma conta;
					System.out.println("Exclusao de conta!");
					System.out.println("Digite o N° da conta que vc quer excluir: ");
					numeroContatxt = leitura.nextLine();
					int numeroContaExcluir = Integer.valueOf(numeroContatxt);
					icontrola = 0;
					for (Conta conta : Cadastro) {
						if(numeroContaExcluir == conta.getNumeroConta()) {
							conta.setNumeroConta(-1);
							icontrola++;
						}
						
					}
					if(icontrola == 0) {
						System.out.println("N° da conta buscado nao foi encontrado!");
					}else {
						System.out.println("Conta excluida com sucesso");
					}
					
					break;
					
				case 4:
				    System.out.println("Listagem de conta"+"\n");
					for (Conta conta : Cadastro) {
						if(conta.getNumeroConta()!= -1) {
							System.out.println("Nome: "+conta.getNome());
							System.out.println("Numero da conta: "+conta.getNumeroConta());
							System.out.println("Numero de telefone: "+conta.getNumeroTelefone());
							System.out.println("Bairro: "+conta.getBairro());
							System.out.println("Rua: "+conta.getRua());
							System.out.println("Complemento: "+conta.getComplemento());
							System.out.println("Numero da casa: "+conta.getNumeroCasa());
							System.out.println("Cep: "+conta.getCep());
							System.out.println("Valor do saldo: "+conta.getValorSaldo()+"\n");
						}
					}
					break;
				
			}
			
		}while(op!=5);
		
		}
	}