
package br.ufsc.ine5605.sistemacontroleacesso2.telas.portafinanceiro;

import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
 * @author Joao Vitor Venancio
 */
public class TelaPortaFinanceiro extends JFrame {
    //Atributos:
    private JLabel labelMatricula;
    private JTextField campoMatricula;
    private JLabel labelHora;
    private JTextField campoHora;
    private JLabel labelMinuto;
    private JTextField campoMinuto;
    private JButton botaoDestrancar;
    private JButton botaoVoltar;
    private GerenciadorBotoes gerenciadorBotoes;
            
    //Construtor:
    public TelaPortaFinanceiro () {
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();
        
        //Metodo para configurar a GUI:
        this.definirGUI();
        
        //Mudar o titula da minha Frame:
        this.setTitle("Porta do Financeiro");
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
        this.labelMatricula = new JLabel("Inisra a sua Matrícula:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMatricula, constraints);
        
        //Definir o primeiro rotulo:
        this.labelHora = new JLabel("Inisra a Hora Atual:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelHora, constraints);
        
        //Definir o primeiro rotulo:
        this.labelMinuto = new JLabel("Inisra os Minutos Atuais:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMinuto, constraints);
        
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
        this.campoHora = new JTextField(2);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoHora, constraints);
        
        //Colocar os campos para inserir dados:
        this.campoMinuto = new JTextField(2);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoMinuto, constraints);
        
        //
        //Botoes:
        //
        
        this.botaoDestrancar = new JButton ("Destrancar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoDestrancar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoDestrancar, constraints);
        
        //Botao para voltar:
        this.botaoVoltar = new JButton ("Voltar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 4;
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
            //Quando o botao de destrancar for pressionado:
            if (evento.getSource().equals(botaoDestrancar)) {

                try {
                    //Pegar os valores dos campos de texto:
                    int matricula = Integer.parseInt(campoMatricula.getText()); //Joga execao
                    int hora = Integer.parseInt(campoHora.getText());
                    int minutos = Integer.parseInt(campoMinuto.getText());
                    //Ver se eh uma hroa váilda:
                    if (!(hora >= 0 && hora <= 24)) {
                        throw new IllegalArgumentException("Hora inváilda, insira um valor entre 0 e 24 horas.");
                    }
                    //Tratar os minutos:
                    if (!(minutos >= 0 && minutos <= 60)) {
                        throw new IllegalArgumentException("Minutos inválidos, insira um valor entre 0 e 60 minutos.");
                    }
                    
                    //Criar o Calendar com os dados obtidos:
                    Calendar horario = Calendar.getInstance();
                    horario.clear();
                    horario.set(Calendar.HOUR_OF_DAY, hora);
                    horario.set(Calendar.MINUTE, minutos);
                    
                    //Desbloquear a porta:
                    String resposta = ControladorGeral.getInstance().getControladorPortaFinanceiro().abrirPorta(matricula, horario);
                    //Avisar o Usuario sobre o resultado:
                    
                    JOptionPane.showMessageDialog(null, resposta);
                    
                    //Tirar os inputs anteriores do buffer:
                    campoMatricula.setText("");
                    campoHora.setText("");
                    campoMinuto.setText("");
                    
                    
                } catch (NumberFormatException execao) { //Se nao conseguir transformar para int
                    
                    JOptionPane.showMessageDialog(null, "Só é aceito numros como entrada de dados.");
                    
                } catch ( IllegalArgumentException execao) { //Erros de regra de negocio / campo em branco:
                    
                    if (execao.getMessage().equals("For input string: \"\"")) {
                        
                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, execao.getMessage());
                        
                    }
                    
                }
                
            } else if (evento.getSource().equals(botaoVoltar)) {
                
                desligarTela();
                ControladorGeral.getInstance().getTela().iniciarTela();
                //Tirar os inputs anteriores do buffer:
                campoMatricula.setText("");
                campoHora.setText("");
                campoMinuto.setText("");
                    
            }
        }
        
    }
    
}
