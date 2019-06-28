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
import modelo.Curso;


/**
 *
 * @author HMilato Studio
 */
public class CursoDAO {
  
        public List<Curso> listar()
    {
         String sql = "SELECT * FROM curso";
        List<Curso> retorno = new ArrayList<Curso>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Curso item = new Curso();
                item.setCodigo_curso(res.getString("codigo_curso"));
                item.setDescricao(res.getString("descricao"));
             
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    
    
    
    
}
