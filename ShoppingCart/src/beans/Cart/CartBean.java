package beans.Cart;

import entities.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
@Stateless
@LocalBean
@Path("/cart")
public class CartBean implements Cart {
    @PersistenceContext(name="entityManager")
    EntityManager entityManager;
    @Override
    public void addProduct(String title) {
    }

    @Override
    public void removeProduct(String title) {

    }
    @GET
    @Produces("application/json")
    @Path("/")
    @Override
    public List<Product> getAllProducts() {
        List<Product> products =
                entityManager
                        .createQuery("SELECT * FROM products ORDER BY productId")
                        .getResultList();
        return products;
    }
}
