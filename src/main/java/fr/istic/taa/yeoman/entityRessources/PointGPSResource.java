
package fr.istic.taa.yeoman.entityRessources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import fr.istic.taa.yeoman.dao.DaoPointGPS;
import fr.istic.taa.yeoman.entity.PointGPS;

@Path("/ptsgps")
public class PointGPSResource {

    private List<PointGPS> gps = new ArrayList<PointGPS>();
    private ResponseBuilder res;	
    
    public PointGPSResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response list() {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoPointGPS gps = new DaoPointGPS(em);
    	
    	res = Response.ok(gps.findAll());
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
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
    public Response add(PointGPS u) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoPointGPS gps = new DaoPointGPS(em);
    	
    	res = Response.ok(gps.insert(u));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
}
