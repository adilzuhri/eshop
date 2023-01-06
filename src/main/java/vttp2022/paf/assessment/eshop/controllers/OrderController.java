package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.services.OrderService;

@RestController
@RequestMapping(path = "/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderService odSvc;

    @GetMapping(path = "{orderId}")
    public ResponseEntity<String> getOrderId(@PathVariable Integer orderId) {
        Order ord = odSvc.getOrderId(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ord.toJSON().toString());
    }

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putRSVP(@RequestBody String json) {
        Order order = null;
        boolean orderResult = false;
        JsonObject resp;
        try {
            order = ORDER.create(json);
        } catch (Exception e) {
            e.printStackTrace();
            resp = Json.createObjectBuilder()
                    .add("error", e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(resp.toString());
        }

        orderResult = (boolean) odSvc.updateOrder(order);
        resp = Json.createObjectBuilder()
                .add("updated", orderResult)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resp.toString());
    }

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(@RequestBody String json) {
        Order order = null;
        Order orderResult = null;
        JsonObject resp;
        try {
            order = ORDER.create(json);
        } catch (Exception e) {
            e.printStackTrace();
            resp = Json.createObjectBuilder()
                    .add("error", e.getMessage())
                    .build();
            return ResponseEntity.badRequest().body(resp.toString());
        }

        orderResult = odSvc.insertOrder(order);
        resp = Json.createObjectBuilder()
                .add("dispatchId", orderResult.getOrderId())
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resp.toString());
    }
}
