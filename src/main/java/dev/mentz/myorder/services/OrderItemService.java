package dev.mentz.myorder.services;

import dev.mentz.myorder.api.dtos.CreateOrderItemDto;
import dev.mentz.myorder.api.dtos.OrderItemResponseDto;
import dev.mentz.myorder.entities.Order;
import dev.mentz.myorder.entities.OrderItem;
import dev.mentz.myorder.entities.Product;
import dev.mentz.myorder.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    public List<OrderItem> createOrderItemList(List<CreateOrderItemDto> items, Order order) {
        return items.stream()
                .map(createOrderItemDto -> createOrderItem(createOrderItemDto, order))
                .collect(Collectors.toList());
    }

    public OrderItem createOrderItem(CreateOrderItemDto createOrderItemDto, Order order) {
        return new OrderItem()
                .setOrder(order)
                .setProduct(getProductFromOrderItem(createOrderItemDto))
                .setQuantity(createOrderItemDto.getQuantity());
    }

    public List<OrderItemResponseDto> createOrderItemResponseList(List<OrderItem> orderItemList) {
        return orderItemList.stream().map(this::getDtoFromEntity).collect(Collectors.toList());
    }

    private Product getProductFromOrderItem(CreateOrderItemDto createOrderItemDto) {
        return productService.getEntityById(createOrderItemDto.getProductId());
    }

    private OrderItemResponseDto getDtoFromEntity(OrderItem orderItem) {
        return new OrderItemResponseDto()
                .setId(orderItem.getId())
                .setQuantity(orderItem.getQuantity())
                .setProduct(productService.createProductResponseDtoFromEntity(orderItem.getProduct()));
    }
}
