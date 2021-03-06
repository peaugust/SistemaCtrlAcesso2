package br.ufsc.ine5605.sistemacontroleacesso2.telas.funcionario;

import br.ufsc.ine5605.sistemacontroleacesso2.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso2.controladores.ControladorGeral;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TelaModificarFuncionario extends JFrame {

    //Atributos:
    private JLabel labelMatricula;
    private JTextField campoMatricula;
    private JLabel labelNovaMatricula;
    private JTextField campoNovaMatricula;
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
//    private JTextField campoCargo;
    private JComboBox comboCargo;
    private JButton botaoCarregar;
    private JButton botaoModificar;
//    private JButton botaoListarCargos;
    private JButton botaoVoltar;
    private GerenciadorBotoes gerenciadorBotoes;

    //Construtor:
    public TelaModificarFuncionario() {    	
    	//Iniciarlizar o AcitionListener:
        this.gerenciadorBotoes = new GerenciadorBotoes();

        //Metodo para configurar a GUI:
        this.definirGUI();

        //Mudar o titula da minha Frame:
        this.setTitle("Modificar um Funcionario:");
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

        //
        //Rotulos:
        //
        
        //Definir o primeiro rotulo:
        this.labelMatricula = new JLabel("Insira um numero de matricula para modificar:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMatricula, constraints);

        //Definir o rotulo da nova matricula:
        this.labelNovaMatricula = new JLabel("Novo (ou deixe o mesmo) Numero de Matricula:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelNovaMatricula, constraints);

        //Definir o rotulo do nome:
        this.labelNome = new JLabel("Novo Nome do Funcionario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelNome, constraints);

        //Definir o Rotulo do dia do nascimento:
        this.labelDia = new JLabel("Novo Dia do Nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelDia, constraints);

        //Definir o  rotulo do mes:
        this.labelMes = new JLabel("Novo Mes de Nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelMes, constraints);

        //Definir o rotulo do ano:
        this.labelAno = new JLabel("Novo Ano do Nascimento:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelAno, constraints);

        //Definir o rotulo do telefone:
        this.labelTelefone = new JLabel("Novo Telefone do Funcionario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelTelefone, constraints);

        //Definir o rotulo do salario:
        this.labelSalario = new JLabel("Novo Salario:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar esse rotulo ao meu container:
        painel.add(this.labelSalario, constraints);

        //############ Colocar botao para ver todos os cargos (listar eles) ##############
        
        //Definir o rotulo do cargo:
        this.labelCargo = new JLabel("Digite o código do novo cargo:     ");
        //Definir suas especificacoes dentro do GridBagLayout:
        constraints.gridx = 0;
        constraints.gridy = 10;
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

        //Campo para a inserir a nova matricula:
        this.campoNovaMatricula = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoNovaMatricula, constraints);

        //Colocar os campos para inserir dados:
        this.campoNome = new JTextField(15);
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 4;
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
        constraints.gridy = 5;
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
        constraints.gridy = 6;
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
        constraints.gridy = 7;
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
        constraints.gridy = 8;
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
        constraints.gridy = 9;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
        //Adicionar o campo ao meu container:
        painel.add(this.campoSalario, constraints);

//        //Colocar os campos para inserir dados:
//        this.campoCargo = new JTextField(15);
//        //Definir as suas configurações:
//        constraints.gridx = 1;
//        constraints.gridy = 10;
//        constraints.weightx = 0;
//        constraints.weighty = 0;
//        constraints.anchor = GridBagConstraints.LINE_START;
//        constraints.fill = GridBagConstraints.BOTH;
//        //Adicionar o campo ao meu container:
//        painel.add(this.campoCargo, constraints);
        
        //
        //CombBox:
        //
        
        //Colocar os campos para inserir dados:
        this.comboCargo = new JComboBox();
        //Definir as suas configurações:
        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.BOTH;
//        //Adicionar o ActionListener:
//        this.comboCargo.addActionListener(this.gerenciadorBotoes);
        //Adicionar o campo ao meu container:
        painel.add(this.comboCargo, constraints);

        //
        //Botoes:
        //
        
        this.botaoCarregar = new JButton("Carregar Funcionario");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoCarregar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoCarregar, constraints);

        this.botaoModificar = new JButton("Modificar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoModificar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoModificar, constraints);
        
//        //Botao para Listar:
//        this.botaoListarCargos = new JButton ("Listar Cargos");
//        //Definir o layout:
//        constraints.gridx = 0;
//        constraints.gridy = 12;
//        constraints.weightx = 0;
//        constraints.weighty = 0;
//        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
//        constraints.fill = GridBagConstraints.BOTH;
//        //Adicioanr o action listener:
//        this.botaoListarCargos.addActionListener(this.gerenciadorBotoes);
//        //Adicionar o botao:
//        painel.add(this.botaoListarCargos, constraints);

        //Botao para voltar:
        this.botaoVoltar = new JButton("Voltar");
        //Definir o layout:
        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2; //Determina quantas celulas da grid ela ocupa na horizontal
        constraints.fill = GridBagConstraints.BOTH;
        //Adicioanr o action listener:
        this.botaoVoltar.addActionListener(this.gerenciadorBotoes);
        //Adicionar o botao:
        painel.add(this.botaoVoltar, constraints);

    }
    
    public void carregarComboBox () {
        
        ArrayList<Cargo> lista = new ArrayList();
        
        Vector<Cargo> vetor = new Vector();
        
        for (Cargo cargo : ControladorGeral.getInstance().getControladorCargo().getMapeadorCargo().getCargos()) {
            vetor.add(cargo);
        }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(vetor);
        
        this.comboCargo.setModel(model);
    }

    /**
     * Deixa a tela visivel.
     */
    public void iniciarTela() {
        this.setVisible(true);
        this.carregarComboBox();
    }

    /**
     * Deixa a tela invisivel.
     */
    public void desligarTela() {
        this.setVisible(false);
    }

    /**
     * A partir dos campos inseridos, eh criado um envelope com os dados. Tem
     * integracao com o ControladorCargo.
     *
     * @return EnvelopeFuncionario - com os dados nescessarios para criar um.
     */
    public EnvelopeFuncionario criarEnvelope() {
        int numeroDeMatricula = Integer.parseInt(this.campoMatricula.getText());
        String nome = this.campoNome.getText();
        String telefone = this.campoTelefone.getText();
        int salario = Integer.parseInt(this.campoSalario.getText());
        //Encontrar o cargo:
//        int codigoCargo = Integer.parseInt(this.campoCargo.getText());
//        ICargo cargo = ControladorGeral.getInstance().getControladorCargo().findCargoByCodigo(String.valueOf(codigoCargo));
        ICargo cargo = (ICargo) this.comboCargo.getSelectedItem();
        //Para o dia de nascimento:
        int ano = Integer.parseInt(this.campoAno.getText());
        int mes = Integer.parseInt(this.campoMes.getText());
        int dia = Integer.parseInt(this.campoDia.getText());

        return new EnvelopeFuncionario(numeroDeMatricula, nome,
                telefone, salario, cargo, ano, mes, dia);
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
            //Quando o botao carregar for pressionado:
            if (evento.getSource().equals(botaoCarregar)) {
                try {
                    
                    //Pegar a matricula do campo de texto:
                    int matricula = Integer.parseInt(campoMatricula.getText()); //Parse joga uma execao, por isso o Try/Catch
                    //Carregar o funcionario:
                    Funcionario funcionarioModificar = ControladorGeral.getInstance().getControladorFuncionario().findFuncionarioByMatricula(matricula);
                    //Caso o funcionario foi encontrado, carregar os seus dados nos campos de texto:
                    if (funcionarioModificar != null) {

                        campoNovaMatricula.setText(String.valueOf(funcionarioModificar.getNumeroDeMatricula()));
                        campoNome.setText(funcionarioModificar.getNome());
                        campoDia.setText(String.valueOf(funcionarioModificar.getDataDeNascimento().get(Calendar.DATE)));
                        campoMes.setText(String.valueOf(funcionarioModificar.getDataDeNascimento().get(Calendar.MONTH)+1));
                        campoAno.setText(String.valueOf(funcionarioModificar.getDataDeNascimento().get(Calendar.YEAR)));
                        campoTelefone.setText(funcionarioModificar.getTelefone());
                        campoSalario.setText(String.valueOf(funcionarioModificar.getSalario()));
//                        campoCargo.setText(funcionarioModificar.getCargo().getNome());
                        comboCargo.setSelectedItem(funcionarioModificar.getCargo());

                    } else { //Se ele nao encontrar, avisar o usuario:

                        JOptionPane.showMessageDialog(null, "O Usuario não Existe");

                    }

                } catch (NumberFormatException execao) { //Se nao poder converter para int:

                    if (execao.getMessage().equals("For input string: \"\"")) {

                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");

                    } else {

                        JOptionPane.showMessageDialog(null, "Insira Apenas Numeros no Campo da Matricula");

                    }

                }

            } else if (evento.getSource().equals(botaoModificar)) {

                try {
                    //Pegar a matricula do campo de texto:
                    int matricula = Integer.parseInt(campoMatricula.getText()); //Parse joga uma execao, por isso o Try/Catch
                    //Carregar o funcionario:
                    Funcionario funcionarioModificar = ControladorGeral.getInstance().getControladorFuncionario().findFuncionarioByMatricula(matricula);
                    //Caso o funcionario nao
                    if (funcionarioModificar != null) {
                        //Chama o metodo de adicionar funcionario (joga execoes):
                        ControladorGeral.getInstance().getControladorFuncionario().modificarFuncionario(funcionarioModificar, criarEnvelope());
                        //Joga um JOptionPane para mostrar o sucesso:
                        JOptionPane.showMessageDialog(null, "Funcionario Modificado com Sucesso!");
                        //Trocar para a tela anterior:
                        desligarTela();
                        ControladorGeral.getInstance().getControladorFuncionario().getTela().iniciarTela();
                        //Tirar os inputs anteriores do buffer:
                        campoMatricula.setText("");
                        campoNovaMatricula.setText("");
                        campoNome.setText("");
                        campoDia.setText("");
                        campoMes.setText("");
                        campoAno.setText("");
                        campoTelefone.setText("");
                        campoSalario.setText("");
//                        campoCargo.setText("");
                        comboCargo.setSelectedIndex(0);

                    } else { //Se ele nao encontrar, avisar o usuario:

                        JOptionPane.showMessageDialog(null, "O Usuario não Existe");

                    }

                } catch (NumberFormatException execao) { //Se nao poder converter para int:

                    if (execao.getMessage().equals("For input string: \"\"")) {

                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");

                    } else {

                        JOptionPane.showMessageDialog(null, "Insira Apenas Numeros no Campo da Matricula");

                    }

                } catch (IllegalArgumentException execao) { //Vai criar um JOptionPane avisando qual foi o erro de Input:

                    if (execao.getMessage().equals("For input string: \"\"")) {

                        JOptionPane.showMessageDialog(null, "Campo em Branco é inválido.");

                    } else {

                        JOptionPane.showMessageDialog(null, execao.getMessage());

                    }
                }

//            }else if (evento.getSource().equals(botaoListarCargos)) {
//                
//                ControladorGeral.getInstance().getControladorCargo().getTelaListarCargo().iniciarTela();
//                
            } else if (evento.getSource().equals(botaoVoltar)) {

                desligarTela();
                ControladorGeral.getInstance().getControladorFuncionario().getTela().iniciarTela();
                //Tirar os inputs anteriores do buffer:
                campoMatricula.setText("");
                campoNovaMatricula.setText("");
                campoNome.setText("");
                campoDia.setText("");
                campoMes.setText("");
                campoAno.setText("");
                campoTelefone.setText("");
                campoSalario.setText("");
//                campoCargo.setText("");
                comboCargo.setSelectedIndex(0);

            }
        }

    }

}
