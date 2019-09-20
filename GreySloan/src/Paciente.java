import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Paciente implements Identificavel {
	
	@Id
	@GeneratedValue(generator="paciente_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="paciente_seq", sequenceName="paciente_seq")
	private Integer id;
	private String nome;
	private String endereco;
	private long contato;
	private long contatoparentes;
	private Date datanascimento;
	private String alergias;
	private String tiponsanguineo;
	private Medico medicoresponsavel;
	
	@ManyToOne
	@JoinColumn (name = "id_p")
	Paciente p;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getContato() {
		return contato;
	}

	public void setContato(long contato) {
		this.contato = contato;
	}

	public long getContatoparentes() {
		return contatoparentes;
	}

	public void setContatoparentes(long contatoparentes) {
		this.contatoparentes = contatoparentes;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getTiponsanguineo() {
		return tiponsanguineo;
	}

	public void setTiponsanguineo(String tiponsanguineo) {
		this.tiponsanguineo = tiponsanguineo;
	}

	public Medico getMedicoresponsavel() {
		return medicoresponsavel;
	}

	public void setMedicoresponsavel(Medico medicoresponsavel) {
		this.medicoresponsavel = medicoresponsavel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (alergias == null) {
			if (other.alergias != null)
				return false;
		} else if (!alergias.equals(other.alergias))
			return false;
		if (contato != other.contato)
			return false;
		if (contatoparentes != other.contatoparentes)
			return false;
		if (datanascimento == null) {
			if (other.datanascimento != null)
				return false;
		} else if (!datanascimento.equals(other.datanascimento))
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
		if (medicoresponsavel == null) {
			if (other.medicoresponsavel != null)
				return false;
		} else if (!medicoresponsavel.equals(other.medicoresponsavel))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tiponsanguineo == null) {
			if (other.tiponsanguineo != null)
				return false;
		} else if (!tiponsanguineo.equals(other.tiponsanguineo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", contato=" + contato
				+ ", contatoparentes=" + contatoparentes + ", datanascimento=" + datanascimento + ", alergias="
				+ alergias + ", tiponsanguineo=" + tiponsanguineo + ", medicoresponsavel=" + medicoresponsavel + "]";
	}

	public Paciente(Integer id, String nome, String endereco, long contato, long contatoparentes, Date datanascimento,
			String alergias, String tiponsanguineo, Medico medicoresponsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.contatoparentes = contatoparentes;
		this.datanascimento = datanascimento;
		this.alergias = alergias;
		this.tiponsanguineo = tiponsanguineo;
		this.medicoresponsavel = medicoresponsavel;
	}

}
