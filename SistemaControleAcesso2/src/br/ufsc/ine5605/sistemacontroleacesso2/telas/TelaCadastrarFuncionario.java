
package br.ufsc.ine5605.sistemacontroleacesso2.telas;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import java.awt.Component;
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
 * @author Joao Vitor Venancio
 */
public class TelaCadastrarFuncionario extends JFrame {
    //Atributos:
    private JLabel labelMatricula;
    private JTextField campoMatricula;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDia;
    private JTextField campoDia;
    private JLabel labelMes;
    private JTextField campoMes;
    private JLabel labelAno;
    private JTextField campoAno;
    private JLabel labelTelefone;
    private JTextField campoTelefone;
    private JLabel labelSalario;
    private JTextField campoSalario;
    private JLabel labelCargo;
    private JTextField campoCargo;
            
    //Construtor:
    public TelaCadastrarFuncionario () {
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Cadastrar um Funcionario:");
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
    private void definirGUI () {
        JPanel painel = new JPanel (); //Um novo Container para o meu Frame (JFrame)
        this.getContentPane().add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
        painel.setLayout(new GridBagLayout()); //Defino o Laytou para o GridBag
        //Criar as especificacoes para o meu GridBag:
        GridBagConstraints constraints = new GridBagConstraints();
        
        //Definir o primeiro rotulo:
        this.labelMatricula = new JLabel("Insira um numero de matricula:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMatricula, constraints);
        
        //Definir o rotulo do nome:
        this.labelNome = new JLabel("Nome do funcionario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelNome, constraints);
        
        //Definir o Rotulo do dia do nascimento:
        this.labelDia = new JLabel("Dia do nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelDia, constraints);
        
        //Definir o  rotulo do mes:
        this.labelMes = new JLabel("Mes do nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMes, constraints);
        
        //Definir o rotulo do ano:
        this.labelAno = new JLabel("Ano do nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelAno, constraints);
        
        //Definir o rotulo do telefone:
        this.labelTelefone = new JLabel("Telefone do funcionario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelTelefone, constraints);
        
        //Definir o rotulo do salario:
        this.labelSalario = new JLabel("Salario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSalario, constraints);
        
        //############ Colocar botao para ver todos os cargos (listar eles) ##############
        
        //Definir o rotulo do cargo:
        this.labelCargo = new JLabel("Digite o código do cargo:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelCargo, constraints);
        
        //
        //Campos:
        //
        
        //Colocar os campos para inserir dados:
        this.campoMatricula = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoMatricula, constraints);
        
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
        this.campoDia = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoDia, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoMes = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoMes, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoAno = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoAno, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoTelefone = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoTelefone, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoSalario = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSalario, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoCargo = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoCargo, constraints);
        
    }
    
    public void iniciarTela() {
        this.setVisible(true);
    }
    
    public void desligarTela() {
        this.setVisible(false);
    }
    
}
