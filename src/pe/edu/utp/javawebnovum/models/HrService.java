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
    private ThematicsEntity thematicsEntity;
    private PackagesEntity packagesEntity;
    private PackageDetailEntity packageDetailEntity;

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

    protected ThematicsEntity getThematicsEntity() {
        if(getConnection() != null) {
            if(thematicsEntity == null) {
                thematicsEntity = new ThematicsEntity();
                thematicsEntity.setConnection(getConnection());
            }
        }
        return thematicsEntity;
    }

    protected PackagesEntity getPackagesEntity() {
        if(getConnection() != null) {
            if(packagesEntity == null) {
                packagesEntity = new PackagesEntity();
                packagesEntity.setConnection(getConnection());
            }
        }
        return packagesEntity;
    }

    protected PackageDetailEntity getPackageDetailsEntity() {
        if(getConnection() != null) {
            if(packageDetailEntity == null) {
                packageDetailEntity = new PackageDetailEntity();
                packageDetailEntity.setConnection(getConnection());
            }
        }
        return packageDetailEntity;
    }

    public List<User> findAllUsers() {
        return getUsersEntity() != null ?
                getUsersEntity().findAll() : null;
    }

    public List<Thematic> findAllThematics() {
        return getThematicsEntity() != null ?
                getThematicsEntity().findAll() : null;
    }

    public List<Package> findAllPackages() {
        return getPackagesEntity() != null ?
                getPackagesEntity().findAll() : null;
    }

    public List<PackageDetail> findAllPackageDetails() {
        return getPackageDetailsEntity() != null ?
                getPackageDetailsEntity().findAll(packagesEntity, thematicsEntity, usersEntity) : null;
    }

    public User findUserById(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

    public Thematic findThematicById(int id) {
        return getThematicsEntity() != null ?
                getThematicsEntity().findById(id) : null;
    }

    public User findUserByName(String name) {
        return getUsersEntity() != null ?
                getUsersEntity().findByName(name) : null;
    }

    public Thematic findThematicByName(String name) {
        return getThematicsEntity() != null ?
                getThematicsEntity().findByName(name) : null;
    }

    public User createUser(String password, String name, String last_name, String address, String dni, String rol, String email ) {
        return getUsersEntity() != null ?
                getUsersEntity().create(password,name,last_name,address,dni,rol,email) : null;
    }

    public Thematic createThematic(String name, String photo, String description ) {
        return getThematicsEntity() != null ?
                getThematicsEntity().create(name,photo,description) : null;
    }

    /*public PackageDetail createPackageDetail(Package aPackage, Thematic thematic, User user, float total_price, String description) {
        return getPackageDetailsEntity() != null ?
                getPackageDetailsEntity().create(aPackage.getId(), thematic.getId(), user.getId(), total_price, description) : null;
    }
*/
    public boolean deleteUser(int id) {
        return getUsersEntity() != null ?
                getUsersEntity().delete(id) : false;
    }

    public boolean deleteThematic(int id) {
        return getThematicsEntity() != null ?
                getThematicsEntity().delete(id) : false;
    }

    public boolean updateUser(Package user) {
        return getUsersEntity() != null ?
                getUsersEntity().update(user) : false;
    }

    public boolean updateThematic(Thematic thematic) {
        return getThematicsEntity() != null ?
                getThematicsEntity().update(thematic) : false;
    }

    /*public boolean updatePackageDetail(PackageDetail packageDetail) {
        return getPackageDetailsEntity() != null ?
                getPackageDetailsEntity().update(packageDetail) : false;
    }*/
}
