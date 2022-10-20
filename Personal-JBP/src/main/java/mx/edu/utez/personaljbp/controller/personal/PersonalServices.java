package mx.edu.utez.personaljbp.controller.personal;

import mx.edu.utez.personaljbp.model.personal.BeanPersonal;
import mx.edu.utez.personaljbp.model.personal.DaoPersonal;
import mx.edu.utez.personaljbp.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/personal")
public class PersonalServices {
    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanPersonal> getAll() {

        return new DaoPersonal().findAll();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanPersonal getById(@PathParam("id") Long id) {
        return new DaoPersonal().findOne(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> save(BeanPersonal personal) {
        System.out.println(personal.getName());
        //Dao result -> Response
        Response<BeanPersonal> result = new DaoPersonal().save(personal);
        response.put("result", result);
        return response;
    }
}
