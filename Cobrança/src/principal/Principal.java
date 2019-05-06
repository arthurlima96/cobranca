package principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import interfaceservico.IServicoAlunosPendentes;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<>();
		try {
			IServicoAlunosPendentes sap = (IServicoAlunosPendentes) Naming.lookup("//localhost/alunosPendentes");
			
			alunos = sap.listaAlunosComPendencias();
			
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
			
			FileWriter writer = new FileWriter("alunos.txt"); 			
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
				writer.write(aluno.toString()+System.getProperty( "line.separator" ));
			}
			writer.close();
		} catch (NotBoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
