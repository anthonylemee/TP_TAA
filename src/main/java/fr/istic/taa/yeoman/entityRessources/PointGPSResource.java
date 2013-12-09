
package fr.istic.taa.yeoman.entityRessources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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

    private ResponseBuilder res;	
    
    public PointGPSResource() {
        
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response list() {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
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
    public Response findById(@PathParam("id") String arg0) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoPointGPS gps = new DaoPointGPS(em);
    	
    	res = Response.ok(gps.find(Integer.parseInt(arg0)));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response deleteById(@PathParam("id") String arg0) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoPointGPS gps = new DaoPointGPS(em);
    	
    	//res = Response.ok(gps.delete());
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
    }
    
    @PUT @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateById(@PathParam("id") String arg0, PointGPS u) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	EntityManager em = emf.createEntityManager();
    	
    	DaoPointGPS gps = new DaoPointGPS(em);
    	
    	res = Response.ok(gps.update(u));
    	res.header("Access-Control-Allow-Origin", "*");
    	res.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
    	res.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    	
    	em.close();
        return res.build();
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
    @Path("delete")
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
