package controle;

import java.util.ArrayList;

import modelo.Conta;

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

	  public Conta atualizar(Conta conta) {
		  //fazer o methodo fazer uma verificação de opção digitada e no methodo so entra as novas
		  //variavels entrar, ali como parametro entra a opção e as novas variaveis.Lembrar de fazer
		  //uma verificação pra nao mexer em variavel se nao mexer nela!
		  return null;
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
