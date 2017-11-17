package br.ufsc.ine5605.sistemacontroleacesso2.mapeadores;

import br.ufsc.ine5605.sistemacontroleacesso2.Cargo;
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
public class MapeadorCargo {
    //Atributos:
    /**
     * Atributo que tem uma key correspondendo a um dado de Cargo. Para
     * cada Cargo, temos uma chave que caracteriza/indica quem eh ele.
     * Esse atributo representa os dados que vao ser escritos/lidos pelo mapeador,
     * existindo como dados dinamicos apenas quando a aplicacao for iniciada.
     */
    private HashMap<String, Cargo> cacheCargos;
    /**
     * Nome do arquivo que vai ser armazendo os dados dos Cargos.
     */
    private final String nomeDoArquivo = "Cargos.dat";
    
    //Construtor:
    /**
     * Cria um MapeadorCargo. Inicializa o HashMap.
     */
    public MapeadorCargo () {
        this.cacheCargos =  new HashMap<>();
    }
    
    //Metodos:
    /**
     * Procura na HashMap pelo Cargo (dado) que corresponde a Key dada
     * como input do método.
     * 
     * @param chaveCargo - Chave para procurar na HashMap.
     * @return Cargo que corresponde a sua Key || null se não encontrar.
     */
    public Cargo get (String chaveCargo) {
        return this.cacheCargos.get(chaveCargo);
    }
    
    /**
     * Recebe um dado para armazenar no HashMap. Nao precisa de uma key porque
     * pegamos direto o numero de codigo dos Cargos.
     * 
     * @param Cargo - Entidade que vai ser armazenda no HashMap.
     */
    public void put (Cargo Cargo) {
        this.cacheCargos.put(Cargo.getCodigo(), Cargo);
        
        this.persist();
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
            objectOutputStream.writeObject(this.cacheCargos);
            
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
            //por fim associar esse objeto a nossa "cache" de Cargos,
            //isso para que possamos manipualr os dados.
            this.cacheCargos = (HashMap<String, Cargo>) objectInputStream.readObject();
            
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
    
    /**
     * Metodo que retorna os Objetos Cargos da HasMap em uma Collection de
     * Cargos. Chama o HashMap.values().
     * 
     * @return Collection - de Cargos.
     */
    public Collection<Cargo> getCargos() {
        return this.cacheCargos.values();
    }
    
    /**
     * Metodo que remove um Cargo de acordo com a sua Key (definida como
     * a sua codigo).
     * 
     * @param codigo - Do Cargo que se quer remover.
     * @return  true - Caso existe um Cargo com essa codigo (e foi
     * removida) / false - Caso nao exista um Cargo com essa codigo.
     */
    public boolean removeByCodigo (String codigo) {
        return this.cacheCargos.remove(codigo) != null;
    }
    
}

