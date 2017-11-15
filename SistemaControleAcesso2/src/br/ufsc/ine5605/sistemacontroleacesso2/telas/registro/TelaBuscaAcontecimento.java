/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.telas.registro;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author PEaug
 */
public class TelaBuscaAcontecimento extends JFrame{
    private GerenciadorBotoes gerenciadorBotoes;
    private JLabel labelAcontecimento;
    private JTextField campoAcontecimento;
    private JButton botaoBuscar;
    private JButton botaoVoltar;
              
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
        
        this.labelAcontecimento = new JLabel("Insira o número do acontecimento:    ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        painel.add(this.labelAcontecimento, constraints);
        
         this.campoAcontecimento = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        painel.add(this.labelAcontecimento, constraints);
        
        this.botaoBuscar = new JButton ("Buscar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoBuscar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoBuscar, constraints);
        
        //Botao para voltar:
        this.botaoVoltar = new JButton ("Voltar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoVoltar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoVoltar, constraints);
    }
      /**
     * Deixa a tela visivel.
     */
    public void iniciarTela() {
       this.setVisible(true);
    }
    
     public void desligarTela() {
        this.setVisible(false);
    }

    class GerenciadorBotoes implements ActionListener{

        public GerenciadorBotoes() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
       
}
