
package br.ufsc.ine5605.sistemacontroleacesso2.controladores;

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
     * Classe com o Controlador de Funcionarios.
     */
    private ControladorFuncionario controladorFuncionario;
//    private ControladorCargo controladorCargo;
//    private ControladorPortaFinanceiro controladorPortaFinanceiro;
//    private ControladorRegistros controladorRegistros;
//    private TelaControladorGeral telaControladorGeral;
    
    //Construtor:
    /**
     * Construtor da classe. Inicializa todos
     * os outrso construtores a partir dela. Nao recebe nenhum parametro.
     */
    public ControladorGeral() {
//        this.controladorCargo = new ControladorCargo(this);
        this.controladorFuncionario = new ControladorFuncionario(this);
//        this.controladorPortaFinanceiro = new ControladorPortaFinanceiro(this);
//        this.controladorRegistros = new ControladorRegistros(this);
//        this.telaControladorGeral = new TelaControladorGeral(this);
        this.controladorGeral = this;
    }
    
    //Metodos:
    /**
     * Inicia a interface grafica de usuario principal para se interagir com o sistema.
     */
    public void iniciarTela() {
//        this.telaControladorGeral.iniciar();
    }
    
    public ControladorFuncionario getControladorFuncionario() {
        return controladorFuncionario;
    }

//    public ControladorCargo getControladorCargo() {
//        return controladorCargo;
//    }
//
//    public ControladorPortaFinanceiro getControladorPortaFinanceiro() {
//        return controladorPortaFinanceiro;
//    }
//
//    public ControladorRegistros getControladorRegistros() {
//        return controladorRegistros;
//    }
    
    /**
     * Retorna a instancia ativa da classe. Caso ela nao existir, cria uma nova.
     * 
     * @return ControladorGeral - A propria classe.
     */
    public static ControladorGeral getInstance () {
        if (ControladorGeral.controladorGeral == null) {
            ControladorGeral.controladorGeral = new ControladorGeral();
        }
        return ControladorGeral.controladorGeral;
    }
    
}
