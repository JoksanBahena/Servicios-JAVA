package mx.edu.utez.personaljbp.model.personal;

import mx.edu.utez.personaljbp.model.Repository;
import mx.edu.utez.personaljbp.model.position.BeanPosition;
import mx.edu.utez.personaljbp.utils.MySQLConnection;

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
            String query = "SELECT pe.*, po.description FROM personal pe" + "JOIN position po ON po.id = pe.position_id";
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
        return null;
    }

    @Override
    public boolean save(BeanPersonal object) {
        return false;
    }

    @Override
    public boolean update(BeanPersonal object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
