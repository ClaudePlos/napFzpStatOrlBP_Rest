/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;
import javax.ejb.Stateless;
import com.google.gson.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import pl.models.NapvFirmyKonsorcjum;

/**
 *
 * @author k.skowronski
 */
@Stateless
@Path("napvfirmykonsorcjum")
public class NapvFirmyKonsorcjumFacadeREST extends AbstractFacade<NapvFirmyKonsorcjum> {

    @PersistenceContext(unitName = "oracle_nap")
    private EntityManager em;

    public NapvFirmyKonsorcjumFacadeREST() {
        super(NapvFirmyKonsorcjum.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(NapvFirmyKonsorcjum entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, NapvFirmyKonsorcjum entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public NapvFirmyKonsorcjum find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<NapvFirmyKonsorcjum> findAll() {
        System.out.println("OK-test-findAll");
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<NapvFirmyKonsorcjum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("test")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String test() {
        System.out.println("OK-test");
        return "OK-test";
    }
    
    @POST
    @Path("testpost")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response testpost(String request) throws JSONException {
        Gson gson = new Gson();
        JsonObject req = gson.fromJson (request, JsonElement.class).getAsJsonObject();
        System.out.println(req);
        
        String result = "OK-test-post";
        JSONArray jsonArray = new JSONArray(result);
        System.out.println("OK-test");
        return Response.ok().entity(gson.toJson(jsonArray)).build();
    }
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
