package com.example.demo.Entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "products")
public class ProductEntity {
    
    @Id
    @Column( name = "id", nullable = false, updatable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;

    @Column( name = "product_name", nullable = false, updatable = true )
    private String product_name;

    @Column( name = "quantity", nullable = false, updatable = true )
    private int quantity;

    @Column( name = "description", nullable = false, updatable = true )
    private String description;

    @Column( name = "price", nullable = false, updatable = true )
    private double price;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "users_id" )
    private User userId;

    public ProductEntity(){}

    public ProductEntity(Long Id, String description, double price, String product_name, int quantity, User userId) {
        this.Id = Id;
        this.description = description;
        this.price = price;
        this.product_name = product_name;
        this.quantity = quantity;
        this.userId = userId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.Id);
        hash = 83 * hash + Objects.hashCode(this.product_name);
        hash = 83 * hash + this.quantity;
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductEntity other = (ProductEntity) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.product_name, other.product_name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return Objects.equals(this.userId, other.userId);
    }

    @Override
    public String toString() {
        return "ProductEntity [Id=" + Id + ", product_name=" + product_name + ", quantity=" + quantity
                + ", description=" + description + ", price=" + price + ", userId=" + userId + "]";
    }

    

}
