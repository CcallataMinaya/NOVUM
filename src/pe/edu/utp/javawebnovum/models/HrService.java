package pe.edu.utp.javawebnovum.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HrService {
    private Connection connection;
    private OrdersEntity ordersEntity;
    private UsersEntity usersEntity;

    private Connection getConnection() {
        if (connection == null){
            try {
                connection = ((DataSource) InitialContext
                        .doLookup("jdbc/MySQLDataSource"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected UsersEntity getUsersEntity() {
        if(getConnection() != null) {
            if(usersEntity == null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }

    public List<User> findAllUsers() {
        return getUsersEntity() != null ?
                getUsersEntity().findAll() : null;
    }

    public User findUserById(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

    public User findUserByName(String name) {
        return getUsersEntity() != null ?
                getUsersEntity().findByName(name) : null;
    }

    public User createUser(String password, String name, String last_name, String address, String dni, String rol, String email ) {
        return getUsersEntity() != null ?
                getUsersEntity().create(password,name,last_name,address,dni,rol,email) : null;
    }

    public boolean deleteUser(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().delete(id) : false;
    }

    public boolean updateUser(User user) {
        return getUsersEntity() != null ?
                getUsersEntity().update(user) : false;
    }

}
