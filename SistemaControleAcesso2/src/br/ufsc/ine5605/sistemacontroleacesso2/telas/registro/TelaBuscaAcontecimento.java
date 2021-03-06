/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.telas.registro;

import br.ufsc.ine5605.sistemacontroleacesso2.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso2.Registro;
import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PEaug
 */
public class TelaBuscaAcontecimento extends JFrame {

    private GerenciadorBotoes gerenciadorBotoes;
    private JLabel labelAcontecimento;
    private JButton botaoBuscar;
    private JButton botaoVoltar;
    private JTable jTableItens;
    private JScrollPane spBaseTabela;
    private JComboBox jComboAcontecimentos;

    //Construtor:
    public TelaBuscaAcontecimento() {
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
     * Metodo que eh chamado para fazer todas as configuracoes (disposicoes de
     * botoes e textos) dentro da GUI.
     */
    private void definirGUI() {
        JPanel painel = new JPanel(); //Um novo Container para o meu Frame (JFrame)
        this.getContentPane().add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
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

        //this.campoAcontecimento = new JTextField(15);
        this.jComboAcontecimentos = new JComboBox(AcontecimentoRegistro.values());
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        painel.add(this.jComboAcontecimentos, constraints);
        //painel.add(this.campoAcontecimento, constraints);

        this.botaoBuscar = new JButton("Buscar");
        //Definir o layout:
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 1; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoBuscar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoBuscar, constraints);

        //Botao para voltar:
        this.botaoVoltar = new JButton("Voltar");
        //Definir o layout:
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 1; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoVoltar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoVoltar, constraints);

        this.jTableItens = new JTable();
        this.jTableItens.setPreferredScrollableViewportSize(new Dimension(500, 100));
        this.jTableItens.setFillsViewportHeight(true);
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.spBaseTabela = new JScrollPane(jTableItens);
        painel.add(spBaseTabela, constraints);
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

    public void updateData(ArrayList<Registro> itens) {

        DefaultTableModel modelTbItens = new DefaultTableModel();
        modelTbItens.addColumn("Data");
        modelTbItens.addColumn("Matrícula");

        for (Registro registroBusca : itens) {
            modelTbItens.addRow(new Object[]{registroBusca.getDataAcontecimento().getTime(), registroBusca.getNumDeMatricula()});

        }

        jTableItens.setModel(modelTbItens);
        this.repaint();
    }
    //TODO: FAZER A LISTAGEM

    public class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource().equals(botaoBuscar)) {

                try {
                    //Chama o metodo de adicionar funcionario (joga execoes):
                    updateData(ControladorGeral.getInstance().getControladorRegistros().findRegistroByAcontecimento(jComboAcontecimentos.getSelectedIndex()));

                } catch (IllegalArgumentException execao) { //Vai criar um JOptionPane avisando qual foi o erro de Input:

                    if (execao.getMessage().equals("For input string: \"\"")) {

                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");

                    } else {

                        JOptionPane.showMessageDialog(null, execao.getMessage());

                    }

                }

            } else if (evento.getSource().equals(botaoVoltar)) {

                desligarTela();
                ControladorGeral.getInstance().getControladorRegistros().getTela().iniciarTela();

            }
        }

    }

}
