package com.nb.estudo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
@Entity
@Table(name="tb_payment")
public class Payment implements Serializable {
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @OneToOne
    @MapsId
    private Order order;
    public Payment(){}

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;
        return getId().equals(payment.getId()) && getMoment().equals(payment.getMoment()) && getOrder().equals(payment.getOrder());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMoment().hashCode();
        result = 31 * result + getOrder().hashCode();
        return result;
    }
}
