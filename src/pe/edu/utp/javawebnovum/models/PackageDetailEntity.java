package pe.edu.utp.javawebnovum.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDetailEntity extends BaseEntity {

    private static String DEFAULT_SQL = "SELECT * FROM packagedetails";
    private List<PackageDetail> findByCriteria(String sql, PackagesEntity packagesEntity, ThematicsEntity thematicsEntity, UsersEntity usersEntity) {
        List<PackageDetail> packageDetails = new ArrayList<>();
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while(resultSet.next()) {
                    PackageDetail packageDetail = new PackageDetail(
                            packagesEntity
                                    .findById(resultSet
                                            .getInt("package_id")),
                            thematicsEntity
                                    .findById(resultSet
                                            .getInt("thematic_id")),
                            usersEntity
                                    .findById(resultSet
                                            .getInt("user_id")),
                            resultSet.getFloat("total_price"),
                            resultSet.getString("description")
                    );
                    packageDetails.add(packageDetail);
                }
                return packageDetails;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public List<PackageDetail> findAll(PackagesEntity packagesEntity, ThematicsEntity thematicsEntity, UsersEntity usersEntity) {
        return findByCriteria(DEFAULT_SQL, packagesEntity, thematicsEntity, usersEntity);
    }

}
