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
import modelo.Disciplina;


/**
 *
 * @author HMilato Studio
 */
public class DisciplinaDAO {
    



   public boolean inserir(Disciplina disciplina)
    {
        String sql = "INSERT INTO disciplina(codigo,nome,curso,nivel,credito) VALUES(?,?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, disciplina.getCodigo());
            pst.setString(2, disciplina.getNome());
            pst.setInt(3, disciplina.getCurso());
            pst.setInt(4, disciplina.getNivel());
            pst.setInt(4, disciplina.getCredito());
            

            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Disciplina disciplina)
    {
        String sql = "UPDATE disciplina set codigo=?,nome=?,curso=?,nivel=?,credito=?  where codigo=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, disciplina.getCodigo());
            pst.setString(2, disciplina.getNome());
            pst.setInt(3, disciplina.getCurso());
            pst.setInt(4, disciplina.getNivel());
            pst.setInt(4, disciplina.getCredito());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Disciplina disciplina)
    {
        String sql = "DELETE FROM disciplina where codigo=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1, disciplina.getCodigo());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Disciplina> listar()
    {
         String sql = "SELECT * FROM disciplina";
        List<Disciplina> retorno = new ArrayList<Disciplina>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Disciplina item = new Disciplina();
                item.setCodigo(res.getString("codigo"));
                item.setNome(res.getString("nome"));
                item.setCredito(res.getInt("credito"));
                item.setCurso(res.getInt("curso"));
                item.setNivel(res.getInt("nivel"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public List<Disciplina> buscarL(Disciplina disciplina)
    {
        String sql = "SELECT * FROM disciplina where codigo=?";
         List<Disciplina> retorno = new ArrayList<Disciplina>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                 Disciplina item = new Disciplina();
                item.setCodigo(res.getString("codigo"));
                item.setNome(res.getString("nome"));
                item.setCredito(res.getInt("credito"));
                item.setCurso(res.getInt("curso"));
                item.setNivel(res.getInt("nivel"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    
    
    
    public Disciplina buscar(Disciplina disciplina)
    {
        String sql = "SELECT * FROM disciplina where codigo=?";
        Disciplina retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, disciplina.getCodigo());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {

                retorno = new Disciplina();
                
                retorno.setCodigo(res.getString("codigo"));
                retorno.setNome(res.getString("nome"));
                retorno.setCredito(res.getInt("credito"));
                retorno.setCurso(res.getInt("curso"));
                retorno.setNivel(res.getInt("nivel"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
    
    
