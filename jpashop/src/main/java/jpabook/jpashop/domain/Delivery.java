package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Delivery extends BaseEntity{
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    // 양방향
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;


}
