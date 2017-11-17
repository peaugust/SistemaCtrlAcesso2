/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sistemacontroleacesso2.mapeadores;

import br.ufsc.ine5605.sistemacontroleacesso2.Registro;
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
public class MapeadorRegistro {
    private HashMap<Integer, Registro> cacheRegistros = new HashMap<>();
    private final String fileName = "registros.dat";
    
    public MapeadorRegistro() {
        load();
    }
    public void put(Registro registro){
        cacheRegistros.put(registro.getChave(), registro);
    }
   
    public Registro get(Integer chave) {
        return cacheRegistros.get(chave);
    }
    
    public int getProximaChave(){
        int somaProximaChave = this.getList().size();
        somaProximaChave++;
        return somaProximaChave;
    }
    
    public Collection<Registro> getList(){
        return cacheRegistros.values();
    }
    
    public void remove(Registro registro){
        cacheRegistros.remove(registro.getChave());
    } 
    
    private void persist(){
        try {
            FileOutputStream fOS = new FileOutputStream(fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            
            oOS.writeObject(cacheRegistros);
            
            oOS.flush();
            fOS.flush();
            
            oOS.close();
            fOS.close();
         
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapeadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapeadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void load(){
        try {
            FileInputStream fIS = new FileInputStream(fileName);
            ObjectInputStream oIS = new ObjectInputStream(fIS);
            
            cacheRegistros = (HashMap<Integer, Registro>) oIS.readObject();
            
            oIS.close();
            fIS.close();
            
        } catch (FileNotFoundException ex) {
            persist();
        } catch (IOException ex) {
            Logger.getLogger(MapeadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MapeadorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
