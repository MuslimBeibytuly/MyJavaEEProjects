package beans.Cart;

import java.util.List;
import javax.ejb.Local;
import entities.Product;

@Local
public interface Cart {
    void addProduct(String title);
    void removeProduct(String title);
    List<Product> getAllProducts();
}