package br.ufsc.ine5605.sistemacontroleacesso2.interfaces;

/**
 *
 * @author Joao Vitor Venancio
 */
public interface ICargo {

    public String getNome();

    public String getCodigo();
        
    public void setNome(String nome);

    public void setCodigo(String codigo);        
    
    public boolean temAcesso();
    
}
