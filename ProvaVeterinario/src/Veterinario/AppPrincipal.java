package Veterinario;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import comum.IServicoRemoto;
import comum.Pessoa;
import comum.Veterinario;

public class AppPrincipal {
	public static void main (String[] args) {
		try {
			IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");
			
			Veterinario v1 = new Veterinario();
			Veterinario v2 = new Veterinario();
			
			v1.setId(1);
			v1.setNome("Vitor Rebello");
			v1.setCpf("350.123.456-60");
			
			v2.setId(2);
			v2.setNome("Ze Shimote");
			v2.setCpf("123.456.789-10");
			
			objPessoa.inserir(v1);
			objPessoa.inserir(v2);
			
			for (Pessoa veterinario : objPessoa.listarPessoa()) {
				System.out.println("ID: " + veterinario.getId());
				System.out.println("Nome: " + veterinario.getNome());
				System.out.println("Cpf: " + veterinario.getCpf());
			
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e){
			e.printStackTrace();
		} catch (NotBoundException e){
			e.printStackTrace();
		}
	}

}