package br.ufsc.ine5605.sistemacontroleacesso2.mapeadores;

import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Joao Vitor Venancio
 */
public class MapeadorFuncionario {
    //Atributos:
    /**
     * Atributo que tem uma key correspondendo a um dado de Funcionario. Para
     * cada funcionario, temos uma chave que caracteriza/indica quem eh ele.
     * Esse atributo representa os dados que vao ser escritos/lidos pelo mapeador,
     * existindo como dados dinamicos apenas quando a aplicacao for iniciada.
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
    
    /**
     * Metodo que envia todos os objetos dinamicos para um arquivo estatico.
     */
    public void persist () {
        try {
            //Cria um caminho do stream  de dados para um arquivo:
            FileOutputStream fileOutputStream = new FileOutputStream(this.nomeDoArquivo);
            //Cria um caimnho do um objeto para dados serializaveis:
            ObjectOutputStream objectOutputStream = new ObjectOutputStream (fileOutputStream);
            
            //Transformar a HashMap (objeto) em dados serializaveis para entao
            //ser gravado:
            objectOutputStream.writeObject(this.cacheFuncionarios);
            
            //Descarregar qualquer dado dos buffers das duas streams:
            objectOutputStream.flush();
            fileOutputStream.flush();
            //Cessar o envio de dados:
            objectOutputStream.close();
            fileOutputStream.close();
            //Liberar espaco na memoria:
            objectOutputStream = null;
            fileOutputStream = null;
            
        } catch (FileNotFoundException execao) {
            System.out.println(execao);
        } catch (IOException execao) {
            System.out.println(execao);
        }
        
    }
    
    public void load () {
        
    }
    
}
