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
import modelo.Inscricao;


/**
 *
 * @author HMilato Studio
 */
public class InscricaoDAO {
    
          public List<Inscricao> listar()
    {
         String sql = "SELECT public.inscricaodisciplina.id_inscricao, public.inscricaodisciplina.id_disciplina, public.inscricao.id_estudante \n" +
"   FROM public.inscricaodisciplina,public.inscricao \n" +
"   WHERE public.inscricaodisciplina.id_inscricao=public.inscricao.id_inscricao ";
        
         
         List<Inscricao> retorno = new ArrayList<Inscricao>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Inscricao item = new Inscricao();
                
                item.setId_disciplina(res.getInt("id_disciplina"));
                item.setId_estudante(res.getInt("id_estudante"));
                item.setId_inscricao(res.getInt("id_inscricao"));
               // item.setNome_completo(res.getString("estudante_completo"));
                
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InscricaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    
    
        
 
    
}
