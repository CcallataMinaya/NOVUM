package pe.edu.utp.javawebnovum.models;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import pe.edu.utp.javawebnovum.beans.ThematicsBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM orders";
    private List<Order> findByCriteria(String sql, UsersEntity usersEntity, ThematicsEntity thematicsEntity, PackagesEntity packagesEntity) {
        List<Order> orders = new ArrayList<>();
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while(resultSet.next()) {
                    Order order = new Order(
                            resultSet.getInt("id"),
                            usersEntity
                                    .findById(resultSet
                                            .getInt("user_id")),
                            thematicsEntity
                                    .findById(resultSet
                                            .getInt("thematic_id")),
                            packagesEntity
                                    .findById(resultSet
                                            .getInt("package_id")),
                            resultSet.getDate("date_order"),
                            resultSet.getDate("start_time"),
                            resultSet.getString("location"),
                            resultSet.getFloat("total_price")
                    );
                    orders.add(order);
                }
                return orders;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public List<Order> findAll(UsersEntity usersEntity, ThematicsEntity thematicsEntity, PackagesEntity packagesEntity) {
        return findByCriteria(DEFAULT_SQL, usersEntity, thematicsEntity, packagesEntity);
    }
}
