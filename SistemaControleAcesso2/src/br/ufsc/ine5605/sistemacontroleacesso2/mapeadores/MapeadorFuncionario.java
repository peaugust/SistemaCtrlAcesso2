package br.ufsc.ine5605.sistemacontroleacesso2.mapeadores;

import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
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
    
    /**
     * Converte dados estaticos de um arquivo em dados dinamicos para serem
     * manipulados dentro da maquina virtual do java.
     */
    public void load () {
        try {
            //Abrir um fluxo de dados saindo de um arquivo:
            FileInputStream fileInputStream = new FileInputStream(this.nomeDoArquivo);
            //Criar um caminho de dados para serem convertidos em Objetos dinamicos
            //dentro do java:
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            //Pegar os dados que foram enviados do arquivo e gerar um objeto.
            //por fim associar esse objeto a nossa "cache" de funcionarios,
            //isso para que possamos manipualr os dados.
            this.cacheFuncionarios = (HashMap<Integer, Funcionario>) objectInputStream.readObject();
            
            //Fechar os fluxos de dados:
            objectInputStream.close();
            fileInputStream.close();
            //Liberar espaco na memoria:
            objectInputStream = null;
            fileInputStream = null;
            
        } catch (FileNotFoundException execao) {
            System.out.println(execao);
        } catch (IOException execao) {
            System.out.println(execao);
        } catch (ClassNotFoundException execao) {
            System.out.println(execao);
        }
        
    }
    
    public Collection<Funcionario> getFuncionarios() {
        return this.cacheFuncionarios.values();
    }
    
    /**
     * Metodo que remove um Funcionario de acordo com a sua Key (definida como
     * a sua matricula).
     * 
     * @param chaveFuncionario - Do Funcionario que se quer remover.
     * @return  true - Caso existe um Funcionario com essa matricula (e foi
     * removida) / false - Caso nao exista um Funcioanrio com essa matricula.
     */
    public boolean removeByMatricula (Integer chaveFuncionario) {
        if (this.cacheFuncionarios.remove(chaveFuncionario) == null) {
            return false;
        } else {
            return true;
        }
    }
}
