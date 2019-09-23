import java.util.Calendar;

public interface Interface {

	public Paciente addPaciente(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException;

	public Paciente RemovePaciente(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException;

	public Medico addMedico(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException;

	public Medico RemoveMedico(String nome, long contato) throws NomeInvalidoException, ContatoInvalidoException;

	public Diagnostico addDiagnostico (String nomeP, String nomeM, Diagnostico diagnostico, long contatoP, long contatoM) throws NomeInvalidoException, ContatoInvalidoException;
	
	public Procedimentos AgendarProcedimentos (String nomeP, String nomeM, Diagnostico diagnostico, long contatoP, long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException;
	
	public Procedimentos CancelarProcedimentos (String nomeP, String nomeM, Diagnostico diagnostico, long contatoP, long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException;
	
	public Procedimentos RealizarProcedimentos (String nomeP, String nomeM, Diagnostico diagnostico, long contatoP, long contatoM, Calendar calendar, String tipo) throws NomeInvalidoException, ContatoInvalidoException;
	
	
}
