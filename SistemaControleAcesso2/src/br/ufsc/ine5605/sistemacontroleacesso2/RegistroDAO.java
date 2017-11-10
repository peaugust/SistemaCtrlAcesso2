/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PEaug
 */
public class RegistroDAO {
    private HashMap<Integer, Registro> cacheRegistros = new HashMap<>();
    private final String fileName = "registros.dat";
    
    public RegistroDAO() {
        load();
    }
    public void put(Registro registro){
        cacheRegistros.put();
    }
   
    public Funcionario get(Integer codigo) {
        return cacheFuncionarios.get(codigo);
    }
    
    public Collection<Funcionario> getList(){
        return cacheFuncionarios.values();
    }
    
    public void remove(Funcionario funcionario){
        cacheFuncionarios.remove(funcionario.getCodigo());
    } 
    
    private void persist(){
        try {
            FileOutputStream fOS = new FileOutputStream(fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            
            oOS.writeObject(cacheFuncionarios);
            
            oOS.flush();
            fOS.flush();
            
            oOS.close();
            fOS.close();
         
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void load(){
        try {
            FileInputStream fIS = new FileInputStream(fileName);
            ObjectInputStream oIS = new ObjectInputStream(fIS);
            
            cacheFuncionarios = (HashMap<Integer, Funcionario>) oIS.readObject();
            
            oIS.close();
            fIS.close();
            
        } catch (FileNotFoundException ex) {
            persist();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
