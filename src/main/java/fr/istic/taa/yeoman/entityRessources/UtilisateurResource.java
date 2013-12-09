
package fr.istic.taa.yeoman.entityRessources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import fr.istic.taa.yeoman.dao.DaoUtilisateur;
import fr.istic.taa.yeoman.entity.Utilisateur;

@Path("/Utilisateur")
public class UtilisateurResource {
    	
    private ResponseBuilder res;

	public UtilisateurResource() {
    }

    @GET	
    @Produces({MediaType.APPLICATION_JSON })
    public Response list() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	
    	res = Response.ok(usrs.findAll());
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findById(@PathParam("id") String arg0) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	res = Response.ok(usrs.findByLogin(arg0));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }

    @DELETE @Path("delete")
    @Produces({MediaType.APPLICATION_JSON }) 
    public Response delete(Utilisateur u) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	System.out.println("delete");
    	res = Response.ok(usrs.delete(u));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, DELETE, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
    
    @DELETE @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON }) 
    public Response deleteById(@PathParam("id") String arg) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	System.out.println("delete");
    	res = Response.ok(usrs.deleteById(Integer.parseInt(arg)));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, DELETE, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
    
    @PUT @Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Utilisateur u) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	res = Response.ok(usrs.update(u));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
    
    @PUT @Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(Utilisateur u) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoUtilisateur usrs = new DaoUtilisateur(em);
    	System.out.println("passé par la ");
    	res = Response.ok(usrs.insert(u));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    } 
    
    @OPTIONS
    @Path("search/")
    public Response getOptionsSearch()
    {
	    return Response.ok()
	    .header("Access-Control-Allow-Origin", "*")
	    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @OPTIONS
    @Path("add")
    public Response getOptionsAdd()
    {
	    return Response.ok()
	    .header("Access-Control-Allow-Origin", "*")
	    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @OPTIONS
    @Path("delete/{id}")
    public Response getOptionsDelete()
    {
	    return Response.ok()
	    .header("Access-Control-Allow-Origin", "*")
	    .header("Access-Control-Allow-Methods", "POST, GET,DELETE, PUT, UPDATE, OPTIONS")
	    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
    @OPTIONS
    @Path("update")
    public Response getOptionsUpdate()
    {
	    return Response.ok()
	    .header("Access-Control-Allow-Origin", "*")
	    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
    
}
