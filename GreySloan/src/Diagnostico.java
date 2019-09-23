import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Diagnostico implements Identificavel {

	@Id
	@GeneratedValue(generator = "diagnostico_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "diagnostico_seq", sequenceName = "diagnostico_seq")
	private Integer id;
	private Array[] procedimentosrealizados = new Array[1000];
	private Array[] procedimentospendentes = new Array[1000];
	private String nome;
	private Date dataentrada;
	private Array[] medicamentos = new Array[1000];

	@ManyToMany
	@JoinTable(name = "Medico_diagnostico", joinColumns = @JoinColumn(name = "diagnostico_id"), inverseJoinColumns = @JoinColumn(name = "medico_id")

	)
	Set<Medico> medico;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	Diagnostico d;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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

	public Set<Medico> getMedico() {
		return medico;
	}

	public void setMedico(Set<Medico> medico) {
		this.medico = medico;
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
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
				+ ", dataentrada=" + dataentrada + ", medicamentos=" + Arrays.toString(medicamentos) + ", medico="
				+ medico + ", paciente=" + nome + "]";
	}

	public Diagnostico getD() {
		return d;
	}

	public void setD(Diagnostico d) {
		this.d = d;
	}
	
	
	
	

}
