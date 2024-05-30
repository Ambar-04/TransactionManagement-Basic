package ambar.transaction.SpringBoot.dto;

import ambar.transaction.SpringBoot.entity.Order;
import ambar.transaction.SpringBoot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}

// DTO
//  Data Transfer Object (DTO) that contains an Order and a Payment object.
//  The purpose of DTOs is to transfer data between different layers of an application,
//  often between the presentation layer and the service layer or between different microservices.
//  @Autowired annotation because the OrderRequest class is primarily a data holder and doesn't have any dependency injection needs.
//  if Lombok's annotations are handling the generation of getters and setters, there might be no need for the @Autowired annotation in this context