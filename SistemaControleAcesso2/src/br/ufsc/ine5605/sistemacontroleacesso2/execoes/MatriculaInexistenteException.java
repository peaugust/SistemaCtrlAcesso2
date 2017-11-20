/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.execoes;


/**
 *
 * @author PEaug
 */
public class MatriculaInexistenteException extends IllegalArgumentException {

    public MatriculaInexistenteException() {
        super("Não existe funcionário com essa matrícula");
    }
    
    
}
