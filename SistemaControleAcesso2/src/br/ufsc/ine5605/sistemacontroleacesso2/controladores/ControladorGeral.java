package br.ufsc.ine5605.sistemacontroleacesso2.controladores;

import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaControladorGeral;

/**
 *
 * @author Joao Vitor Venancio
 */
public class ControladorGeral {

    //Atributos:
    /**
     * A instancia do controlador.
     */
    private static ControladorGeral controladorGeral;

    /**
     * GUI do ConroladorGeral.
     */
    private TelaControladorGeral telaControladorGreal;

    /**
     * Classe com o Controlador de Funcionarios.
     */
    private ControladorFuncionario controladorFuncionario;
    
    /**
     * Classe com o Controlador de Cargos.
     */
    private ControladorCargo controladorCargo;
    
    /**
     * Atributo com o Controlador da Porta Financeiro do Sistema.
     */
    private ControladorPortaFinanceiro controladorPortaFinanceiro;
    
    /**
     * Atributo com o Controlaor de Registros do Sistema.
     */
    private ControladorRegistros controladorRegistros;

    //Construtor:
    /**
     * Construtor da classe. Inicializa todos os outrso construtores a partir
     * dela. Nao recebe nenhum parametro.
     */
    public ControladorGeral() {
        this.telaControladorGreal = new TelaControladorGeral();
        this.controladorCargo = new ControladorCargo(this);
        this.controladorCargo.getMapeadorCargo().load();
        this.controladorFuncionario = new ControladorFuncionario(this);
        this.controladorFuncionario.getMapeador().load();
        this.controladorPortaFinanceiro = new ControladorPortaFinanceiro(this);
        this.controladorRegistros = new ControladorRegistros(this);
        this.controladorRegistros.getMapeadorRegistro().load();
        this.controladorGeral = this;
    }

    //Metodos:
    /**
     * Retorna o Controlador de Funcionarios.
     * 
     * @return ControladorFuncionario.
     */
    public ControladorFuncionario getControladorFuncionario() {
        return this.controladorFuncionario;
    }

    /**
     * Retorna o Controlador de Cargos.
     * 
     * @return ControladorCargo.
     */
    public ControladorCargo getControladorCargo() {
        return this.controladorCargo;
    }

    /**
     * Retorna o Controlador da Porta do Financeiro.
     * 
     * @return ControladorPortaFinanceiro.
     */
    public ControladorPortaFinanceiro getControladorPortaFinanceiro() {
        return controladorPortaFinanceiro;
    }

    /**
     * Retorna o Controlador de Registros.
     * 
     * @return ControladorRegistros.
     */
    public ControladorRegistros getControladorRegistros() {
        return controladorRegistros;
    }

    /**
     * Retorna a Tela (GUI) do ControladorGeral.
     * 
     * @return TelaControladorGeral.
     */
    public TelaControladorGeral getTela() {
        return this.telaControladorGreal;
    }

    /**
     * Retorna a instancia ativa da classe. Caso ela nao existir, cria uma nova.
     *
     * @return ControladorGeral - A propria classe.
     */
    public static ControladorGeral getInstance() {
        if (ControladorGeral.controladorGeral == null) {
            ControladorGeral.controladorGeral = new ControladorGeral();
        }
        return ControladorGeral.controladorGeral;
    }


}
