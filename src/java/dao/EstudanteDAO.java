/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Estudante;


/**
 *
 * @author HMilato Studio
 */
public class EstudanteDAO {
    
    public EstudanteDAO(){
    
}

   public boolean inserir(Estudante estudante)
    {
        String sql = "INSERT INTO estudante(nr_estudante,nome_completo, nivel_frequencia,email) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, estudante.getNr_estudante());
            pst.setString(2, estudante.getNome_completo());
            pst.setInt(3, estudante.getNivel_frequencia());
            pst.setString(4, estudante.getEmail());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Estudante estudante)
    {
        String sql = "UPDATE estudante set nome_completo=?,nivel_frequencia=?,email=? where nr_estudante=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, estudante.getNr_estudante());
            pst.setString(2, estudante.getNome_completo());
            pst.setInt(3, estudante.getNivel_frequencia());
            pst.setString(4, estudante.getEmail());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Estudante estudante)
    {
        String sql = "DELETE FROM estudante where nr_estudante=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1, estudante.getNr_estudante());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Estudante> listar()
    {
         String sql = "SELECT * FROM estudante";
        List<Estudante> retorno = new ArrayList<Estudante>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Estudante item = new Estudante();
                item.setNr_estudante(res.getString("nr_estudante"));
                item.setNome_completo(res.getString("nome_completo"));
                item.setEmail(res.getString("email"));
                item.setNivel_frequencia(res.getInt("nivel_frequencia"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public List<Estudante> buscarL(Estudante estudante)
    {
        String sql = "SELECT * FROM estudante where nr_estudante=?";
         List<Estudante> retorno = new ArrayList<Estudante>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Estudante item = new Estudante();
                item.setNr_estudante(res.getString("nr_estudante"));
                item.setNome_completo(res.getString("nome_completo"));
                item.setEmail(res.getString("email"));
                item.setNivel_frequencia(res.getInt("nivel_frequencia"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    
    
    
    public Estudante buscar(Estudante estudante)
    {
        String sql = "SELECT * FROM estudante where nr_estudante=?";
        Estudante retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, estudante.getNr_estudante());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Estudante();
                retorno.setNr_estudante(res.getString("nr_estudante"));
                retorno.setNome_completo(res.getString("nome_completo"));
                retorno.setEmail(res.getString("email"));
                retorno.setNivel_frequencia(res.getInt("nivel_frequencia"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
    
    
