
package br.ufsc.ine5605.sistemacontroleacesso2.telas;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Joao Vitor Venancio
 */
public class TelaControladorGeral extends JFrame {
    //Atributos:
    private JButton botaoCargos;
    private JButton botaoFuncionarios;
    private JButton botaoRegistros;
    private JButton botaoPorta;
    private JButton botaoSair;
    private GerenciadorBotoes gerenciadorBotoes;
    
    
    //Construtor:
    public TelaControladorGeral () {
        //Instanciar o ActionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Sistema de Controle de Acesso V.2:");
        //Quando clicado no X na Frame, não acontece nada:
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        
        //Definir o bota de Cadastrar:
        this.botaoCargos = new JButton("Gerenciar Cargos");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o ActionListenre ao botao:
        this.botaoCargos.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoCargos, constraints);
        
        //Botao de remover um usuario:
        this.botaoFuncionarios = new JButton("Gerenciar Funcionarios");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o ActionListenre ao botao:
        this.botaoFuncionarios.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoFuncionarios, constraints);
        
        //Botao de Listar um usuario:
        this.botaoRegistros = new JButton("Gerenciar Registros");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoRegistros, constraints);
        
        //Botao de Modificar um usuario:
        this.botaoPorta = new JButton("Usar a Porta");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoPorta, constraints);
        
        //Botao de sair:
        this.botaoSair = new JButton("Sair da Aplicação");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o ActionListener nele:
        botaoSair.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoSair, constraints);
        
    }
    
    public void iniciarTela() {
        this.setVisible(true);
    }
    
    public void desligarTela() {
        this.setVisible(false);
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
            //!!!Adicionar mais comparacoes ao adicionar mais telas!!!
            if (evento.getSource().equals(botaoFuncionarios)) {
                ControladorGeral.getInstance().getTela().desligarTela();
                ControladorGeral.getInstance().getControladorFuncionario().getTela().iniciarTela();
            } else if (evento.getSource().equals(botaoSair)) {
                System.exit(0);
            }
        }
        
    }
}
