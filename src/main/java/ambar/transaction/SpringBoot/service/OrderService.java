package ambar.transaction.SpringBoot.service;

import ambar.transaction.SpringBoot.dto.OrderRequest;
import ambar.transaction.SpringBoot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
