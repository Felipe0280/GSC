package controle;

import java.util.ArrayList;

import modelo.Conta;
import modelo.Endereco;

public class ContaDAO {
	   
	   private ArrayList<Conta> Cadastro ;
	   private int geradorId;
	   private static ContaDAO instancia;
	   
	   public static ContaDAO getInstancia() {
		   if (instancia == null) {
			   instancia = new ContaDAO();
		   }
		   return instancia;
	   }
	   
	  private ContaDAO() {
		   this.Cadastro = new ArrayList<>();
		   this.geradorId = 1;
	   }
	 
	  public Conta buscarPorId(int cod) {
			for (Conta conta : Cadastro) {
				if (conta.getNumeroConta() == cod) {
					return conta;
				}
			}
			return null;
		}

	  public Conta atualizar(Conta conta, int op,int op2, String NN, int NT , int NV, String NB, String novaRua, String NC, int NNC, int NCep) {
		  if(op == 1) {
			 //NovoNome 
			  conta.setNome(NN);
		  }
		  if(op == 2) {
			  //NovoTelefone
			  conta.setNumeroTelefone(NT);
		  }
		  if(op == 3) {
			  //NovoEndereco
			  Endereco endeMetodo = conta.getEndereco();
			  if(op2 == 1) {
				  //NovoBairo
				  endeMetodo.setBairro(NB);
			  }
			  if(op2 == 2) {
				  //NovaRua
				  endeMetodo.setRua(novaRua);
			  }
			  if(op2 == 3) {
				  //NovoComplemento
				  endeMetodo.setComplemento(NC);
			  }
			  if(op2 == 4) {
				  //NovoNumeroCasa
				  endeMetodo.setNumeroCasa(NNC);
			  }
			  if(op2 == 5) {
				  //NovoCep
				  endeMetodo.setCep(NCep);
			  }
			  conta.setEndereco(endeMetodo);
			  
		  }
		  if(op == 4) {
			  //NovoValorSaldo
			  conta.setValorSaldo(NV);
		  }
		  return conta;
	  }
	  
	   public int inserir(Conta conta) {
           
		   if(conta!=null) {
			 conta.setNumeroConta(geradorId);  
			 geradorId++;
			 Cadastro.add(conta);
		   }
		   
    	   return conta.getNumeroConta();
       }
	   
	  
	   
	   public ArrayList<Conta>listar(){
		   
		   return this.Cadastro;
	   }
	   
	   public boolean remover(Conta conta) {
			boolean verifica = Cadastro.remove(conta);
			return verifica;
		}
 
	
	   
}
