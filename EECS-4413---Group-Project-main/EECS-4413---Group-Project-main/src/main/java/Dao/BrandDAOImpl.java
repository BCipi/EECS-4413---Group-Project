package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Brand;

public class BrandDAOImpl implements BrandDAO {
    private Connection connection;

    public BrandDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Brand> getAllBrands() {
        List<Brand> brands = new ArrayList<>();
        String sql = "SELECT * FROM Brand";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setId(rs.getInt("brand_id"));
                brand.setName(rs.getString("name"));
                brands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }
}
