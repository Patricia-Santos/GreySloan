import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Hospital implements Identificavel {

	@Id
	@GeneratedValue(generator="hospital_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="hospital_seq", sequenceName="hospital_seq")
	private Integer id;
	private String nome;
	private long contato;
	private String endereco;
	
	
	
	@OneToMany(mappedBy = "h")
	private Set<Paciente> paciente;
	
	@OneToMany(mappedBy = "m")
	private Set<Medico> medico;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (contato != other.contato)
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
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
		return "Hospital [id=" + id + ", nome=" + nome + ", contato=" + contato + ", endereco=" + endereco + "]";
	}

	public Hospital(Integer id, String nome, long contato, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

}
