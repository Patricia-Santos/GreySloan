import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

public class Procedimentos implements Identificavel {
	
	@Id
	@GeneratedValue(generator="procedimentos_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="procedimentos_seq", sequenceName="procedimentos_seq")
	private Integer id;
	private Paciente paciente;
	private Array[] medicos = new Array[1000];
	private String tipo;
	private Situacao situacao;
	
	@ManyToMany
	@JoinTable(name = "Medico_procedimentos", joinColumns = @JoinColumn(name = "procedimentos_id"), inverseJoinColumns = @JoinColumn(name = "medico_id")

	)
	Set<Medico> medico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Array[] getMedicos() {
		return medicos;
	}

	public void setMedicos(Array[] medicos) {
		this.medicos = medicos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedimentos other = (Procedimentos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(medicos, other.medicos))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (situacao != other.situacao)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedimentos [id=" + id + ", paciente=" + paciente + ", medicos=" + Arrays.toString(medicos)
				+ ", tipo=" + tipo + ", situacao=" + situacao + "]";
	}

	public Procedimentos(Integer id, Paciente paciente, Array[] medicos, String tipo, Situacao situacao) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medicos = medicos;
		this.tipo = tipo;
		this.situacao = situacao;
	}

}
