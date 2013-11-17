
package fr.istic.taa.yeoman.entityRessources;

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

import fr.istic.taa.yeoman.entity.Parcours;

@Path("/parcours")
public class ParcoursResource {

    private List<Parcours> parcours = new ArrayList<Parcours>();
    	
    public ParcoursResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Parcours> list() {
        return parcours;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Parcours findById(@PathParam("id") String arg0) {
        return parcours.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Parcours deleteById(@PathParam("id") String arg0) {
        return parcours.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Parcours updateById(@PathParam("id") String arg0, Parcours u) {
    	return parcours.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Parcours u) {
    	return parcours.add(u);
    }
}
