package mx.edu.utez.personaljbp.controller.personal;

import mx.edu.utez.personaljbp.model.personal.BeanPersonal;
import mx.edu.utez.personaljbp.model.personal.DaoPersonal;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Path("/api/personal")
public class PersonalServices {
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanPersonal> getAll() {

        return new DaoPersonal().findAll();
    }

    @POST
    @Path("/")
    @Produces(value = {"application/json"})
    public Map<String, Object> save() {
        //Buscar informacion sobre como obtener el body->request
        //para convertir a un BeanPersonal

        //CODE
    }
}
