package comum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotolmpl extends UnicastRemoteObject implements IServicoRemoto{

	private static List<Pessoa> lstPessoa = new ArrayList<>();
	
	public ServicoRemotolmpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void inserir(Pessoa p) throws RemoteException {
		lstPessoa.add(p);
		
	}

	@Override
	public List<Pessoa> listarPessoa() throws RemoteException {
		return lstPessoa;
	}

}
