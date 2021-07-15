package br.com.isidrocorp.contas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity				// mesma coisa: definimos que Conta vai ser armazenado no banco
@Table(name="tb_conta")  // especificamos o nome da tabela
public class Conta {
	
	@Id		// este atributo será uma chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // o valor dela é gerado automaticamente pelo banco
	@Column(name="num_conta")  // espedifico o nome da coluna
	private int numConta;
	
	@Column(name = "agencia")   // aqui só preciso também especificar o nome da coluna
	private int agencia;
	
	@Column(name = "tipo")		// aqui apenas o nome da coluna
	private int tipo;
	
	@Column(name = "saldo")   	// idem aqui
	private double saldo;
	
	@ManyToOne			// aqui eu tenho a famos a"chave estrangeira", na qual eu declaro um objeto do tipo Cliente para me referir à tabela cliente
	@JoinColumn(name = "cod_cliente") // aqui eu tenho o nome da coluna (na tabela Conta) que faz essa ligação entre a conta e o cliente
	private Cliente cliente;

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
