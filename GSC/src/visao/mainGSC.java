package visao;

import java.util.Scanner;

import controle.ContaDAO;
import modelo.Conta;
import modelo.Endereco;

public class mainGSC {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		
		int op=0, icontrola = 0;
		String confirmaAtt;
		ContaDAO dao = ContaDAO.getInstancia();
		//variaveis novas
		int novoTelefone = 0, novoSaldo=0,  novoNumeroCasa=0, novoCep=0, op3=0;
		String novoBairro =null ,novoNome= null,novaRua= null,novoComplemento=null;
		
		do {
			System.out.println("\n" + " =/=/=/=MENU=/=/=/=" + "\n\n" + "1-Cadastrar uma conta;" + "\n" + "2-Pesquisar uma conta cadastrada;" + "\n" + "3-Excluir uma conta cadastrada;" + "\n" + "4-Listar contas cadastradas;" + "\n" + "5-Encerrar o programa." + "\n");
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
					System.out.println("\n" + " =/=/=/=CADASTRO=/=/=/=" + "\n");
					System.out.println("Digite o seu nome:");
					String nome = leitura.nextLine();
					i.setNome(nome); 
					
					System.out.println("Digite seu numero de telefone:");
					String numeroTelefonetxt = leitura.nextLine();
					int numeroTelefone = Integer.valueOf(numeroTelefonetxt);
					i.setNumeroTelefone(numeroTelefone);
					
					System.out.println("Digite seu endereco"+"\n");
					
					System.out.println("Bairro:");
					String bairro = leitura.nextLine();
					
					System.out.println("Rua:");
					String rua = leitura.nextLine();
					
					System.out.println("Digite um complemento:");
					String complemento = leitura.nextLine();
					
					System.out.println("Digite o numero da casa:");
					String numeroCasatxt = leitura.nextLine();
					int numeroCasa = Integer.valueOf(numeroCasatxt);
					
					System.out.println("Digite o cep:");
					String ceptxt = leitura.nextLine();
					int cep = Integer.valueOf(ceptxt);
					
					// Criando um obj para guardar as informacoes de endereco
					Endereco end = new Endereco();
					end.setBairro(bairro);
					end.setCep(cep);
					end.setComplemento(complemento);
					end.setNumeroCasa(numeroCasa);
					end.setRua(rua);			
					
					i.setEndereco(end); //seta na classe conta
					
					System.out.println("Digite o valor do saldo: ");
					String valorSaldotxt = leitura.nextLine();
					float valorSaldo = Float.valueOf(valorSaldotxt);
					i.setValorSaldo(valorSaldo);
					
					dao.inserir(i);
					
					System.out.println("\n"+"Conta cadastrada com sucesso!");
					break;
			
				case 2:
					
					//Buscar uma conta;
					System.out.println("\n" + " =/=/=/=PESQUISAR=/=/=/=" + "\n");
					System.out.println("Digite o numero da conta que voce deseja pesquisar:");
					String numeroContatxt = leitura.nextLine();
					int numeroContaBusca = Integer.valueOf(numeroContatxt);
					dao.buscarPorId(numeroContaBusca);
						for (Conta conta : dao.listar()) {
							if(numeroContaBusca == conta.getNumeroConta()) {
								
								System.out.println("\n" + "Nome: "+conta.getNome());
								System.out.println("Numero da conta: "+conta.getNumeroConta());
								System.out.println("Numero de telefone: "+conta.getNumeroTelefone());
								System.out.println("Bairro: "+conta.getEndereco().getBairro());
								System.out.println("Rua: "+conta.getEndereco().getRua());
								System.out.println("Complemento: "+conta.getEndereco().getComplemento());
								System.out.println("Numero da casa: "+conta.getEndereco().getNumeroCasa());
								System.out.println("Cep: "+conta.getEndereco().getCep());
								System.out.println("Valor do saldo: "+conta.getValorSaldo()+"\n");
								icontrola++;
							}
						}
						if(icontrola == 0) {
							System.out.println("\n" + "Numero da conta nao encontrado no sistema!");
						}else {
							System.out.println("Pesquisa concluida com sucesso!" + "\n");
							System.out.println("Voce deseja atualizar os dados desta conta?:");
							System.out.println("Observacao: Responda com 'sim' ou 'nao'!");
							confirmaAtt = leitura.nextLine();
							if(confirmaAtt.equals("sim")) {
							
								System.out.println("\n" + " =/=/=/=MENU DE ATUALIZACAO=/=/=/=" + "\n" + "\n" + "1-Atualizar nome da conta;" + "\n" + "2-Atualizar numero de telefone;" + "\n" + "3-Atualizar endereco;" + "\n" + "4-Atualizar valor do saldo;" + "\n" + "5-Cancelar atualizacao.");
								System.out.println("\n" + "Digite a opcao desejada:");
								String op2txt = leitura.nextLine();
								int op2 = Integer.valueOf(op2txt);
								
								if(op2 == 1) {
									//atualizar nome da conta
									//dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoValorSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
									for (Conta conta : dao.listar()) {
										if(numeroContaBusca == conta.getNumeroConta()) {
											System.out.println("\n" + "Nome antigo da conta: "+conta.getNome());
											System.out.println("Digite o nome novo da conta :");
											novoNome = leitura.nextLine();
											if(novoNome.equals(conta.getNome())) {
												System.out.println("\n" + "O nome novo da conta e igual ao antigo!");
												System.out.println("\n" + "Voce deseja digitar um novo nome valido?");
												System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
												confirmaAtt = leitura.nextLine();
												if(confirmaAtt.equals("sim")) {
													while(confirmaAtt.equals("sim")) {
														System.out.println("\n" + "Nome da conta antiga: "+conta.getNome());
														System.out.println("Digite o nome novo da conta: ");
														novoNome = leitura.nextLine();
														if(novoNome.equals(conta.getNome())) {
															System.out.println("\n" + "O nome novo e igual ao antigo! ");
															System.out.println("\n" + "Voce deseja digitar um nome novo valido?");
															System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
															confirmaAtt = leitura.nextLine();
														}else {
															dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
															break;
														}
													}if(!confirmaAtt.equals("sim")) {
														System.out.println("Atualização cancelada com sucesso!");
														break;
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!");
														break;
													}
												}else {
													System.out.println("\n" + "Atualização cancelada com sucesso!");
													break;
												}
											}else {
												dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
												System.out.println("\n" + "Conta atualizada com sucesso!");
												break;
											}
										}
									}
								}
								
								if(op2 == 2) {
									//atualizar n° de telefone
									
									for (Conta conta : dao.listar()) {
										if(numeroContaBusca == conta.getNumeroConta()) {
											System.out.println("\n"+"Numero de telefone da conta antiga: "+conta.getNumeroTelefone());
											System.out.println("Digite o numero de telefone novo: ");
											String novoTelefonetxt = leitura.nextLine();
											novoTelefone = Integer.valueOf(novoTelefonetxt);
											if(novoTelefone == conta.getNumeroTelefone()) {
												System.out.println("\n"+"O novo numero de telefone é igual ao antigo! ");
												System.out.println("\n"+"Voce deseja digitar um novo numero de telefone valido?");
												System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
												confirmaAtt = leitura.nextLine();
												if(confirmaAtt.equals("sim")) {
													while(confirmaAtt.equals("sim")) {
														System.out.println("\n"+"Numero de telefone da conta antiga: "+conta.getNumeroTelefone());
														System.out.println("Digite o numero de telefone novo: ");
														novoTelefonetxt = leitura.nextLine();
														novoTelefone = Integer.valueOf(novoTelefonetxt);
														if(novoTelefone == conta.getNumeroTelefone()) {
															System.out.println("\n"+"O novo numero de telefone é igual ao antigo! ");
															System.out.println("\n"+"Voce deseja digitar um novo numero de telefone valido?");
															System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
															confirmaAtt = leitura.nextLine();
														}else {
															dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
															break;
														}
													}if(!confirmaAtt.equals("sim")) {
														System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
														break;
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}else {
													System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
													break;
												}
											}else {
												dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);												System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
												break;
											}
										}
									}
								}
								
								
								if(op2 == 3) {
									//atualizar endereço completo
									System.out.println("\n"+" =/=/=/=ATUALIZAÇÃO DO ENDEREÇO=/=/=/="+"\n"+"1-Atualizar bairro;"+"\n"+"2-Atualizar rua;"+"\n"+"3-Atualizar complemento;"+"\n"+"4-Atualizar numero da casa;"+"\n"+"5-Atualizar cep;"+"\n"+"6-Cancelar atualizacao do endereço;");
									System.out.println("\n" + "Digite a opcao desejada:");
									String op3txt = leitura.nextLine();
									op3 = Integer.valueOf(op3txt);
										if(op3 == 1) {
											//atualizar bairro
											for (Conta conta : dao.listar()) {
												if(numeroContaBusca == conta.getNumeroConta()) {
													System.out.println("\n"+"Bairro da conta antiga: "+conta.getEndereco().getBairro());
													System.out.println("Digite o bairro novo: ");
													novoBairro = leitura.nextLine();
													if(novoBairro.equals(conta.getEndereco().getBairro())) {
														System.out.println("\n"+"O novo bairro é igual ao antigo! ");
														System.out.println("\n"+"Voce deseja digitar um novo bairro valido?");
														System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
														confirmaAtt = leitura.nextLine();
														if(confirmaAtt.equals("sim")) {
															while(confirmaAtt.equals("sim")) {
																System.out.println("\n"+"Bairro da conta antiga: "+conta.getEndereco().getBairro());
																System.out.println("Digite o bairro novo: ");
																novoBairro = leitura.nextLine();
																if(novoBairro.equals(conta.getEndereco().getBairro())) {
																	System.out.println("\n"+"O novo bairro é igual ao antigo! ");
																	System.out.println("\n"+"Voce deseja digitar um novo bairro valido?");
																	System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
																	confirmaAtt = leitura.nextLine();
																}else {
																	dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																	break;
																}
															}if(!confirmaAtt.equals("sim")) {
																System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
																break;
															}else {
																dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
																break;
															}
														}else {
															System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
															break;
														}
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}
											}
											
										}
										if(op3 == 2) {
											//atualizar rua
											for (Conta conta : dao.listar()) {
												
												if(numeroContaBusca == conta.getNumeroConta()) {
													System.out.println("\n"+"Rua da conta antiga: "+conta.getEndereco().getRua());
													System.out.println("Digite a rua nova: ");
													novaRua = leitura.nextLine();
													if(novaRua.equals(conta.getEndereco().getRua())) {
														System.out.println("\n"+"A nova rua é igual a antiga! ");
														System.out.println("\n"+"Voce deseja digitar uma nova rua valida?");
														System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
														confirmaAtt = leitura.nextLine();
														if(confirmaAtt.equals("sim")) {
															while(confirmaAtt.equals("sim")) {
																System.out.println("\n"+"Rua da conta antiga: "+conta.getEndereco().getRua());
																System.out.println("Digite a rua nova: ");
																novaRua = leitura.nextLine();
																if(novaRua.equals(conta.getEndereco().getRua())) {
																	System.out.println("\n"+"A nova rua é igual a antiga! ");
																	System.out.println("\n"+"Voce deseja digitar uma nova rua valida?");
																	System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
																	confirmaAtt = leitura.nextLine();
																}else {
																	dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																	break;
																}
															}if(!confirmaAtt.equals("sim")) {
																System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
																break;
															}else {
																dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
																break;
															}
														}else {
															System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
															break;
														}
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}
											}
										}
										if(op3 == 3) {
											//atualizar complemento
											for (Conta conta : dao.listar()) {
												
												if(numeroContaBusca == conta.getNumeroConta()) {
													System.out.println("\n"+"Complemento da conta antiga: "+conta.getEndereco().getComplemento());
													System.out.println("Digite o complemento novo: ");
													novoComplemento = leitura.nextLine();
													if(novoComplemento.equals(conta.getEndereco().getComplemento())) {
														System.out.println("\n"+"O novo complemento é igual ao antigo! ");
														System.out.println("\n"+"Voce deseja digitar um novo complemento valido?");
														System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
														confirmaAtt = leitura.nextLine();
														if(confirmaAtt.equals("sim")) {
															while(confirmaAtt.equals("sim")) {
																System.out.println("\n"+"Complemento da conta antiga: "+conta.getEndereco().getComplemento());
																System.out.println("Digite o complemento novo: ");
																novoComplemento = leitura.nextLine();
																if(novoComplemento.equals(conta.getEndereco().getComplemento())) {
																	System.out.println("\n"+"O novo complemento é igual ao antigo! ");
																	System.out.println("\n"+"Voce deseja digitar um novo complemento valido?");
																	System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
																	confirmaAtt = leitura.nextLine();
																}else {
																	dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																	break;
																}
															}if(!confirmaAtt.equals("sim")) {
																System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
																break;
															}else {
																dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
																break;
															}
														}else {
															System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
															break;
														}
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}
											}
										}
										if(op3 == 4) {
											//atualizar numero da casa
											for (Conta conta : dao.listar()) {
												if(numeroContaBusca == conta.getNumeroConta()) {
													System.out.println("\n"+"Numero da casa da conta antiga: "+conta.getEndereco().getNumeroCasa());
													System.out.println("Digite o numero da casa novo: ");
													String novoNumeroCasatxt = leitura.nextLine();
													novoNumeroCasa = Integer.valueOf(novoNumeroCasatxt);
													if(novoNumeroCasa == conta.getEndereco().getNumeroCasa()) {
														System.out.println("\n"+"O novo numero da casa é igual ao antigo! ");
														System.out.println("\n"+"Voce deseja digitar um novo numero da casa valido?");
														System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
														confirmaAtt = leitura.nextLine();
														if(confirmaAtt.equals("sim")) {
															while(confirmaAtt.equals("sim")) {
																System.out.println("\n"+"Numero da casa da conta antiga: "+conta.getEndereco().getNumeroCasa());
																System.out.println("Digite o numero da casa novo: ");
																novoNumeroCasatxt = leitura.nextLine();
																novoNumeroCasa = Integer.valueOf(novoNumeroCasatxt);
																if(novoNumeroCasa == conta.getEndereco().getNumeroCasa()) {
																	System.out.println("\n"+"O novo numero da casa é igual ao antigo! ");
																	System.out.println("\n"+"Voce deseja digitar um novo numero da casa valido?");
																	System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
																	confirmaAtt = leitura.nextLine();
																}else {
																	dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																	break;
																}
															}if(!confirmaAtt.equals("sim")) {
																System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
																break;
															}else {
																dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
																break;
															}
														}else {
															System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
															break;
														}
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}
											}
										}
										if(op3 == 5) {
											//atualizar cep
											for (Conta conta : dao.listar()) {
												if(numeroContaBusca == conta.getNumeroConta()) {
													System.out.println("\n"+"Cep da conta antiga: "+conta.getEndereco().getCep());
													System.out.println("Digite o cep novo: ");
													String novoCeptxt = leitura.nextLine();
													novoCep = Integer.valueOf(novoCeptxt);
													if(novoCep == conta.getEndereco().getCep()) {
														System.out.println("\n"+"O novo cep é igual ao antigo! ");
														System.out.println("\n"+"Voce deseja digitar um novo cep valido?");
														System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
														confirmaAtt = leitura.nextLine();
														if(confirmaAtt.equals("sim")) {
															while(confirmaAtt.equals("sim")) {
																System.out.println("\n"+"Cep da conta antiga: "+conta.getEndereco().getCep());
																System.out.println("Digite o cep novo: ");
																novoCeptxt = leitura.nextLine();
																novoCep = Integer.valueOf(novoCeptxt);
																if(novoCep == conta.getEndereco().getCep()) {
																	System.out.println("\n"+"O novo cep é igual ao antigo! ");
																	System.out.println("\n"+"Voce deseja digitar um novo cep valido?");
																	System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
																	confirmaAtt = leitura.nextLine();
																}else {
																	dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																	break;
																}
															}if(!confirmaAtt.equals("sim")) {
																System.out.println("\n" + "Atualização cancelada com sucesso!" + "\n");
																break;
															}else {
																dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
																System.out.println("\n" + "\n" + "Conta atualizada com sucesso!" + "\n");
																break;
															}
														}else {
															System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
															break;
														}
													}else {
														dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
														System.out.println("\n" + "Conta atualizada com sucesso!" + "\n");
														break;
													}
												}
											}
										}
										if(op3 == 6) {
											System.out.println("\n" + "\n" + "Atualização cancelada com sucesso!" + "\n");
											break;
										}
										if((op3 < 0)||(op3>6)) {
											System.out.println("Opção digitada nao foi encontrada!");
										}
									}
								
								if(op2 == 4) {
									//atualizar valor do saldo
									for (Conta conta : dao.listar()) {
										if(numeroContaBusca == conta.getNumeroConta()) {
											System.out.println("\n" +"Valor de saldo da conta antiga: "+conta.getValorSaldo());
											System.out.println("Digite o valor de saldo novo: ");
											String novoSaldotxt = leitura.nextLine();
											novoSaldo = Integer.valueOf(novoSaldotxt);
											if(novoSaldo == conta.getValorSaldo()) {
												System.out.println("\n" +"O novo valor de saldo é igual ao antigo! ");
												System.out.println("\n" +"Voce deseja digitar um novo valor de saldo valido?");
												System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
												confirmaAtt = leitura.nextLine();
												if(confirmaAtt.equals("sim")) {
													while(confirmaAtt.equals("sim")) {
														System.out.println("\n" +"Valor de saldo da conta antiga: "+conta.getValorSaldo());
														System.out.println("Digite o valor de saldo novo: ");
														novoSaldotxt = leitura.nextLine();
														novoSaldo = Integer.valueOf(novoSaldotxt);
														if(novoSaldo == conta.getValorSaldo()) {
															System.out.println("\n" +"O novo valor de saldo é igual ao antigo! ");
															System.out.println("\n" +"Voce deseja digitar um novo valor de saldo valido?");
															System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
															confirmaAtt = leitura.nextLine();
														}else {
															dao.atualizar(conta, op2, op3, novoNome, novoTelefone, novoSaldo, novoBairro,novaRua,novoComplemento,novoNumeroCasa, novoCep);
															break;
														}
													}if(!confirmaAtt.equals("sim")) {
														System.out.println("\n" +"Atualização cancelada com sucesso!"+"\n" );
														break;
													}else {
														conta.setValorSaldo(novoSaldo);
														System.out.println("\n" +"\n" +"Conta atualizada com sucesso!"+"\n" );
														break;
													}
													
												}else {
													System.out.println("\n" +"\n" +"Atualização cancelada com sucesso!"+"\n" );
													break;
												}
											}else {
												conta.setValorSaldo(novoSaldo);
												System.out.println("\n" +"Conta atualizada com sucesso!"+"\n");
												break;
											}
										}
									}
									
								}
							
								if(op2 == 5) {
									System.out.println("\n" +"Atualização cancelada com sucesso!"+"\n" );
									break;
								}
								if((op2<0)||(op2>5)) {
									System.out.println("\n" +"Opção digitada nao foi encontrada!"+"\n" );
									break;
								}
							}
						}
					
					
					
					break;
					
				case 3:
					//Excluir uma conta;
					System.out.println("\n" + "=/=/=/=EXCLUSAO=/=/=/=" + "\n");
					System.out.println("Digite o numero da conta que voce deseja excluir: ");
					numeroContatxt = leitura.nextLine();
					int numeroContaExcluir = Integer.valueOf(numeroContatxt);
					icontrola = 0;
						for (Conta conta : dao.listar()) {
							if(numeroContaExcluir == conta.getNumeroConta()) {
								System.out.println("\n" + "Nome: "+conta.getNome());
								System.out.println("Numero da conta: "+conta.getNumeroConta());
								System.out.println("Numero de telefone: "+conta.getNumeroTelefone());
								System.out.println("Bairro: "+conta.getEndereco().getBairro());
								System.out.println("Rua: "+conta.getEndereco().getRua());
								System.out.println("Complemento: "+conta.getEndereco().getComplemento());
								System.out.println("Numero da casa: "+conta.getEndereco().getNumeroCasa());
								System.out.println("Cep: "+conta.getEndereco().getCep());
								System.out.println("Valor do saldo: "+conta.getValorSaldo()+"\n");
								icontrola++;
								
								System.out.println("\n"+"Voce deseja excluir a conta encontrada?");
								System.out.println("Observacao: Responda com 'sim' ou 'nao'!" + "\n");
								String confirmaDel = leitura.nextLine();
								if(confirmaDel.equals("sim")){
									dao.remover(conta);
									System.out.println("\n"+"Conta excluida com sucesso!");
								}else {
									System.out.println("\n"+"Exclusao cancelada com sucesso!");
								}
							}
							
						}
						if(icontrola == 0) {
							System.out.println("\n" + "Numero da conta pesquisado nao encontrado!" + "\n");
						}
						
					break;
					
				case 4:
				    System.out.println("\n"+" =/=/=/=LISTAGEM DE CONTAS=/=/=/="+"\n");
					for (Conta conta : dao.listar()) {
						if(conta.getNumeroConta()!=-1) {
							System.out.println("Nome: "+conta.getNome());
							System.out.println("Numero da conta: "+conta.getNumeroConta());
							System.out.println("Numero de telefone: "+conta.getNumeroTelefone());
							System.out.println("Bairro: "+conta.getEndereco().getBairro());
							System.out.println("Rua: "+conta.getEndereco().getRua());
							System.out.println("Complemento: "+conta.getEndereco().getComplemento());
							System.out.println("Numero da casa: "+conta.getEndereco().getNumeroCasa());
							System.out.println("Cep: "+conta.getEndereco().getCep());
							System.out.println("Valor do saldo: "+conta.getValorSaldo()+"\n");
						}
					}
					break;
			}
			
		}while(op!=5);
			System.out.println(" =/=/=/=SISTEMA FINALIZADO=/=/=/=");
		}
}