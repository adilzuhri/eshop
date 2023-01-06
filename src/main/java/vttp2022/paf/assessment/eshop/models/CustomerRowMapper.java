package vttp2022.paf.assessment.eshop.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer c = new Customer();
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email_address"));
        c.setAddress(rs.getString("address"));
        return c;
    }
}
