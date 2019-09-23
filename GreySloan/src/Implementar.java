import java.util.Calendar;
import java.util.GregorianCalendar;

public class Implementar implements Interface {

	@Override
	public Paciente addPaciente(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException {
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException();
		}
		DAO<Paciente> dao = new DAO<Paciente>();
		Paciente e = new Paciente();
		e.setNome(nome);
		e.setContato(contato);
		dao.save(e);

		return e;
	}

	@Override
	public Paciente RemovePaciente(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException {
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException();
		}
		DAO<Paciente> dao = new DAO<Paciente>();
		Paciente e = new Paciente();
		e.setNome(nome);
		e.setContato(contato);
		dao.remove(e);

		return e;
	}

	@Override
	public Medico addMedico(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException {
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException();
		}
		DAO<Medico> dao = new DAO<Medico>();
		Medico e = new Medico();
		e.setNome(nome);
		e.setContato(contato);
		dao.save(e);

		return e;
	}

	@Override
	public Medico RemoveMedico(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException {
		if (nome == null || nome.equals("")) {
			throw new NomeInvalidoException();
		}
		DAO<Medico> dao = new DAO<Medico>();
		Medico e = new Medico();
		e.setNome(nome);
		e.setContato(contato);
		dao.remove(e);

		return e;
	}

	@Override
	public Diagnostico addDiagnostico(String nomeP, String nomeM, Diagnostico diagnostico, long contatoP, long contatoM)
			throws NomeInvalidoException, ContatoInvalidoException {
		if (nomeP == null || nomeP.equals("")) {
			throw new NomeInvalidoException();
		}
		if (nomeM == null || nomeM.equals("")) {
			throw new NomeInvalidoException();
		}
		DAO<Diagnostico> dao = new DAO<Diagnostico>();
		Diagnostico e = new Diagnostico();
		e.setNome(nomeP);
		dao.save(e);

		return e;
	}

	@Override
	public Procedimentos AgendarProcedimentos(String nomeP, String nomeM, Diagnostico diagnostico, long contatoP,
			long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException {
		DAO<Procedimentos> dao = new DAO<Procedimentos>();
		Calendar c = new GregorianCalendar();
		Paciente p = new Paciente();
		Procedimentos pro = new Procedimentos();

		p.setNome(nomeP);
		p.setContato(contatoP);
		pro.setTipo(tipo);

		dao.save(pro);

		return pro;
	}

	@Override
	public Procedimentos CancelarProcedimentos(String nomeP, String nomeM, Diagnostico diagnostico, long contatoP,
			long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException {
		DAO<Procedimentos> dao = new DAO<Procedimentos>();
		Calendar c = new GregorianCalendar();
		Paciente p = new Paciente();
		Procedimentos pro = new Procedimentos();

		p.setNome(nomeP);
		p.setContato(contatoP);
		pro.setTipo(tipo);

		dao.remove(pro);

		return pro;
	}

	@Override
	public Procedimentos RealizarProcedimentos(String nomeP, String nomeM, Diagnostico diagnostico, long contatoP,
			long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException {
		DAO<Procedimentos> dao = new DAO<Procedimentos>();
		Calendar c = new GregorianCalendar();
		Paciente p = new Paciente();
		Procedimentos pro = new Procedimentos();

		p.setNome(nomeP);
		p.setContato(contatoP);
		pro.setTipo(tipo);

		dao.save(pro);

		return pro;
	}

}
