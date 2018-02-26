package pe.edu.utp.javawebnovum.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM users";
    private List<User> findByCriteria(String sql) {
        List<User> users;
        if(getConnection() != null) {
            users = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User()
                            .setId(resultSet.getInt("id"))
                            .setPassword(resultSet.getString("password"))
                            .setName(resultSet.getString("name"))
                            .setLast_name(resultSet.getString("last_name"))
                            .setAddress(resultSet.getString("address"))
                            .setDni(resultSet.getString("dni"))
                            .setRol(resultSet.getString("rol"))
                            .setEmail(resultSet.getString("email"));
                    users.add(user);
                }
                return users;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<User> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public User findById(int id) {
        List<User> users = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (users != null && !users.isEmpty()? users.get(0) : null);
    }

    public User findByName(String name) {
        List<User> users = findByCriteria(DEFAULT_SQL +
                " WHERE name = '" + name + "'");
        return (users != null && !users.isEmpty() ? users.get(0) : null);
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
        return updateByCriteria("DELETE FROM users WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM users";
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

    public User create(String password, String name, String last_name, String address, String dni, String rol, String email ) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO users(id, password, name, last_name, address, dni, rol, email) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        password + name + last_name+ address+ dni+ rol+ email +"')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    User user = new User(getMaxId(), password, name, last_name, address, dni, rol, email);
                    return user;
                }
            }
        }
        return null;
    }

    public boolean update(User user) {
        if(findByName(user.getName()) != null) return false;
        return updateByCriteria(
                "UPDATE users SET password = '" +
                        user.getPassword() +"',name ='" + user.getName() + "',last_name ='" + user.getLast_name() + "',address ='" +
                        user.getAddress() + "'dni ='" + user.getDni() + "',rol ='" + user.getRol() + "',email ='" + user.getEmail()+ "'" +
                        " WHERE id = " +
                        String.valueOf(user.getId())) > 0;
    }
}
