/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.controladores;

import br.ufsc.ine5605.sistemacontroleacesso2.mapeadores.MapeadorRegistro;
import br.ufsc.ine5605.sistemacontroleacesso2.Registro;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeRegistro;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaBuscaAcontecimento;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaBuscaMatricula;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.registro.TelaControladorRegistros;
import java.util.Collection;



/**
 *
 * @author PEaug
 */
public class ControladorRegistros {
    //Atributos:
    /**
     * Controlador Geral responsável por essa instância de controlador
     */
    private ControladorGeral controladorGeral;

    /**
     * Tela de Registro desse Controlador
     */
    //private TelaRegistro telaRegistro;

    /**
     * ArrayList que armazena os registros gerados
     */
    private MapeadorRegistro mapeadorRegistro;

    /**
     * @param controladorGeral ControladorGeral - Controlador Geral responsável
     * por esse Controlador
     */
    
    private TelaControladorRegistros telaControladorRegistros;
    
    private TelaBuscaMatricula telaBuscaMatricula;
    
    private TelaBuscaAcontecimento telaBuscaAcontecimento;
    
    //Construtor
    public ControladorRegistros(ControladorGeral controladorGeral) {
        this.controladorGeral = controladorGeral;
        this.mapeadorRegistro = new MapeadorRegistro();
        this.telaControladorRegistros = new TelaControladorRegistros();
        this.telaBuscaMatricula = new TelaBuscaMatricula();
        this.telaBuscaAcontecimento = new TelaBuscaAcontecimento();
    }

    /**
     * Método que inicia a tela
     */
    public void iniciarTela() {
        //this.telaRegistro.iniciar();
    }

    /**
     * Método responsável pela busca de registros com um respectivo Enum
     *
     * @param indiceDoAcontecimento int - �ndice do Enum que se deseja usar para
     * a busca
     * @return registrosEncontrados ArrayList - ArrayList com os registros
     * selecionados
     */
   
// public ArrayList<Registro> findRegistroByAcontecimento(int indiceDoAcontecimento) {
        //Criando o ArrayList de Retorno
    //    ArrayList<Registro> registrosEncontrados = new ArrayList<>();
        //Criando o Vetor com os índices do Enum
    //    AcontecimentoRegistro[] acontecimentos = AcontecimentoRegistro.values();
        //Iniciando a busca no Array do Controlador por Objetos com Enum igual ao do parametro 
    //    for (Registro registroBusca : arrayDeRegistros) {
            //Se o registroBusca tiver um Enum igual ao Enum que está sendo apontado pelo vetor     
    //        if (registroBusca.getAcontecimento().equals(acontecimentos[indiceDoAcontecimento])) {
                //O registro que satisfaz a condição é adicionado ao Array de retorno
    //            registrosEncontrados.add(registroBusca);
       //     }
    //    }
        //Retornando o Array para a tela  
    //    return registrosEncontrados;
    //}

    /**
     * Método responsável por buscar registros no Array do controlador usando um
     * número de matrícula
     *
     * @param numerodeMatricula int - Número de matrícula a ser buscado no Array
     * de Registros
     * @return registrosEncontrados ArrayList - Array dos Registros que possuem
     * o mesmo número de matrícula dado por parâmetro
     */
   // public ArrayList<Registro> findRegistroByMatricula(int numerodeMatricula) {
        //Criando o ArrayList de Retorno
   //     ArrayList<Registro> registrosEncontrados = new ArrayList<>();
        /*Iniciando a busca no Array de Registros do Controlador por Objetos que
         *possuam o mesmo número de matrícula passado por parametro
         */
   //     for (Registro registroBusca : arrayDeRegistros) {
 //           if (registroBusca.getNumDeMatricula() == numerodeMatricula) {
   //             registrosEncontrados.add(registroBusca);
     //       }
       // }
      //  return registrosEncontrados;
    //}

    /**
     * Método que adiciona um novo Registro no HashMap do MapeadorRegistro
     *
     * @param envelope - Registro a ser adicionado
     */
    public void adicionarRegistro(EnvelopeRegistro envelope) {
        if(envelope.acontecimento != null){
            Registro novoRegistro = new Registro(envelope.acontecimento, envelope.dataAcontecimento, envelope.numDeMatricula, envelope.chave);
            this.mapeadorRegistro.put(novoRegistro);
        } 
    }

    /**
     * Método que retorna o ArrayList que armazena os Registros do sistema
     *
     * @return arrayDeRegistros ArrayList - ArrayList que armazena os Registros
     * do sistema
     */
    public Collection<Registro> getArrayDeRegistros() {
        return this.mapeadorRegistro.getList();
    }

    /**
     * Método que retorna para o Controlador Geral responsável por esse
     * controlador
     *
     * @return controladorGeral ControladorGeral - Controlador Geral responsável
     * por esse controlador3
     */
    public ControladorGeral getControladorGeral() {
        return controladorGeral;
    }
    
    public TelaControladorRegistros getTela(){
        return this.telaControladorRegistros;
    }
    
    public TelaBuscaMatricula getTelaBuscaMatricula(){
        return this.telaBuscaMatricula;
    }
    
    public TelaBuscaAcontecimento getTelaBuscaAcontecimento(){
        return this.telaBuscaAcontecimento;
    }
    
    
}
