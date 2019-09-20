import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

public class Diagnostico implements Identificavel {
	
	@Id
	@GeneratedValue(generator="diagnostico_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="diagnostico_seq", sequenceName="diagnostico_seq")
	private Integer id;
	private Array[] procedimentosrealizados = new Array[1000];
	private Array[] procedimentospendentes = new Array[1000];
	private Paciente nome;
	private Date dataentrada;
	private Array[] medicamentos = new Array[1000];
	
	@ManyToMany
	@JoinTable(name = "Medico_diagnotico", joinColumns = @JoinColumn(name = "diagnotico_id"), inverseJoinColumns = @JoinColumn(name = "medico_id")

	)
	Set<Medico> medico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Array[] getProcedimentosrealizados() {
		return procedimentosrealizados;
	}

	public void setProcedimentosrealizados(Array[] procedimentosrealizados) {
		this.procedimentosrealizados = procedimentosrealizados;
	}

	public Array[] getProcedimentospendentes() {
		return procedimentospendentes;
	}

	public void setProcedimentospendentes(Array[] procedimentospendentes) {
		this.procedimentospendentes = procedimentospendentes;
	}

	public Paciente getNome() {
		return nome;
	}

	public void setNome(Paciente nome) {
		this.nome = nome;
	}

	public Date getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}

	public Array[] getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Array[] medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnostico other = (Diagnostico) obj;
		if (dataentrada == null) {
			if (other.dataentrada != null)
				return false;
		} else if (!dataentrada.equals(other.dataentrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(medicamentos, other.medicamentos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (!Arrays.equals(procedimentospendentes, other.procedimentospendentes))
			return false;
		if (!Arrays.equals(procedimentosrealizados, other.procedimentosrealizados))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diagnostico [id=" + id + ", procedimentosrealizados=" + Arrays.toString(procedimentosrealizados)
				+ ", procedimentospendentes=" + Arrays.toString(procedimentospendentes) + ", nome=" + nome
				+ ", dataentrada=" + dataentrada + ", medicamentos=" + Arrays.toString(medicamentos) + "]";
	}

	public Diagnostico(Integer id, Array[] procedimentosrealizados, Array[] procedimentospendentes, Paciente nome,
			Date dataentrada, Array[] medicamentos) {
		super();
		this.id = id;
		this.procedimentosrealizados = procedimentosrealizados;
		this.procedimentospendentes = procedimentospendentes;
		this.nome = nome;
		this.dataentrada = dataentrada;
		this.medicamentos = medicamentos;
	}

}
