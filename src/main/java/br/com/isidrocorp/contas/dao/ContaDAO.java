package br.com.isidrocorp.contas.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.contas.model.Conta;

// aqui temos a necessidade de declarar a interface ContaDAO que herda (amplia) a CrudRepository
// por que disso? porque a CrudRepository já tem código implementado para as principais funções de
// gravação, recuperação e alteração de dados num banco. Exemplo
// save - para gravar ou alterar (insert ou update no banco)
// findAll - para recuperar todos (um select sem where)
// findById - para recupear pela chave primparia (select com where)
public interface ContaDAO extends CrudRepository<Conta, Integer>{

}
