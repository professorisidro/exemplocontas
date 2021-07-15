package br.com.isidrocorp.contas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// precisamos anotar nossas classes para mapear a estrutura da classe à estrutura da tabela que temos no banco

@Entity // indica que a classe é mapeada para uma tabela
@Table(name = "tb_cliente") // indica o nome específico da tabela que vamos usar no banco
public class Cliente {

	@Id // indica que é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o valor é gerado automaticamente pelo mysql
	@Column(name = "cod_cliente") // indica o nome da coluna na tabela
	private int codigo;

	@Column(name = "nome", length = 100, nullable = false) // aqui além de indicarmos o nome da coluna, também indicamos
															// seu tamanho e que ela não pode ser vazia
	private String nome;

	@Column(name = "cpf", length = 20, nullable = false, unique = true) // aqui temos o mesmo caso, porém com a adição
																		// da restrição do cpf ser único
	private String cpf;

	@Column(name = "email", length = 50, nullable = false, unique = true) // mesma coisa aqui, o email não pode ser
																			// vazio e tem que ser único (não pode haver
																			// 2 emails)
	private String email;

	@Column(name = "telefone", length = 20)
	private String telefone;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
