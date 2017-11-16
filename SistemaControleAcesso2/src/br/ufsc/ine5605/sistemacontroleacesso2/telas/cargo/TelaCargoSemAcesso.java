/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
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
 * @author 03851937007
 */
public class TelaCargoSemAcesso extends JFrame {
    private JLabel labelCodigo;
    private JTextField campoCodigo;
    private JLabel labelNome;
    private JTextField campoNome;
    private JButton botaoCriar;
    private JButton botaoVoltar;
    private GerenciadorBotoes gerenciadorBotoes;
            
    //Construtor:
    public TelaCargoSemAcesso () {
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Cadastrar um Cargo:");
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
        this.getContentPane().add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
        painel.setLayout(new GridBagLayout()); //Defino o Laytou para o GridBag
        //Criar as especificacoes para o meu GridBag:
        GridBagConstraints constraints = new GridBagConstraints();
        
        //
        //Rotulos:
        //
        
        //Definir o primeiro rotulo:
        this.labelCodigo = new JLabel("Insira o código do cargo:    ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelCodigo, constraints);
        
        //Definir o rotulo do nome:
        this.labelNome = new JLabel("Nome do cargo:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelNome, constraints);
        
        
        //
        //Campos:
        //
        
        //Colocar os campos para inserir dados:
        this.campoCodigo = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoCodigo, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoNome = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoNome, constraints);
        
        
        //
        //Botoes:
        //
        this.botaoCriar = new JButton ("Criar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoCriar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoCriar, constraints);
        
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
    
    /**
     * Deixa a tela invisivel.
     */
    public void desligarTela() {
        this.setVisible(false);
    }
    
    /**
     * A partir dos campos inseridos, eh criado um envelope com os dados. Tem integracao
     * com o ControladorCargo.
     * 
     * @return EnvelopeFuncionario - com os dados nescessarios para criar um.
     */
    public EnvelopeCargo criarEnvelope() {
        String numeroCodigo = this.campoCodigo.getText();
        String nome = this.campoNome.getText();
        if (this.campoCodigo.getText().equals("") || this.campoNome.getText().equals("")){
        	throw new IllegalArgumentException("Existe um ou mais campos em branco.");
        }else{
        	return new EnvelopeCargo(numeroCodigo, nome, false);
        }
    }
    
    /**
     * Uma subclasse para cuidar dos botoes.
     */
    public class GerenciadorBotoes implements ActionListener {    
        /**
         * 
         * 
         * @param evento -
         */
        @Override
        public void actionPerformed(ActionEvent evento) {
            //Quando o botao de crair for pressionado:
            if (evento.getSource().equals(botaoCriar)) {
                
                try {
                	
                	
                    //Chama o metodo de adicionar funcionario (joga execoes):
                    ControladorGeral.getInstance().getControladorCargo().adicionarCargo(criarEnvelope());
                    //Trocar para a tela anterior:
                    desligarTela();
                    ControladorGeral.getInstance().getControladorCargo().getTelaCadastrarCargo().iniciarTela();
                    //Tirar os inputs anteriores do buffer:
                    campoCodigo.setText("");
                    campoNome.setText("");

                    
                    
                } catch (IllegalArgumentException execao) { //Vai criar um JOptionPane avisando qual foi o erro de Input:
                    
                    if (execao.getMessage().equals("For input string: \"\"")) {
                        
                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, execao.getMessage());
                        
                    }
                    
                }
                
            } else if (evento.getSource().equals(botaoVoltar)) {
                
                desligarTela();
                ControladorGeral.getInstance().getControladorCargo().getTelaCadastrarCargo().iniciarTela();
                //Tirar os inputs anteriores do buffer:
                campoCodigo.setText("");
                campoNome.setText("");
                    
            }
        }
        
    }
    
}
