package br.ufsc.ine5605.sistemacontroleacesso2.mapeadores;

import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import java.util.HashMap;

/**
 *
 * @author Joao Vitor Venancio
 */
public class MapeadorFuncionario {
    //Atributos:
    /**
     * Atributo que tem uma key correspondendo a um dado de Funcionario. Para
     * cada funcionario, temos uma chave que caracteriza/indica quem eh ele
     */
    private HashMap<Integer, Funcionario> cacheFuncionarios;
    /**
     * Nome do arquivo que vai ser armazendo os dados dos Funcionarios.
     */
    private final String nomeDoArquivo = "funcionarios.dat";
    
    //Construtor:
    /**
     * Cria um MapeadorFuncionario. Inicializa o HashMap.
     */
    public MapeadorFuncionario () {
        this.cacheFuncionarios =  new HashMap<>();
    }
    
    //Metodos:
    /**
     * Procura na HashMap pelo Funcionario (dado) que corresponde a Key dada
     * como input do método.
     * 
     * @param chaveFuncionario - Chave para procurar na HashMap.
     * @return Funcionario que corresponde a sua Key || null se não encontrar.
     */
    public Funcionario get (Integer chaveFuncionario) {
        return this.cacheFuncionarios.get(chaveFuncionario);
    }
    
    /**
     * Recebe um dado para armazenar no HashMap. Nao precisa de uma key porque
     * pegamos direto o numero de matricula dos funcionarios.
     * 
     * @param funcionario - Entidade que vai ser armazenda no HashMap.
     */
    public void put (Funcionario funcionario) {
        this.cacheFuncionarios.put(funcionario.getNumeroDeMatricula(), funcionario);
    }
    
    
    
}
