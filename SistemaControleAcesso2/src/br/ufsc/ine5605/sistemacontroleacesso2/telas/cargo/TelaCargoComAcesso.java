/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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
public class TelaCargoComAcesso extends JFrame {
    private JLabel labelCodigo;
    private JTextField campoCodigo;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelPrimeiroTurno;
    private JLabel labelHoraInicio;
    private JTextField campoHoraInicio;
    private JLabel labelMinutoInicio;
    private JTextField campoMinutoInicio;
    private JLabel labelHoraFim;
    private JTextField campoHoraFim;
    private JLabel labelMinutoFim;
    private JTextField campoMinutoFim;
    private JLabel labelSegundoTurno;
    private JLabel labelSHoraInicio;
    private JTextField campoSHoraInicio;
    private JLabel labelSMinutoInicio;
    private JTextField campoSMinutoInicio;
    private JLabel labelSHoraFim;
    private JTextField campoSHoraFim;
    private JLabel labelSMinutoFim;
    private JTextField campoSMinutoFim;
    private GerenciadorBotoes gerenciadorBotoes;
	private JButton botaoCriar;
	private JButton botaoVoltar;
            
    //Construtor:
    public TelaCargoComAcesso () {
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
        this.labelCodigo = new JLabel("Insira o código do cargo:     ");
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
 
        //Definir o rotulo do nome:
        this.labelPrimeiroTurno = new JLabel("Primeiro turno     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(15,0,8,0);

        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelPrimeiroTurno, constraints);
        
        constraints.insets = new Insets(0,0,0,0);

        
        //Definir o Rotulo do dia do nascimento:
        this.labelHoraInicio = new JLabel("Hora de início:    ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelHoraInicio, constraints);
        
        //Definir o  rotulo do mes:
        this.labelMinutoInicio = new JLabel("Minuto de início:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMinutoInicio, constraints);
        
        //Definir o rotulo do ano:
        this.labelHoraFim = new JLabel("Hora de fim:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelHoraFim, constraints);
        
        //Definir o rotulo do telefone:
        this.labelMinutoFim = new JLabel("Minuto de fim:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMinutoFim, constraints);
        
      //Definir o Rotulo do dia do nascimento:
        this.labelSegundoTurno = new JLabel("Segundo turno    ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        constraints.insets = new Insets(15,0,8,0);

        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSegundoTurno, constraints);
        
        constraints.insets = new Insets(0,0,0,0);

        
        //Definir o Rotulo do dia do nascimento:
        this.labelSHoraInicio = new JLabel("Hora de início:    ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSHoraInicio, constraints);
        
        //Definir o  rotulo do mes:
        this.labelSMinutoInicio = new JLabel("Minuto de início:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSMinutoInicio, constraints);
        
        //Definir o rotulo do ano:
        this.labelSHoraFim = new JLabel("Hora de fim:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSHoraFim, constraints);
        
        //Definir o rotulo do telefone:
        this.labelSMinutoFim = new JLabel("Minuto de fim:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSMinutoFim, constraints);
        
        
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
        
        //Colocar os campos para inserir dados:
        this.campoHoraInicio = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoHoraInicio, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoMinutoInicio = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoMinutoInicio, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoHoraFim = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoHoraFim, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoMinutoFim = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoMinutoFim, constraints);
        
      //Colocar os campos para inserir dados:
        this.campoSHoraInicio = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSHoraInicio, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoSMinutoInicio = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSMinutoInicio, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoSHoraFim = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSHoraFim, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoSMinutoFim = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 11;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSMinutoFim, constraints);
        
        //
        //Botoes:
        //
        this.botaoCriar = new JButton ("Criar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 12;
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
        constraints.gridy = 13;
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
    public EnvelopeCargoComAcesso criarEnvelope() {
        String numeroCodigo = this.campoCodigo.getText();
        String nome = this.campoNome.getText();
        int horaInicio = Integer.parseInt(this.campoHoraInicio.getText());
        int minutoInicio = Integer.parseInt(this.campoMinutoInicio.getText());
        int horaFim = Integer.parseInt(this.campoHoraFim.getText());
        int minutoFim = Integer.parseInt(this.campoMinutoFim.getText());
        int sHoraInicio = Integer.parseInt(this.campoSHoraInicio.getText());
        int sMinutoInicio = Integer.parseInt(this.campoSMinutoInicio.getText());
        int sHoraFim = Integer.parseInt(this.campoSHoraFim.getText());
        int sMinutoFim = Integer.parseInt(this.campoSMinutoFim.getText());
        
        Calendar horarioInicio= Calendar.getInstance();
        horarioInicio.clear();
        horarioInicio.set(Calendar.HOUR, horaInicio);
        horarioInicio.set(Calendar.MINUTE, minutoInicio);
        
        Calendar horarioFim= Calendar.getInstance();
        horarioFim.clear();
        horarioFim.set(Calendar.HOUR, horaFim);
        horarioFim.set(Calendar.MINUTE, minutoFim);
        
        Calendar sHorarioInicio= Calendar.getInstance();
        sHorarioInicio.clear();
        sHorarioInicio.set(Calendar.HOUR, sHoraInicio);
        sHorarioInicio.set(Calendar.MINUTE, sMinutoInicio);
        
        Calendar sHorarioFim= Calendar.getInstance();
        sHorarioFim.clear();
        sHorarioFim.set(Calendar.HOUR, sHoraFim);
        sHorarioFim.set(Calendar.MINUTE, sMinutoFim);
        
        if (horaInicio < 0 || sHoraInicio < 0 || horaInicio > 24 || sHoraInicio > 24) {
            throw new IllegalArgumentException("Hora de início inserida inválida.");
            //Mes nao pode ser abaixo de 1 ou acima de 12
        } else if (minutoInicio < 0 || sMinutoInicio < 0 || minutoInicio > 59 || sMinutoInicio > 59) {
            throw new IllegalArgumentException("Minuto de início inserido inválido.");
            //O dia precisa ser maior do que 1 e menor do que 31
        } else if (horaFim < 0 || sHoraFim < 0 || horaFim > 24 || sHoraFim > 24) {
            throw new IllegalArgumentException("Hora de fim inserida inválida.");
        } else if (minutoFim < 0 || sMinutoFim < 0 || minutoFim > 59 || sMinutoFim > 59) {
            throw new IllegalArgumentException("Minuto de fim inserido inválido.");
        }        

        if (this.campoCodigo.getText().equals("") || this.campoNome.getText().equals("") || this.campoHoraInicio.getText().equals("") || this.campoMinutoInicio.getText().equals("") || this.campoHoraFim.getText().equals("") || this.campoMinutoFim.getText().equals("") || this.campoSHoraInicio.getText().equals("") || this.campoSMinutoInicio.getText().equals("") || this.campoSHoraFim.getText().equals("") || this.campoSMinutoFim.getText().equals("")){
        	throw new IllegalArgumentException("Existe um ou mais campos em branco.");
        }
        return new EnvelopeCargoComAcesso(numeroCodigo, nome,
        horarioInicio, horarioFim, sHorarioInicio, sHorarioFim);
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
                    campoHoraInicio.setText("");
                    campoMinutoInicio.setText("");
                    campoHoraFim.setText("");
                    campoMinutoFim.setText("");
                    campoSHoraInicio.setText("");
                    campoSMinutoInicio.setText("");
                    campoSHoraFim.setText("");
                    campoSMinutoFim.setText("");

                    
                    
                } catch ( IllegalArgumentException execao) { //Vai criar um JOptionPane avisando qual foi o erro de Input:
                    
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
                campoHoraInicio.setText("");
                campoMinutoInicio.setText("");
                campoHoraFim.setText("");
                campoMinutoFim.setText("");
                campoSHoraInicio.setText("");
                campoSMinutoInicio.setText("");
                campoSHoraFim.setText("");
                campoSMinutoFim.setText("");           
            }
        }
        
    }
    
}
