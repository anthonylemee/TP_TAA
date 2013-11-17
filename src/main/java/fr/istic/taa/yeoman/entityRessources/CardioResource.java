
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

import fr.istic.taa.yeoman.entity.Cardio;

@Path("/cardios")
public class CardioResource {

    private List<Cardio> cardios = new ArrayList<Cardio>();
    	
    public CardioResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Cardio> list() {
        return cardios;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Cardio findById(@PathParam("id") String arg0) {
        return cardios.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Cardio deleteById(@PathParam("id") String arg0) {
        return cardios.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cardio updateById(@PathParam("id") String arg0, Cardio u) {
    	return cardios.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(Cardio u) {
    	return cardios.add(u);
    } 
}
