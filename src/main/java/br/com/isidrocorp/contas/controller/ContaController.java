package br.com.isidrocorp.contas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.contas.dao.ContaDAO;
import br.com.isidrocorp.contas.model.Conta;


/* a classe ContaController é uma classe que irá expor através de um link na internet os dados do banco
 * de dados. Por isso ela é a principal responsável pela API funcionar. Um controller é a classe que 
 * mapeia endereços de url para métodos (e os executa)
 */

@RestController	// aqui definimos que a classe é um controller
@CrossOrigin("*") 	// aqui deixamos este controller acessível por todos os dispositovos externos
public class ContaController {
	
	@Autowired  	// aqui precisamos declarar um objeto do tipo ContaDAO e deixar a instanciação (criação) dele por responsabilidade
					// do sprinbgoot. A isso chamamos de "injeção de dependência"
	private ContaDAO dao;
	
	
	/* neste método vamos mapear a url que termina com /contas para o método recupearTodas
	 * dessa forma, quando nosso usuário digitar no browser
	 * 
	 * http://localhost:8080/contas
	 * 
	 * este método será chamado e aí vamos recupear todas as contas e exibi-las em formato JSON no browser
	 */
	@GetMapping("/contas")
	public ArrayList<Conta> recuperarTodas(){
		return (ArrayList<Conta>)dao.findAll();  // aqui só precisamos converter o resultado do método findAll para uma Lista (ArrayList) de objetos do tipo Conta
	}
	
	
	/* já neste método eu continuo a url passando um parâmetro (definido entre as chaves) chamado num.
	 * ele é o parâmetro que irá recuperar a conta pelo seu número
	 */
	@GetMapping("/contas/{num}")
	public Conta recuperarConta(@PathVariable int num) {  // neste caso eu preciso da anotação @PathVariable para indicar que o parâmetro vem da URL
		return dao.findById(num).orElse(null);
		// esta linha indica que ou retornamos a conta que foi encontrada pelo número num ou retornamos vazio
	}

}
