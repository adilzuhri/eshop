package vttp2022.paf.assessment.eshop.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.paf.Exception.OrderException;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.repositories.LineItemRepository;
import vttp2022.paf.assessment.eshop.repositories.OrderRepository;

@Service
public class WarehouseService {

	@Autowired
    private OrderRepository orRepo;

    @Autowired
    private LineItemRepository liRepo;

		// You cannot change the method's signature
		// You may add one or more checked exceptions
	@Transactional
	public OrderStatus dispatch(Order order) {
        orRepo.insertOrder(orRepo);
        System.out.printf(">>>> order quantity: %s\n", order.getLineItems().size());
        if (order=incomplete) or (order=failed(1/3)),
            throw new OrderException("Order details are incorrect");
   
        liRepo.addLineItems(order.getLineItems(), order);

    }
}
