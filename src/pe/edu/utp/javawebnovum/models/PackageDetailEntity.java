package pe.edu.utp.javawebnovum.models;

public class PackageDetailEntity extends BaseEntity {

    private static String DEFAULT_SQL = "SELECT * FROM package";
    private List<PackageDetail> findByCriteria(String sql) {
        List<PackageDetail> packagedetails;
        if(getConnection() != null) {
            packagedetails = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Package opackage = new Package()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getInt("package_id"))
                            .setDescription((resultSet.getString("description")));
                    packages.add(opackage);
                }
                return packages;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Package> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Package findById(int id) {
        List<Package> packages = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (packages != null && !packages.isEmpty()? packages.get(0) : null);
    }

    public Package findByName(String name) {
        List<Package> packages = findByCriteria(DEFAULT_SQL +
                " WHERE name = '" + name + "'");
        return (packages != null && !packages.isEmpty() ? packages.get(0) : null);
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
        return updateByCriteria("DELETE FROM package WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM package";
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

    public Package create( String name,  String description ) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO package(name,description) VALUES(" +
                        name + description +"')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Package opackage = new Package( name, description);
                    return opackage;
                }
            }
        }
        return null;
    }

    public boolean update(Package opackage) {
        if(findByName(opackage.getName()) != null) return false;
        return updateByCriteria(
                "UPDATE package SET name ='" + opackage.getName() + "'description ='" + opackage.getDescription()+ "'" +
                        " WHERE id = " +
                        String.valueOf(opackage.getId())) > 0;
    }

}
