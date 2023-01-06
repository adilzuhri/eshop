package vttp2022.paf.assessment.eshop.repositories;

public class Queries {

  public static final String SQL_SELECT_CUSTOMERS_BY_NAME = "select name, address, email from customers where name = ?";

  public static final String SQL_ORDERS_BY_CUSTOMER = """
        SELECT
                o.c_name as customer_name,        
                o.id as order_id,
                
        FROM
                orders o
                LEFT JOIN status_pending
                ON d.id = od.delivery_id
                LEFT JOIN status dispatched
                ON d.id = od.delivery_id
                WHERE o.c_name = ?
                """;
            
            }
            

