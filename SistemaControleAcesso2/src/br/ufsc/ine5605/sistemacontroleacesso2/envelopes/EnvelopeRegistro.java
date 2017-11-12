/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso2.AcontecimentoRegistro;
import java.util.Calendar;

/**
 *
 * @author PEaug
 */
public class EnvelopeRegistro {
        public AcontecimentoRegistro acontecimento;
    public Calendar dataAcontecimento;
    public int numDeMatricula;
    
    public EnvelopeRegistro(AcontecimentoRegistro acontecimento, 
            Calendar dataAcontecimento, int numDeMatricula) {
        this.acontecimento = acontecimento;
        this.dataAcontecimento = dataAcontecimento;
        this.numDeMatricula = numDeMatricula;
    }
}
