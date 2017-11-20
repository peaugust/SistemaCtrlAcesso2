package br.ufsc.ine5605.sistemacontroleacesso2.controladores;

import br.ufsc.ine5605.sistemacontroleacesso2.AcontecimentoRegistro;
import br.ufsc.ine5605.sistemacontroleacesso2.CargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.CargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso2.Registro;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeRegistro;
import br.ufsc.ine5605.sistemacontroleacesso2.execoes.MatriculaInexistente;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.portafinanceiro.TelaPortaFinanceiro;
import java.util.Calendar;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorPortaFinanceiro {

    //Atributos:
    /**
     * Atributo com o ControladorGeral do sistema.
     */
    private ControladorGeral controladorGeral;
    
    /**
     * Atributo com a GUI da PortaFinanceiro.
     */
    private TelaPortaFinanceiro telaPortaFinanceiro;

    //Construtor:
    /**
     * Construtor da Classe. Recebe um ControladorPortaFinanceiro como parâmetro.
     * 
     * @param controlador - Owner dessa classe.
     */
    public ControladorPortaFinanceiro(ControladorGeral controlador) {
        this.controladorGeral = controlador;
        this.telaPortaFinanceiro = new TelaPortaFinanceiro();
    }

    //Metodos:
    /**
     * Tenta abrir a porta. Caso o a matricula do funcionario não for valida,
     * ele joga uma excecao.
     *
     * @param numeroDeMatricula para o usuario tentado destrancar a porta.
     * @param horario da data atual.
     * @return String - Se abriu ou nao a porta.
     */
    public String abrirPorta(int numeroDeMatricula, Calendar horario) {
        //Verificar se o numero de matricula existe:
        boolean existe = false;
        Funcionario funcionarioPorta = null;
        for (Funcionario funcionarioLista : this.controladorGeral.getControladorFuncionario().getFuncionarios()) {
            if (funcionarioLista.getNumeroDeMatricula() == numeroDeMatricula) {
                existe = true;
                funcionarioPorta = funcionarioLista;
                break;
            }
        }
        //Se nao existir, joga uma excecao;
        if (!(existe)) {
            throw new MatriculaInexistente();
        }        
        //Ver se eh um funcionario que tem uma array de horarios:
        if (funcionarioPorta.getCargo() instanceof CargoComAcesso) {
            //Se eh, verificar o horario:
            CargoComAcesso cargo = (CargoComAcesso) funcionarioPorta.getCargo();
            if (cargo.verificarHorario(horario)) {
                //O horario deixa abrir a porta:
                return "Acesso Autorizado.";
            } else {
                //Caso contrario, criar um registro:
                EnvelopeRegistro envelope = new EnvelopeRegistro(AcontecimentoRegistro.FORADEHORARIO, horario, numeroDeMatricula, ControladorGeral.getInstance().getControladorRegistros().getMapeadorRegistro().getProximaChave());
                controladorGeral.getControladorRegistros().adicionarRegistro(envelope);
                return AcontecimentoRegistro.FORADEHORARIO.getDescricao();
            }
        } else if (funcionarioPorta.getCargo().temAcesso()) { //Verificar se eh um cargo de gerencia
            //Se ele for gerente, vai dar true:
            return "Acesso Autorizado.";
        } else {
            //Caso ele nao for:
            EnvelopeRegistro envelope = new EnvelopeRegistro(AcontecimentoRegistro.CARGOSEMACESSO, horario, numeroDeMatricula, ControladorGeral.getInstance().getControladorRegistros().getMapeadorRegistro().getProximaChave());
            controladorGeral.getControladorRegistros().adicionarRegistro(envelope);
            return AcontecimentoRegistro.CARGOSEMACESSO.getDescricao();
        }
    }
    
    /**
     * Metodo que retorna a GUI desse controlador.
     * 
     * @return TelaPortaFinanceiro.
     */
    public TelaPortaFinanceiro getTela() {
        return telaPortaFinanceiro;
    }
    
}
