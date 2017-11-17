package entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private int id;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(name = "productId", nullable = false)
    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuserID() {
        return userId;
    }

    public void setuserID(int userID) {
        this.userId = userID;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productID) {
        this.productId = productID;
    }

}