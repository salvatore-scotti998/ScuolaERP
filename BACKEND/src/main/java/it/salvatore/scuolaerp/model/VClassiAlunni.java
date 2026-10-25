package it.salvatore.scuolaerp.model;
import org.hibernate.annotations.*;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.type.SqlTypes;

@Access(AccessType.FIELD)
@Immutable
@Getter
@Setter
@Entity
@Table(name = "V_CLASSI_ALUNNI")
public class VClassiAlunni {

	@Id
	@Column (name = "ID")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "COGNOME")
	private String cognome;
	
	@Column(name = "ANNO")
	private int anno;
	
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(name = "SEZIONE", length = 1)
	private String sezione;
	
	@Column(name = "NOME_CLASSE")
	private String nomeClasse;

}
