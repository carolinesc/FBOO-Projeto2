package br.org.sesisp.view;

import java.util.Scanner;

import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;
public class TelaMain {
	public static void MostrarMenu() {
		System.out.println("          ");
		System.out.println("Selecione uma opcao:");
		System.out.println("1-Adicionar Aluno;");
		System.out.println("2-Atualizar Aluno;");
		System.out.println("3-Verificar Aluno");
		System.out.println("4-Deletar Aluno");
		System.out.println("0-Sair");
	}
	 public static void main(String[] args) {
		
		//instanciar um objeto de classe cruddao
		CrudDAO inserir_aluno = new CrudDAO();
		
		//instanciar um objeto aluno
		Aluno aluno1 = new Aluno();
		
		/*/*
		aluno1.setNome("José");
		aluno1.setIdade(17);
		inserir_aluno.create(aluno1);
		System.out.println("Nome: " + aluno1.getNome() + "e Idade: " + aluno1.getIdade());
		*/
		//atualizar valores
		/* aluno1.setNome("Marcelo Vieira");
		aluno1.setIdade(18);
		aluno1.setRa(1);
		inserir_aluno.update(aluno1);
		System.out.println("Nome: " + aluno1.getNome());
		System.out.println("Idade: " + aluno1.getIdade());
		
		//ler tabela alunos do 8d
		System.out.println("lendo a lista...");
		for(Aluno olho : inserir_aluno.read()) {
			System.out.println("Dados do aluno: " + olho.getRa() + olho.getNome() + olho.getIdade());
		}

		//excluir dados
		
		CrudDAO remover_aluno = new CrudDAO();
		remover_aluno.delete(2);
	} */
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao;
		
		do {
		
			MostrarMenu();
			opcao = entrada.nextInt();
		
		
			switch (opcao) {
				
			//opcao 1 create ------------------------
				case 1:
					System.out.println("          ");
				System.out.println("Insira o RA do aluno:");
				aluno1.setRa(entrada.nextInt());
				System.out.println("Insira a idade do aluno:");
				aluno1.setIdade(entrada.nextInt());
				System.out.println("Insira o nome do aluno:");
				aluno1.setNome(entrada.next());
				inserir_aluno.create(aluno1);
				System.out.println("         ");
				System.out.println("Aluno criado com sucesso!");
				System.out.println("Nome: " + aluno1.getNome());
				System.out.println("Idade: " + aluno1.getIdade());
				System.out.println("RA: " + aluno1.getNome());
				break;
				
			//opcao 2 update --------------------------
				
				case 2:
					System.out.println("          ");
					System.out.println("Insira o RA do aluno:");
					aluno1.setRa(entrada.nextInt());
					System.out.println("Insira a idade do aluno:");
					aluno1.setIdade(entrada.nextInt());
					System.out.println("Insira o nome do aluno:");
					aluno1.setNome(entrada.next());
		
					inserir_aluno.update(aluno1);
					System.out.println("          ");
					System.out.println("Informações atualizadas!");
					System.out.println("Nome: " + aluno1.getNome());
					System.out.println("Idade: " + aluno1.getIdade());
					System.out.println("RA: " + aluno1.getNome());

				break;
			// opca0 3 read ----------------------
				
				case 3:
					System.out.println("          ");
					for (Aluno um: inserir_aluno.read()) {
					System.out.println("Nome: "+ um.getNome() + " / Idade: "+ um.getIdade() +" / RA: "+ um.getRa());
					
				}
				
				break;
				
			//opcao 4 remover-------------------------
				
				case 4:
					
					CrudDAO remover_aluno = new CrudDAO();
					remover_aluno.delete(aluno1.getRa());
					System.out.println("Aluno deletado com sucesso!");
					break;
				
				default:
					break;
			}
			

		}while(opcao != 0);
		
		


	}
}