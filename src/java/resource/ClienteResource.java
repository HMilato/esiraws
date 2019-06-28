/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.EstudanteDAO;
import dao.InscricaoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Estudante;
import modelo.Inscricao;


/**
 * REST Web Service
 *
 * @author HMilato Studio
 */
@Path("esira")
public class ClienteResource {

    @Context
    private UriInfo context;

    public ClienteResource() {
    }

    
        @GET
        @Produces("application/json")
        public String getJson() {
        
        return "WebService do eSira para SIGE-PAUTA";
      
        }

	@GET
	@Produces("application/json")
        @Path("Estudante/listaArray")
	public List<Estudante> listarEstudanteAr()
        {
                EstudanteDAO  dao = new EstudanteDAO();
		return new ArrayList<>(dao.listar());
	}
        
        @GET
	@Produces("application/json")
        @Path("Disciplinas")
	public List<Disciplina> listarDisciplina()
        {
                DisciplinaDAO  dao = new DisciplinaDAO();
		return new ArrayList<>(dao.listar());
	}
        
        @GET
	@Produces("application/json")
        @Path("Cursos")
	public List<Curso> listarCurso()
        {
                CursoDAO  dao = new CursoDAO();
		return new ArrayList<>(dao.listar());
	}
        
        @GET
	@Produces("application/json")
        @Path("Inscricao")
	public List<Inscricao> listarIncriscao()
        {
                InscricaoDAO  dao = new InscricaoDAO();
		return new ArrayList<>(dao.listar());
	}
  
}
