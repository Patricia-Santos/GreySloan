import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Procedimentos implements Identificavel {

	@Id
	@GeneratedValue(generator = "procedimentos_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "procedimentos_seq", sequenceName = "procedimentos_seq")
	private Integer id;
	private String paciente;
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	private Array[] medicos = new Array[1000];
	private String tipo;
	private Situacao situacao;

	@ManyToMany
	@JoinTable(name = "Medico_procedimentos", joinColumns = @JoinColumn(name = "procedimentos_id"), inverseJoinColumns = @JoinColumn(name = "medico_id")

	)
	Set<Medico> medico;

	@ManyToMany
	@JoinTable(name = "Procedimentos_Paciente", joinColumns = @JoinColumn(name = "Procedimentos_id"), inverseJoinColumns = @JoinColumn(name = "Paciente_id")

	)
	Set<Paciente> paciente2;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<Medico> getMedico() {
		return medico;
	}

	public void setMedico(Set<Medico> medico) {
		this.medico = medico;
	}

	public Set<Paciente> getPaciente2() {
		return paciente2;
	}

	public void setPaciente2(Set<Paciente> paciente2) {
		this.paciente2 = paciente2;
	}

	public String getPaciente() {
		return paciente;
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
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (!Arrays.equals(medicos, other.medicos))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (paciente2 == null) {
			if (other.paciente2 != null)
				return false;
		} else if (!paciente2.equals(other.paciente2))
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
				+ ", tipo=" + tipo + ", situacao=" + situacao + ", medico=" + medico + ", paciente2=" + paciente2 + "]";
	}

	
	

}
