package pe.edu.utp.javawebnovum.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThematicsEntity extends BaseEntity{

    private static String DEFAULT_SQL = "SELECT * FROM thematic";
    private List<Thematic> findByCriteria(String sql) {
        List<Thematic> thematics;
        if(getConnection() != null) {
            thematics = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Thematic thematic = new Thematic()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setName(resultSet.getString("photo"))
                            .setDescription(resultSet.getString("description"));
                    thematics.add(thematic);
                }
                return thematics;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Thematic> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Thematic findById(int id) {
        List<Thematic> thematics = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (thematics != null && !thematics.isEmpty()? thematics.get(0) : null);
    }

    public Thematic findByName(String name) {
        List<Thematic> thematics = findByCriteria(DEFAULT_SQL +
                " WHERE name = '" + name + "'");
        return (thematics != null && !thematics.isEmpty() ? thematics.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM thematic WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM thematic";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public Thematic create(String name, String photo, String description ) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO thematic(name, photo, description) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        name + photo + description +"')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Thematic thematiic = new Thematic(getMaxId(), name, photo, description);
                    return thematiic;
                }
            }
        }
        return null;
    }

    public boolean update(Thematic thematic) {
        if(findByName(thematic.getName()) != null) return false;
        return updateByCriteria(
                "UPDATE users SET name = '" +
                        thematic.getName() +"',photo ='" + thematic.getPhoto() + "',description ='" + thematic.getDescription() + "'" +
                        " WHERE id = " +
                        String.valueOf(thematic.getId())) > 0;
    }
}
