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
                    PackageDetail packagedetail = new PackageDetail()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getInt("package_id"))
                            .setName(resultSet.getInt("thematic_id"))
                            .setName(resultSet.getInt("user_id"))
                            .setName(resultSet.getFloat("total_price"))
                            .setDescription((resultSet.getString("description")));
                    packagedetails.add(packagedetail);
                }
                return packagedetails;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<PackageDetail> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public PackageDetail findById(int id) {
        List<PackageDetail> packagedetails = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (packagedetails != null && !packagedetails.isEmpty()? packagedetails.get(0) : null);
    }

    public PackageDetail findByPackageID(int package_id) {
        List<PackageDetail> packagedetails = findByCriteria(DEFAULT_SQL +
                " WHERE package_id = "+ String.valueOf(package_id));
        return (packagedetails != null && !packagedetails.isEmpty() ? packagedetails.get(0) : null);
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
        return updateByCriteria("DELETE FROM PackageDetail WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM PackageDetail";
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

    public PackageDetail create( int package_id, int thematic_id, int user_id, float total_price, String description ) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO PackageDetail(package_id, thematic_id, user_id, total_price, description) VALUES(" +
                        package_id + thematic_id + user_id + total_price + description +"')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    //PackageDetail packagedetail = new PackageDetail( package_id, thematic_id, user_id, total_price, description);
                    //return packagedetail;
                }
            }
        }
        return null;
    }

    public boolean update(PackageDetail packagedetails) {
        if(findByPackageID(packagedetails.getPackage_id()) != null) return false;
        return updateByCriteria(
                "UPDATE PackageDetail SET name ='" + packagedetails.getPackage_id() + "'description ='" + packagedetails.getDescription()+ "'" +
                        " WHERE id = " +
                        String.valueOf(packagedetails.getId())) > 0;
    }

}
