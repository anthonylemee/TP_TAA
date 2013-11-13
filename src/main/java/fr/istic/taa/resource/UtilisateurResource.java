
package fr.istic.taa.resource;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.service.UtilisateurManager;
import fr.istic.taa.yeoman.Utilisateur;

@Path("/users")
public class UtilisateurResource {
    	
	UtilisateurManager manager;
		
    public UtilisateurResource() {
        manager = new UtilisateurManager();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Utilisateur> list() {
    	return manager.getUsers();
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur findById(@PathParam("id") String arg0) {
        return manager.getUserById(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur deleteById(@PathParam("id") String arg0) {
        return manager.removeById(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Utilisateur updateById(@PathParam("id") String arg0, Utilisateur u) {
    	return manager.set(u);
    }
    
    @PUT @Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Utilisateur add(Utilisateur u) {
    	manager.add(u);
    	return u;
    } 
}
