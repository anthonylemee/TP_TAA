
package fr.istic.taa.yeoman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UtilisateurResource {

    private List<Utilisateur> users = new ArrayList<Utilisateur>();
    	
    public UtilisateurResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Utilisateur> list() {
        return users;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur findById(@PathParam("id") String arg0) {
        return users.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur deleteById(@PathParam("id") String arg0) {
        return users.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Utilisateur updateById(@PathParam("id") String arg0, Utilisateur u) {
    	return users.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Utilisateur u) {
    	return users.add(u);
    } 
}
