
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
public class TelaFuncionario extends JFrame {
    //Atributos:
    private JButton botaoCadastrar;
    private JButton botaoRemover;
    private JButton botaoListar;
    private JButton botaoModificar;
    private JButton botaoVoltar;
    private GerenciadorBotoes gerenciadorBotoes;
    
    
    //Construtor:
    public TelaFuncionario () {
        //Iniciar o ActionListener (Gerenciador De Botoes):
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Gerenciar Funcionarios:");
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
        
        //Definir o bota de Cadastrar:
        this.botaoCadastrar = new JButton("Cadastrar um Usuário");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o ActionListenre ao botao:
        this.botaoCadastrar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoCadastrar, constraints);
        
        //Botao de remover um usuario:
        this.botaoRemover = new JButton("Remover um Usuário");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoRemover, constraints);
        
        //Botao de Listar um usuario:
        this.botaoListar = new JButton("Listar um Usuário");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoListar, constraints);
        
        //Botao de Modificar um usuario:
        this.botaoModificar = new JButton("Modificar um Usuário");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoModificar, constraints);
        
        //Botao de sair:
        this.botaoVoltar = new JButton("Voltar");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoVoltar, constraints);
        
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
            //Terminar de fazer:
            if (evento.getSource().equals(botaoCadastrar)) {
                ControladorGeral.getInstance().getControladorFuncionario().getTela().desligarTela();
                ControladorGeral.getInstance().getControladorFuncionario().getTelaCadastrarFuncionario().iniciarTela();
            }
        }
        
    }
}
