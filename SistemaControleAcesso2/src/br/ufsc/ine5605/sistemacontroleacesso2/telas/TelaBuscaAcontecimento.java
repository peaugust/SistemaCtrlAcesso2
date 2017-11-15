/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.telas;

import br.ufsc.ine5605.sistemacontroleacesso2.telas.funcionario.TelaCadastrarFuncionario;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author PEaug
 */
public class TelaBuscaAcontecimento extends JFrame{
    private GerenciadorBotoes gerenciadorBotoes;
            
    //Construtor:
    public TelaBuscaAcontecimento () {
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Busacr Usando Acontecimento:");
        //Quando clicado no X na Frame, não acontece nada:
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //Definir o tamanho da Janela(Herdado de Window):
        this.setSize(600, 600);
        //Definir que a Janela vai ser criada no centro da tela:
        this.setLocationRelativeTo(null);
        //Se pode ser modificado o tamanho dela:
        this.setResizable(true);
        //Deixar que seja visto:
        this.setVisible(false);
        
    }
    
    //Metodos:
    /**
     * Metodo que eh chamado para fazer todas as configuracoes (disposicoes de botoes e textos)
     * dentro da GUI.
     */
    private void definirGUI () {
        JPanel painel = new JPanel (); //Um novo Container para o meu Frame (JFrame)
        //this.getContentPane().add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
        painel.setLayout(new GridBagLayout()); //Defino o Laytou para o GridBag
        //Criar as especificacoes para o meu GridBag:
        GridBagConstraints constraints = new GridBagConstraints();
    }
      /**
     * Deixa a tela visivel.
     */
    public void iniciarTela() {
       this.setVisible(true);
    }

    static class GerenciadorBotoes {

        public GerenciadorBotoes() {
        }
    }
    
    /**
     * Deixa a tela invisivel.
     */
   public void desligarTela() {
       this.setVisible(false);
   }
   
}
