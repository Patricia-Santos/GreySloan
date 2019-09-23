public class Main {

	public static void main(String[] args) {
		
		Paciente p = new Paciente();
		p.setNome("Winchester");
		DAO<Paciente> dao = new DAO<Paciente>();
		dao.save(p);
	}

}