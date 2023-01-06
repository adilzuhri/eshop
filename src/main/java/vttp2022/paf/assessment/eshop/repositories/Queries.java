package vttp2022.paf.assessment.eshop.repositories;

public class Queries {
   
        public static final String SQL_SELECT_CUSTOMERS_BY_NAME = "select name, address, email from customers where name = ?";
    
        // public static final String SQL_SELECT_ALL_CUSTOMERS_ORDER = "select c.id as customer_id, company, c.last_name, c.first_name, c.email_address, c.job_title, c.business_phone, c.home_phone, c.mobile_phone, c.address, c.state_province, o.id as order_id, DATE_FORMAT(o.order_date, \"%d/%m/%Y\") as order_date, DATE_FORMAT(o.shipped_date, \"%d/%m/%Y\") as shipped_date, o.ship_name, o.shipping_fee from customers c, orders o where c.id = o.customer_id and o.customer_id = ?";
 
}
