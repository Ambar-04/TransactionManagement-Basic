package ambar.transaction.SpringBoot.service.impl;

import ambar.transaction.SpringBoot.dto.OrderRequest;
import ambar.transaction.SpringBoot.dto.OrderResponse;
import ambar.transaction.SpringBoot.entity.Order;
import ambar.transaction.SpringBoot.entity.Payment;
import ambar.transaction.SpringBoot.exception.PaymentException;
import ambar.transaction.SpringBoot.repository.OrderRepository;
import ambar.transaction.SpringBoot.repository.PaymentRepository;
import ambar.transaction.SpringBoot.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        // Save the order details
        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        // Save the payment details
        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equalsIgnoreCase("DEBIT")){
            throw new PaymentException("Payment type not matching");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);


        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());

        return orderResponse;
    }
}
