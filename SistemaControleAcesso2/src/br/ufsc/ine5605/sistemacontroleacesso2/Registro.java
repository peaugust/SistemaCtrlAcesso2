/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2;

import br.ufsc.ine5605.sistemacontroleacesso2.mapeadores.MapeadorRegistro;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class Registro implements Serializable {
    //Atributos
        /**
     * Atributo para indicar a versao que foi feita essa classe, caso ser feita
     * outra versao do sistema
     */
    private static final long serialVersionUID = 1L;
    
    private AcontecimentoRegistro acontecimento;
    private Calendar dataAcontecimento;
    private int numDeMatricula;
    private int chave;
    /**Construtor de Registro
     * 
     * @param acontecimento acontecimento que gerou o registro
     * @param dataAcontecimento data do acontecimento que gerou o registro
     * @param numDeMatricula número de matrícula do funcionário que gerou o 
     * registro
     */
    public Registro(AcontecimentoRegistro acontecimento, Calendar dataAcontecimento, int numDeMatricula, int chave) {
        this.acontecimento = acontecimento;
        this.dataAcontecimento = dataAcontecimento;
        this.numDeMatricula = numDeMatricula;
        this.chave = chave;
    }
    
    //Metodos
    public AcontecimentoRegistro getAcontecimento() {
        return this.acontecimento;
    }

    public Calendar getDataAcontecimento() {
        return this.dataAcontecimento;
    }

    public int getNumDeMatricula() {
        return this.numDeMatricula;
    }
    
    public int getChave(){
        return this.chave;
    }
    
    
}

