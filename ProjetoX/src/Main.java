import java.util.*;
import dao.*;
import model.*;


public class Main {
	

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		XDAO xdao = new XDAO();
		boolean ehVdd = true;
		while(ehVdd) {
			
            System.out.println("Menu:");
            System.out.println("1 ---- Inserir");
            System.out.println("2 ---- Listar");
            System.out.println("3 ---- Atualizar");
            System.out.println("4 ---- Excluir");
            System.out.println("5 ---- Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scan.nextInt();
            
            if(opcao > 0 && opcao < 6) {
            	switch(opcao) {
            	case 1:
            		System.out.println("Digite o número à ser inserido");
            		int numero = scan.nextInt();
            		System.out.println("Digite o id do número");
            		int id = scan.nextInt();
            		X novoX = new X(numero, id);
            		xdao.insert(novoX);
            		break;
            	
            	case 2:
            		System.out.println("Digite o ID à ser consultado");
            		int idConsulta = scan.nextInt();
            		X xconsultado = xdao.get(idConsulta);
            		
            		if(xconsultado != null) {
            			System.out.println("Numero: "+xconsultado.getNumero());
            		}else {
            			System.err.println("Valor não encontrado");
            		}
            		break;
   
            	case 3:
            		System.out.println("Digite o id do número à ser atualizado: ");
            		int idAtualizacao = scan.nextInt();
            		System.out.println("Digite um novo número");
            		int numNovo = scan.nextInt();
            		X xAtualizado = new X(numNovo, idAtualizacao);
            		xdao.update(xAtualizado);
            		break;
            		
            	case 4:
            		System.out.print("Digite o ID do valor a ser excluído: ");
                    int idExclusao = scan.nextInt();
                    xdao.delete(idExclusao);
                    System.out.println("Valor excluído com sucesso!");
                    break;
            	
            	case 5:
                    System.out.println("Saindo do programa...");
                    xdao.finalize();
                    scan.close();
                    ehVdd = false;
            	}
            	
            } else {
            	System.out.println("Opcao Inválida");
            }
            
		}
		System.out.println("Saiu");

		
	}
}
