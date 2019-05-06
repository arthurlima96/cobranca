package principal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import interfaceservico.IServicoAlunosPendentes;
import principal.Aluno;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<>();
		try {
			IServicoAlunosPendentes sap = (IServicoAlunosPendentes) Naming.lookup("//localhost/alunosPendentes");
			
			alunos = sap.listaAlunosComPendencias();
			
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
