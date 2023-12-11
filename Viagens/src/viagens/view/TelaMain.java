package viagens.view;

import javax.swing.JOptionPane;

import viagens.dao.CrudDAO;
import viagens.model.Passagens;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TelaMain {

	public static void main(String[] args) {
		//instanciar um objeto da classe crudDAO
		CrudDAO inserir_passagem = new CrudDAO();
		
		
	//instanciar um objeto aluno
		Passagens passagem1 = new Passagens();
	
	Scanner entrada = new Scanner(System.in);
	
	JOptionPane.showMessageDialog(null, "Bem vindo ao Aldein");
		   
	
	int o;
	
	do {
		String opcao = JOptionPane.showInputDialog("Selecione uma opção:" +
		"\n 1-Create; \n 2-Update; \n 3-Read; \n 4-Delete; \n 0- Sair.");
		 o = Integer.parseInt(opcao);
		 
		 switch (o) {
		 
		//opcao 1 create ------------------------
		 
		 case 1:
			 
			 passagem1.setLocalIda(JOptionPane.showInputDialog("Insira o seu destino:"));
			 String dat = JOptionPane.showInputDialog("Digite a data ida: ");
			 SimpleDateFormat dateFormatA = new SimpleDateFormat("dd/MM/yyyy");
			 Date d = null;
			 try {
				 d = dateFormatA.parse(dat);
				 JOptionPane.showMessageDialog(null, "Data Inserida" + d);
			 }catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "formato inválido!");
			 }
			 passagem1.setDataIda(dat);
			 
			 String datv = JOptionPane.showInputDialog("Digite a data volta: ");
			 SimpleDateFormat dateFormatv = new SimpleDateFormat("dd/MM/yyyy");
			 Date dv = null;
			 try {
				 dv = dateFormatA.parse(datv);
				 JOptionPane.showMessageDialog(null, "Data Inserida" + dv);
			 }catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "formato inválido!");
			 }
			 passagem1.setDataVolta(datv);
			 
			 String valor = JOptionPane.showInputDialog("Insira o valor de sua passagem:");
			 int v = Integer.parseInt(valor);
			 passagem1.setValor(v);
			 
			 inserir_passagem.create(passagem1);
			 
				System.out.println("Destino: "+ passagem1.getLocalIda()+ "\nData Ida: "+ passagem1.getDataVolta() + 
						"\nData Volta: "+ passagem1.getDataVolta() + "\nValor: " + passagem1.getValor());
		    break;
		    
		    case 2:
		    	passagem1.setLocalIda(JOptionPane.showInputDialog("Insira o seu destino:"));
				 String datA = JOptionPane.showInputDialog("Digite a data ida: ");
				 SimpleDateFormat dateFormatA1 = new SimpleDateFormat("dd/MM/yyyy");
				 Date dA = null;
				 try {
					 dA = dateFormatA1.parse(datA);
					 JOptionPane.showMessageDialog(null, "Data Inserida" + dA);
				 }catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "formato inválido!");
				 }
				 passagem1.setDataIda(datA);
				 
				 String datAV = JOptionPane.showInputDialog("Digite a data ida: ");
				 SimpleDateFormat dateFormatA2 = new SimpleDateFormat("dd/MM/yyyy");
				 Date dAV = null;
				 try {
					 dAV = dateFormatA2.parse(datAV);
					 JOptionPane.showMessageDialog(null, "Data Inserida" + dAV);
				 }catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "formato inválido!");
				 }
				 passagem1.setDataVolta(datAV);
				 
				inserir_passagem.update(passagem1);
				
				break;
		   
		    case 3:
		    	
		    	JOptionPane.showMessageDialog(null, "lendo a lista...");
		    	for(Passagens olho : inserir_passagem.read()) {
					JOptionPane.showMessageDialog(null, "Dados da passagem: " + olho.getLocalIda()
					+ olho.getDataIda() + olho.getDataVolta() + olho.getValor());}
				break;
				
		    case 4:
		    	CrudDAO remover_passagem = new CrudDAO();
		    	String ra1;
				ra1 = JOptionPane.showInputDialog("Insira o valor:");
				int r1 = Integer.parseInt(ra1);
				passagem1.setValor(r1);
				remover_passagem.delete(r1);
			
				break;
			}
		}  while (o != 0); 
				
		}
				

}
