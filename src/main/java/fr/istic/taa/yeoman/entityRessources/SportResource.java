
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

import fr.istic.taa.yeoman.entity.Sport;

@Path("/sports")
public class SportResource {

    private List<Sport> sports = new ArrayList<Sport>();
    	
    public SportResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Sport> list() {
        return sports;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Sport findById(@PathParam("id") String arg0) {
        return sports.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Sport deleteById(@PathParam("id") String arg0) {
        return sports.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Sport updateById(@PathParam("id") String arg0, Sport u) {
    	return sports.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Sport u) {
    	return sports.add(u);
    }
}
