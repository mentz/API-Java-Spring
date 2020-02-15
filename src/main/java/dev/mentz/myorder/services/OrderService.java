package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateOrderDto;
import dev.mentz.myorder.api.dtos.OrderItemResponseDto;
import dev.mentz.myorder.api.dtos.OrderResponseDto;
import dev.mentz.myorder.entities.Order;
import dev.mentz.myorder.entities.OrderItem;
import dev.mentz.myorder.entities.Restaurant;
import dev.mentz.myorder.entities.User;
import dev.mentz.myorder.enums.OrderStatusEnum;
import dev.mentz.myorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemService;

    public OrderResponseDto create(CreateOrderDto createOrderDto) {
        Order order = createOrder(createOrderDto);

        return new OrderResponseDto()
                .setId(order.getId())
                .setStatus(order.getStatus().toString())
                .setItems(buildOrderItemResponseDtoList(order.getItems()))
                .setTotalValue(order.getTotalValue())
                .setUser(userService.getResponseDtoFromEntity(order.getUser()));
    }

    private List<OrderItemResponseDto> buildOrderItemResponseDtoList(List<OrderItem> orderItemList) {
        return orderItemList.stream().map(orderItem ->
            new OrderItemResponseDto()
                .setId(orderItem.getId())
                .setQuantity(orderItem.getQuantity())
                .setProduct(productService.createProductResponseDtoFromEntity(orderItem.getProduct()))
        ).collect(Collectors.toList());
    }

    private Order createOrder(CreateOrderDto createOrderDto) {
        User user = userService.getEntityById(createOrderDto.getUserId());
        Restaurant restaurant = restaurantService.getEntityById(createOrderDto.getRestaurantId());

        Order order = new Order();

        order.setItems(orderItemService.createOrderItemList(createOrderDto.getOrderItemList(), order))
                .setStatus(OrderStatusEnum.OPEN)
                .setUser(user)
                .setRestaurant(restaurant);

        order.setTotalValue(calculateTotalValue(order));

        return orderRepository.save(order);
    }

    private Double calculateTotalValue(Order order) {
//        Modo antigo, pré Java 8
//        double totalValue = 0.00; // Dois zeros para precisão. É dinheiro, afinal :)
//
//        for (OrderItem item : order.getItems()) {
//            totalValue += item.getQuantity() * item.getProduct().getValue();
//        }
//
//        return totalValue;
        return order.getItems().stream()
                .map(item -> item.getProduct().getValue() * item.getQuantity())
                .reduce(0.00d, Double::sum);
    }
}
