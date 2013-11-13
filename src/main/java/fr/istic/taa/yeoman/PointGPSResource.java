
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

@Path("/ptsgps")
public class PointGPSResource {

    private List<PointGPS> gps = new ArrayList<PointGPS>();
    	
    public PointGPSResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<PointGPS> list() {
        return gps;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public PointGPS findById(@PathParam("id") String arg0) {
        return gps.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public PointGPS deleteById(@PathParam("id") String arg0) {
        return gps.remove(Integer.parseInt(arg0));
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public PointGPS updateById(@PathParam("id") String arg0, PointGPS u) {
    	return gps.set(Integer.parseInt(arg0), u);
    }
    
    @PUT @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean add(PointGPS u) {
    	return gps.add(u);
    }
}
