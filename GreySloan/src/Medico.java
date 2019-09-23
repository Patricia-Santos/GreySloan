import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Medico implements Identificavel {
	
	@Id
	@GeneratedValue(generator="medico_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="medico_seq", sequenceName="medico_seq")
	private Integer id;
	private String nome;
	private long contato;
	private String especializacao;
	
	@ManyToOne
	@JoinColumn (name = "id_m")
	Medico m;
	
	@ManyToMany
	@JoinTable(name = "Medico_procedimentos", joinColumns = @JoinColumn(name = "medico_id"), inverseJoinColumns = @JoinColumn(name = "procedimentos_id")

	)
	Set<Procedimentos> procedimentos;
	
	@ManyToMany
	@JoinTable(name = "Medico_diagnostico", joinColumns = @JoinColumn(name = "medico_id"), inverseJoinColumns = @JoinColumn(name = "diagnostico_id")

	)
	Set<Diagnostico> diagnostico;
	
	@OneToMany(mappedBy="medicoresponsavel")
	Set<Paciente> paciente;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getContato() {
		return contato;
	}

	public void setContato(long contato) {
		this.contato = contato;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (contato != other.contato)
			return false;
		if (especializacao == null) {
			if (other.especializacao != null)
				return false;
		} else if (!especializacao.equals(other.especializacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + ", contato=" + contato + ", especializacao=" + especializacao
				+ "]";
	}

	

}
