
package br.ufsc.ine5605.sistemacontroleacesso2.envelopes;

import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;

/**
 *
 * @author Joao Vitor Venancio
 */
public class EnvelopeFuncionario {
    //Atributos:
    public int numeroDeMatricula;
    public String nome;
    public String telefone;
    public int salario;
    public ICargo cargo;
    //Informações para a criacao do atributo Calendar
    public int ano;
    public int mes;
    public int dia;
    

    //Construtor:
    /**
     * Construtor da classe. Recebe os parametros que vao ser repassados para o
     * controlador poder construir o funcionario.
     * 
     * @param numeroDeMatricula - do Funcionario para ser construido.
     * @param nome - do Funcionario para ser construido.
     * @param telefone - do Funcionario para ser construido.
     * @param salario - do Funcionario para ser construido.
     * @param cargo - do Funcionario para ser construido.
     * @param ano - em que o Funcionario nasceu.
     * @param mes - em que o Funcionario nasceu.
     * @param dia  - em que o Funcionario nasceu.
     */
    public EnvelopeFuncionario(int numeroDeMatricula, String nome, String telefone, int salario, ICargo cargo, int ano, int mes, int dia) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }
}
