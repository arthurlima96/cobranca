package com.br.uni.cobranca.principal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.br.uni.financeiro.interfaceservico.IServicoAlunosPendentes;
import com.br.uni.cobranca.principal.Aluno;

public class Principal {
	
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<>();
		try {
			IServicoAlunosPendentes sap = (IServicoAlunosPendentes) Naming.lookup("//localhost/alunosPendentes");
			
			alunos = sap.listaAlunosComPendencias();
			
			for (Aluno aluno : alunos) {
				System.out.println("Nome: "+aluno.getNome());
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
