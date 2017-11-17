/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.controladores;

import br.ufsc.ine5605.sistemacontroleacesso2.Cargo;
import br.ufsc.ine5605.sistemacontroleacesso2.CargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.CargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.Funcionario;
import br.ufsc.ine5605.sistemacontroleacesso2.Gerente;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.envelopes.EnvelopeCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.interfaces.ICargo;
import br.ufsc.ine5605.sistemacontroleacesso2.mapeadores.MapeadorCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.mapeadores.MapeadorFuncionario;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaCadastrarCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaCargoGerente;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaRemoverCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaListarCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.cargo.TelaModificarCargo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author PEaug
 */
public class ControladorCargo {

    private TelaCargo telaCargo;    
    private MapeadorCargo mapeadorCargo;
    private ControladorGeral controladorGeral;
    private TelaCadastrarCargo TelaCadastrarCargo;
    private TelaRemoverCargo TelaRemoverCargo;
    private TelaListarCargo TelaListarCargo;
    private TelaModificarCargo TelaModificarCargo;
    private TelaCargoGerente TelaCargoGerente;
    private TelaCargoComAcesso TelaCargoComAcesso;
    private TelaCargoSemAcesso TelaCargoSemAcesso;
    /**
     *
     * @param controladorGeral
     */
    public ControladorCargo(ControladorGeral controladorGeral) {
        this.controladorGeral = controladorGeral;
        this.mapeadorCargo = new MapeadorCargo();
        this.telaCargo = new TelaCargo();
        this.TelaCadastrarCargo= new TelaCadastrarCargo();
        this.TelaRemoverCargo= new TelaRemoverCargo();
        this.TelaListarCargo= new TelaListarCargo();
        this.TelaModificarCargo= new TelaModificarCargo();
        this.TelaCargoGerente= new TelaCargoGerente();
        this.TelaCargoComAcesso= new TelaCargoComAcesso();
        this.TelaCargoSemAcesso= new TelaCargoSemAcesso();
    }


	/**
     * Método que adiciona cargo Gerente ou CargoSemAcesso
     *
     * @param envelope Envelope com os atributos do Cargo a ser gerado
     */
    public void adicionarCargo(EnvelopeCargo envelope) {
        boolean existeCodigo = false;
        boolean existeNome = false;

        //Verifica se existe cargo com mesmo codigo ou nome
        for (Cargo cargoArray : this.mapeadorCargo.getCargos()) {
            if (cargoArray.getCodigo().equals(envelope.codigo)) {
                existeCodigo = true;
            }
            if (cargoArray.getNome().equals(envelope.nome)) {
                existeNome = true;
            }
        }

        if (!existeCodigo) {
            if (!existeNome) {
                if (envelope.ehGerente) {
                    Gerente cargo = new Gerente(envelope.codigo, envelope.nome);

                    if (cargo != null) {
                    	this.mapeadorCargo.put(cargo);
                    }
                } else {
                    CargoSemAcesso cargo = new CargoSemAcesso(envelope.codigo, envelope.nome);

                    if (cargo != null) {
                    	this.mapeadorCargo.put(cargo);
                    }
                }
            } else {
                throw new IllegalArgumentException("Nome de cargo já cadastrado.");
            }
        } else {
            throw new IllegalArgumentException("Código de cargo já cadastrado.");
        }
    }

    /**
     * Método que adiciona um cargo com acesso(CargoComAcesso)
     *
     * @param envelope Envelope com os atributos do Cargo a ser gerado
     */
    public void adicionarCargo(EnvelopeCargoComAcesso envelope) {
        boolean existeCodigo = false;
        boolean existeNome = false;

        for (Cargo cargoArray : this.mapeadorCargo.getCargos()) {
            if (cargoArray.getCodigo().equals(envelope.codigo)) {
                existeCodigo = true;
            }
            if (cargoArray.getNome().equals(envelope.nome)) {
                existeNome = true;
            }
        }

        if (!existeCodigo) {
            if (!existeNome) {
                CargoComAcesso cargo = new CargoComAcesso(envelope.codigo, envelope.nome,
                        envelope.arrayComHorarios.get(0), envelope.arrayComHorarios.get(1),
                        envelope.arrayComHorarios.get(2), envelope.arrayComHorarios.get(3));

                if (cargo != null) {
                	this.mapeadorCargo.put(cargo);
                }
            } else {
                throw new IllegalArgumentException("Nome de cargo já cadastrado.");
            }
        } else {
            throw new IllegalArgumentException("Código de cargo já cadastrado");
        }
    }

    /**
     * Método que remove cargo utilizando como parâmetro um cargo
     *
     * @param cargo Cargo a ser removido
     */
    public boolean removerCargo(String codigo) {
    	
    	Collection<Funcionario> listaFuncionario = controladorGeral.getControladorFuncionario().getFuncionarios();
        for (Funcionario funcionario : listaFuncionario) {
            if (funcionario.getCargo().getCodigo().equals(codigo)) {
                throw new IllegalArgumentException("Cargo vinculado a um funcionário. Resolva todas as pendências.");
            }
        }
        return this.mapeadorCargo.removeByCodigo(codigo);
    }

    /**
     * Método que modifica cargo utilizando como parâmetro o cargo a ser
     * alterado e o código e nome
     *
     * @param cargo
     * @param codigo
     * @param nome
     */
    public void modificarCargo(String chaveCargo, String codigo, String nome) {
        if (mapeadorCargo.get(chaveCargo) != null) {
        	ICargo cargo= this.findCargoByCodigo(chaveCargo);
        	
            cargo.setCodigo(codigo);
            cargo.setNome(nome);

    			Collection<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
    			for(Funcionario funcionario: listaFuncionario){
    				if (funcionario.getCargo().equals(cargo)){
    					funcionario.setCargo(cargo);
    				}
    			}
            } else {
                throw new IllegalArgumentException("Cargo não cadastrado.");
            }
        
        	mapeadorCargo.persist();
    	}

	//*
    /**
     * Método que modifica cargo utilizando como parâmetro o cargo a ser
     * alterado e o codigo, nome e horários
     *
     * @param cargo
     * @param codigo
     * @param nome
     * @param arrayHorarios
     */
    public void modificarCargo(String chaveCargo, EnvelopeCargoComAcesso envelope) {
    	 if (mapeadorCargo.get(chaveCargo) != null) {
         		
    		 	CargoComAcesso cargo= (CargoComAcesso) this.findCargoByCodigo(chaveCargo);
                cargo.setCodigo(envelope.codigo);
                cargo.setNome(envelope.nome);
                cargo.setArrayComHorarios(envelope.arrayComHorarios);
                Collection<Funcionario> listaFuncionario = controladorGeral.getControladorFuncionario().getFuncionarios();
                for (Funcionario func : listaFuncionario) {
                    if (func.getCargo().equals(cargo)) {
    					func.setCargo(cargo);
                    }
                }
            } else {
                throw new IllegalArgumentException("Cargo não cadastrado.");
            }
    	 
    	 	mapeadorCargo.persist();

        }
    
    public Collection<Cargo> getCargos () {
        return this.mapeadorCargo.getCargos();
    }
    
    /**Método que encontra cargo por código
    *
    * @param codigo
    * @return
    */
   public ICargo findCargoByCodigo(String codigo) {
       return this.mapeadorCargo.get(codigo);
   }
   
    /**
     *
     * @return telaCargo.
     */
    public TelaCargo getTela() {
        return telaCargo;
    }

    public TelaCadastrarCargo getTelaCadastrarCargo() {
        return TelaCadastrarCargo;
    }

    public TelaRemoverCargo getTelaRemoverCargo() {
        return TelaRemoverCargo;
    }
    
    public TelaListarCargo getTelaListarCargo() {
 		return TelaListarCargo;
 	}

 	public TelaModificarCargo getTelaModificarCargo() {
 		return TelaModificarCargo;
 	}

    public TelaCargoGerente getTelaCargoGerente() {
        return TelaCargoGerente;
    }

    public TelaCargoComAcesso getTelaCargoComAcesso() {
        return TelaCargoComAcesso;
    }

    public TelaCargoSemAcesso getTelaCargoSemAcesso() {
        return TelaCargoSemAcesso;
    }
    
    public MapeadorCargo getMapeadorCargo() {
		return mapeadorCargo;
	}
}
