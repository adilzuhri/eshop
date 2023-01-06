package vttp2022.paf.assessment.eshop.repositories;

import java.util.Optional;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.CustomerRowMapper;
import vttp2022.paf.assessment.eshop.repositories.Queries;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer findCustomerByName(String customerName) {
        List<Customer> custs = jdbcTemplate.query(SQL_SELECT_CUSTOMERS_BY_NAME, new CustomerRowMapper(),
                new Object[] { customerName });
        return (Customer) custs.get(0);
    }
    
    public List<Customer> getAllCustomer(Integer offset, Integer limit) {

        final List<Customer> custs = new LinkedList<>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS, offset, limit);

        while (rs.next()) {
            custs.add(Customer.create(rs));
        }
        return custs;
    }

    public List<Order> getCustomersOrder(Integer id) {
        // prevent inheritance
        final List<Order> orders = new LinkedList<>();

        // perform the query

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS_ORDER, id);

        while (rs.next()) {
            orders.add(Order.create(rs));
        }
        return orders;
   	}
}