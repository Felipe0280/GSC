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
