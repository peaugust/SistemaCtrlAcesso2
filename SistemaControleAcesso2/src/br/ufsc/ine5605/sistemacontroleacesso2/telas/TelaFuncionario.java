
package br.ufsc.ine5605.sistemacontroleacesso2.telas;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    
    
    //Construtor:
    public TelaFuncionario () {
        //Metodo para configurar a GUI:
        this.definirGUI();
        //Quando clicado no X, não acontece nada:
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //Definir o tamanho da Janela (Herdado de Window):
        this.setSize(600, 600);
        //Definir que a a Janela vai ser criada no centro da tela:
        this.setLocationRelativeTo(null);
        //Se pode ser modificado o tamanho dela:
        this.setResizable(true);
        //Deixar que seja visto:
        this.setVisible(true);
        
    }
    
    //Metodos:
    private void definirGUI () {
        JPanel painel = new JPanel (); //Um novo Container para o meu Frame (JFrame)
        this.getContentPane().add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
        painel.setLayout(new GridBagLayout()); //Defino o Laytou para o GridBag
        //Criar as especificacoes para o meu GridBag:
        GridBagConstraints constraints = new GridBagConstraints();
        
        //Criar um novo botao:
        this.botaoCadastrar = new JButton("Cadastrar um Usuário");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o botao:
        painel.add(this.botaoCadastrar, constraints);
        
    }
}
