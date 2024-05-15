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

	
	   
}
