package mx.edu.utez.personaljbp.model.personal;

import com.sun.source.tree.TryTree;
import mx.edu.utez.personaljbp.model.Repository;
import mx.edu.utez.personaljbp.model.position.BeanPosition;
import mx.edu.utez.personaljbp.utils.MySQLConnection;
import mx.edu.utez.personaljbp.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersonal implements Repository<BeanPersonal> {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanPersonal> findAll() {
        List<BeanPersonal> personal = new ArrayList<>();
        BeanPersonal person = null;
        BeanPosition position = null;

        try {
            conn = client.getConnection();
            String query = "SELECT pe.*, po.description FROM personal pe JOIN position po ON po.id = pe.position_id";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                person = new BeanPersonal();
                position = new BeanPosition();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthday(rs.getString("birthday"));
                person.setSalary(rs.getDouble("salary"));
                position.setDescription(rs.getString("description"));
                person.setPosition(position);
                personal.add(person);
            }

        }catch (SQLException e) {
            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());

        }finally {
            client.close(conn, pstm, rs);
        }
        return personal;
    }

    @Override
    public BeanPersonal findOne(Long id) {
        BeanPersonal person = null;
        BeanPosition position = null;
        try {
            conn = client.getConnection();
            String query = "SELECT pe.*, po.description FROM personal pe JOIN position po ON po.id = pe.position_id WHERE pe.id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                person = new BeanPersonal();
                position = new BeanPosition();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthday(rs.getString("birthday"));
                person.setSalary(rs.getDouble("salary"));
                position.setDescription(rs.getString("description"));
                person.setPosition(position);
            }

        }catch (SQLException e) {
            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, "Error -> save: " + e.getMessage());

        }finally {
            client.close(conn, pstm, rs);
        }
        return person;
    }

    @Override
    public Response<BeanPersonal> save(BeanPersonal person) {
        try {
            conn = client.getConnection();
            String query = "INSERT INTO personal (name, surname, lastname, birthday, salary, position_id) VALUES (?,?,?,?,?,?) ";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getSurname());
            pstm.setString(3, person.getLastname());
            pstm.setString(4, person.getBirthday());
            pstm.setDouble(5, person.getSalary());
            pstm.setLong(6, person.getPosition().getId());

            if (pstm.executeUpdate() == 1) {
                return  new Response<>(200, "Registrado correctamente", person, false);

            }else {
                return new Response<>(200, "Error al registrar", person, true);

            }

        }catch (SQLException e) {
            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, "Error -> save: " + e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);

        }finally {
            client.close(conn, pstm, rs);

        }
    }

    @Override
    public Response<BeanPersonal> update(BeanPersonal object) {
        return null;
    }

    @Override
    public Response<BeanPersonal> remove(Long id) {
        return null;
    }
}
