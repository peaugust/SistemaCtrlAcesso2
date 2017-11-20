
package br.ufsc.ine5605.sistemacontroleacesso2.execoes;

/**
 *
 * @author Joao Vitor Venancio
 */
public class AssociacaoCargoFuncionarioException extends IllegalArgumentException{
    
    public AssociacaoCargoFuncionarioException () {
        
        super ("Não foi associado um Cargo a um Funcionario");
        
    }
    
}
