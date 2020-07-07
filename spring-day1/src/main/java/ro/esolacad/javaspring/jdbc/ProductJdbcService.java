package ro.esolacad.javaspring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductJdbcService {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductJdbcService(final JdbcTemplate jdbcTemplate,
                              final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Integer getNumberOfProducts() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM product", Integer.class);
    }

    public ProductJdbc findProductById(final Long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, price FROM product where id = " + id,
                (rs, rowNum) -> mapResultSetToProduct(rs));
    }

    private ProductJdbc mapResultSetToProduct(final ResultSet rs) throws SQLException {
        ProductJdbc productJdbc = new ProductJdbc();
        productJdbc.setId(rs.getLong("id"));
        productJdbc.setName(rs.getString("name"));
        productJdbc.setPrice(rs.getBigDecimal("price"));
        return productJdbc;
    }

    public List<ProductJdbc> findAllProduct() {
        return jdbcTemplate.query( "SELECT id, name, price FROM product",
                (rs, rowNum) -> mapResultSetToProduct(rs));
    }

    public void saveProduct(final ProductJdbc productJdbc) {
        jdbcTemplate.update("INSERT INTO product VALUES (?, ?, ?)",
                productJdbc.getId(), productJdbc.getName(), productJdbc.getPrice());
    }

    public void saveProductWithNamed(final ProductJdbc productJdbc) {
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
//                .addValue("id", productJdbc.getId())
//                .addValue("name", productJdbc.getName())
//                .addValue("price", productJdbc.getPrice());

        namedParameterJdbcTemplate.update("INSERT INTO product VALUES (:id, :name, :price)",
                new BeanPropertySqlParameterSource(productJdbc));
    }
}
