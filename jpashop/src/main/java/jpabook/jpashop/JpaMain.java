package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

            // 양방향 연관관계가 아닐경우
//            Order order1 = new Order();
//            em.persist(order1);
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);


            // 상속 관계 매핑
            {
                Book book = new Book();
                book.setName("JPA");
                book.setAuthor("김영한");
                em.persist(book);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
