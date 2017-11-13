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
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaCadastrarCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaCargo;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaCargoComAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaCargoGerente;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaCargoSemAcesso;
import br.ufsc.ine5605.sistemacontroleacesso2.telas.TelaRemoverCargo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 *
 * @author PEaug
 */
public class ControladorCargo {

    private TelaCargo telaCargo;
    private ArrayList<Cargo> listaCargo;
    private ControladorGeral controladorGeral;
    private TelaCadastrarCargo TelaCadastrarCargo;
    private TelaRemoverCargo TelaRemoverCargo;
    private TelaCargoGerente TelaCargoGerente;
    private TelaCargoComAcesso TelaCargoComAcesso;
    private TelaCargoSemAcesso TelaCargoSemAcesso;
    /**
     *
     * @param controladorGeral
     */
    public ControladorCargo(ControladorGeral controladorGeral) {
        this.controladorGeral = controladorGeral;
        this.listaCargo = new ArrayList<Cargo>();
        this.telaCargo = new TelaCargo();
        this.TelaCadastrarCargo= new TelaCadastrarCargo();
        this.TelaRemoverCargo= new TelaRemoverCargo();
    }

    /**
     *
     */

    /**
     * Método que adiciona cargo Gerente ou CargoSemAcesso
     *
     * @param envelope Envelope com os atributos do Cargo a ser gerado
     */
    public void adicionarCargo(EnvelopeCargo envelope) {
        boolean existeCodigo = false;
        boolean existeNome = false;

        //Verifica se existe cargo com mesmo codigo ou nome
        for (Cargo cargoArray : this.listaCargo) {
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
                        listaCargo.add(cargo);
                    }
                } else {
                    CargoSemAcesso cargo = new CargoSemAcesso(envelope.codigo, envelope.nome);

                    if (cargo != null) {
                        this.listaCargo.add(cargo);
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

        for (Cargo cargoArray : this.listaCargo) {
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
                    listaCargo.add(cargo);
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
    public void removerCargo(ICargo cargo) {
        if (cargo != null) {
            if (this.listaCargo.contains(cargo)) {
                Collection<Funcionario> listaFuncionario = controladorGeral.getControladorFuncionario().getFuncionarios();
                for (Funcionario funcionario : listaFuncionario) {
                    if (funcionario.getCargo().getCodigo().equals(cargo.getCodigo())) {
                        throw new IllegalArgumentException("Cargo vinculado a um funcionário. Resolva todas as pendências.");
                    }
                }
                this.listaCargo.remove(cargo);
            } else {
                throw new IllegalArgumentException("Cargo não cadastrado.");
            }
        } else {
            throw new IllegalArgumentException("Código de cargo inválido.");
        }
    }

    /**
     * Método que modifica cargo utilizando como parâmetro o cargo a ser
     * alterado e o código e nome
     *
     * @param cargo
     * @param codigo
     * @param nome
     */
    public void modificarCargo(ICargo cargo, String codigo, String nome) {
        if (cargo != null) {
            if (listaCargo.contains(cargo)) {
                cargo.setCodigo(codigo);
                cargo.setNome(nome);

//    			ArrayList<Funcionario> listaFuncionario= controladorGeral.getControladorFuncionario().getFuncionarios();
//    			for(Funcionario funcionario: listaFuncionario){
//    				if (funcionario.getCargo().equals(cargo)){
//    					funcionario.setCargo(cargo);
//    				}
//    			}
            } else {
                throw new IllegalArgumentException("Cargo não cadastrado.");
            }
        } else {
            throw new IllegalArgumentException("Código de cargo inválido.");
        }
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
    public void modificarCargo(CargoComAcesso cargo, String codigo, String nome, ArrayList<Calendar> arrayHorarios) {

        if (cargo != null) {
            if (listaCargo.contains(cargo)) {
                cargo.setCodigo(codigo);
                cargo.setNome(nome);
                cargo.setArrayComHorarios(arrayHorarios);
                Collection<Funcionario> listaFuncionario = controladorGeral.getControladorFuncionario().getFuncionarios();
                for (Funcionario func : listaFuncionario) {
                    if (func.getCargo().equals(cargo)) {

                    }
                }
            } else {
                throw new IllegalArgumentException("Cargo não cadastrado.");
            }
        } else {
            throw new IllegalArgumentException("Cargo inválido.");
        }
    }

    /**
     *
     * @return listaCargo.
     */
    public ArrayList<Cargo> getListaCargo() {
        return listaCargo;
    }

    /**
     *
     * @return telaCargo.
     */
    public TelaCargo getTela() {
        return telaCargo;
    }

    /**Método que encontra cargo por código
     *
     * @param codigo
     * @return
     */
    public ICargo findCargoByCodigo(String codigo) {
        for (Cargo cargo : this.listaCargo) {
            if (cargo.getCodigo().equals(codigo)) {
                return cargo;
            }
        }

        return null;
    }

    public TelaCadastrarCargo getTelaCadastrarCargo() {
        return TelaCadastrarCargo;
    }

    public TelaRemoverCargo getTelaRemoverCargo() {
        return TelaRemoverCargo;
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
}
