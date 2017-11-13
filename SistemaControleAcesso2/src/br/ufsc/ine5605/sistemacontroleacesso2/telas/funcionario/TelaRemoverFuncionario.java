
package br.ufsc.ine5605.sistemacontroleacesso2.telas.funcionario;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
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
 * @author Joao Vitor Venancio
 */
public class TelaRemoverFuncionario extends JFrame {
    //Atributos:
    private JLabel labelMatricula;
    private JTextField campoMatricula;
    private JButton botaoRemover;
    private JButton botaoVoltar;
    private GerenciadorBotoes gerenciadorBotoes;
            
    //Construtor:
    public TelaRemoverFuncionario () {
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Remover um Funcionario:");
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
        this.labelMatricula = new JLabel("Insira o numero de matricula:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMatricula, constraints);
        
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
        
        //
        //Botoes:
        //
        this.botaoRemover = new JButton ("Remover");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoRemover.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoRemover, constraints);
        
        //Botao para voltar:
        this.botaoVoltar = new JButton ("Voltar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 2;
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
            //Quando o botao de remover for pressionado:
            if (evento.getSource().equals(botaoRemover)) {
                //Ele converte o input do campoMatricula para uma Integer, caso nao for numero, ele joga uma execao -> tratar
                try {
                    //Pegar o valor do campo de texto:
                    Integer matricula = Integer.valueOf(campoMatricula.getText());
                    //Se encontrar o Funcionario e remover:
                    if (ControladorGeral.getInstance().getControladorFuncionario().removerFuncionarioPelaMatricula(matricula) == true ) { 
                    //Avisar o usuario do sucesso:
                    JOptionPane.showMessageDialog(null, "Funcionario Removido com Sucesso!");
                    //Tirar os inputs anteriores do buffer:
                    campoMatricula.setText("");
                    
                    } else { //Caso não encontrar:
                        //Avisar sobre o ocorrido:
                        JOptionPane.showMessageDialog(null, "Funcionario não encontrado, tente novamente.");
                    }
                    
                } catch (NumberFormatException execao) {
                    
                    JOptionPane.showMessageDialog(null, "Insira Apenas Numeros.");
                    
                }
                               
            } else if (evento.getSource().equals(botaoVoltar)) {
                
                desligarTela();
                ControladorGeral.getInstance().getControladorFuncionario().getTela().iniciarTela();
                //Tirar os inputs anteriores do buffer:
                campoMatricula.setText("");
                    
            }
        }
        
    }
    
}
