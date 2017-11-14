/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.telas;

import br.ufsc.ine5605.sistemacontroleacesso2.telas.funcionario.TelaCadastrarFuncionario;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author PEaug
 */
public class TelaBuscaMatricula {
    
    private JLabel labelMatricula;
    private JTextField campoMatricula;
    private JButton botaoBuscar;
    private JButton botaoVoltar;
    private TelaBuscaMatricula.GerenciadorBotoes gerenciadorBotoes;
    
    public TelaBuscaMatricula(){
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new TelaBuscaMatricula.GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
    //    this.definirGUI();
        


  //  private void definirGUI() {
        JPanel painel = new JPanel(); //Instanciando um conatiner
    //    this.getContentPane().add(painel);
    }



    private static class GerenciadorBotoes {

        public GerenciadorBotoes() {
        }
    }
}
