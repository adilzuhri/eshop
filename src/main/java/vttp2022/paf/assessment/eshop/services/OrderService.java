package vttp2022.paf.assessment.eshop.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.repositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.repositories.OrderRepository;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository custRepo;

    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(Order po) throws OrderException {

        String orderId = UUID.randomUUID().toString().substring(0, 8);
        System.out.printf(">>>> OrderId: %s\n", orderId);

        po.setOrderId(orderId);

        orderRepo.insertOrder(po);
        System.out.printf(">>>> order quantity: %s\n", po.getCustomer().toString());
        if (po.getLineItems().size() > 5)
            throw new OrderException("Cannot order more than 5 items");
        custRepo.addLineItems(po.getLineItems(), orderId);

    }

    public Order getOrderId(Integer orderId) {
        return null;
    }

    public Object updateOrder(Order order) {
        return null;
    }
}
