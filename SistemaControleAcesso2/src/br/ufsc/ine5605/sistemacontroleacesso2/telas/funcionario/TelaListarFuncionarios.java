
package br.ufsc.ine5605.sistemacontroleacesso2.telas.funcionario;

import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao Vitor Venancio
 */
public class TelaListarFuncionarios extends JFrame {
    //Atributos:
    private GerenciadorBotoes gerenciadorBotoes;
    private JTable tabela;
    private JButton botaoVoltar;
    
    //Construtor:
    public TelaListarFuncionarios () {
        //Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();

        //Metodo para configurar a GUI:
        this.definirGUI();

        //Mudar o titula da minha Frame:
        this.setTitle("Listar os Funcionarios:");
        //Quando clicado no X na Frame, não acontece nada:
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE );
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

    private void definirGUI() {        


        
        
    }
    public void mostrarTabela() {
//        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
//        modelo.setRowCount(0);
        
        DefaultTableModel modelo = new DefaultTableModel(); 
        tabela = new JTable(modelo); 
        
        //Criar as colunas:
        modelo.addColumn("Numero da Matricula"); 
        modelo.addColumn("Nome"); 
        modelo.addColumn("Telefone"); 
        modelo.addColumn("Salario"); 
        modelo.addColumn("Cargo"); 
        modelo.addColumn("Data de Nascimento"); 
        //Adicionar uma linha:
        for (Funcionario funcionarioLista : ControladorGeral.getInstance().getControladorFuncionario().getMapeador().getFuncionarios()) {
            modelo.addRow(new Object[]{ String.valueOf(funcionarioLista.getNumeroDeMatricula()), funcionarioLista.getNome(), funcionarioLista.getTelefone(),
            String.valueOf(funcionarioLista.getSalario()), funcionarioLista.getCargo().getNome(), funcionarioLista.getDataDeNascimento().toString()} );
        }
        
        tabela.setPreferredScrollableViewportSize(new Dimension(600,600));
        tabela.setFillsViewportHeight(true);
        
        JScrollPane painelRolavel = new JScrollPane(tabela);
        
        this.getContentPane().add(painelRolavel);
        
//        JPanel painel = new JPanel(); //Um novo Container para o meu Frame (JFrame)
//        painelRolavel.add(painel); //Pego o Container do meu JFrame e adiciono o Container do java swing (JPanel). Mexo agora apenas com o Container (JPane) do Swing
//        painel.setLayout(new GridBagLayout()); //Defino o Laytou para o GridBag
//        //Criar as especificacoes para o meu GridBag:
//        GridBagConstraints constraints = new GridBagConstraints();
//        
//        //Botao para voltar:
//        this.botaoVoltar = new JButton("Voltar");
//        //Definir o layout:
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.weightx = 0;
//        constraints.weighty = 0;
//        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
//        constraints.fill = GridBagConstraints.BOTH;
//        //Adicioanr o action listener:
//        this.botaoVoltar.addActionListener(this.gerenciadorBotoes);
//        //Adicionar o botao:
//        painel.add(this.botaoVoltar, constraints);
    }
    
    /**
     * Deixa a tela visivel.
     */
    public void iniciarTela() {
        this.setVisible(true);
        this.mostrarTabela();
    }

    /**
     * Deixa a tela invisivel.
     */
    public void desligarTela() {
        this.setVisible(false);
    }
    
    public class GerenciadorBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
