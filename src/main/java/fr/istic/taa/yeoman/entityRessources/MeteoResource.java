
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

import fr.istic.taa.yeoman.entity.Meteo;

@Path("/meteos")
public class MeteoResource {

    private List<Meteo> meteos = new ArrayList<Meteo>();
    	
    public MeteoResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Meteo> list() {
        return meteos;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Meteo findById(@PathParam("id") String arg0) {
        return meteos.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Meteo deleteById(@PathParam("id") String arg0) {
        return meteos.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Meteo updateById(@PathParam("id") String arg0, Meteo u) {
    	return meteos.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Meteo u) {
    	return meteos.add(u);
    }
}
