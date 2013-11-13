
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

@Path("/sceance")
public class SeanceResource {

    private List<Parcour> seances = new ArrayList<Parcour>();
    	
    public SeanceResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Parcour> list() {
        return seances;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Parcour findById(@PathParam("id") String arg0) {
        return seances.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Parcour deleteById(@PathParam("id") String arg0) {
        return seances.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Parcour updateById(@PathParam("id") String arg0, Parcour u) {
    	return seances.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Parcour u) {
    	return seances.add(u);
    }
}
