
import com.udea.entity.Item;
import com.udea.entity.Products;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


@ManagedBean(name = "sp")
@SessionScoped
public class ShopingCart {
    private List<Item> cart = new ArrayList<>();
    private double  total;

    /**
     * @return the cart
     */
    public List<Item> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        
        total = 0;
        for(Item item: cart){
            total = total + (item.getQuantity()* item.getP().getPrice().doubleValue());
        }
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
    public String addCart(Products p){
        for(Item item:cart){
            if(item.getP().getId().equals(p.getId())){
                item.setQuantity(item.getQuantity() + 1);
                return "cart";
            }
        }
        // crear un nuevo item
        Item i = new Item();
        i.setQuantity(1);
        i.setP(p);
        cart.add(i);
        return "cart";  // se va de nuevo a la vista cart 
    }
    
    
    public void update(){} // El managed bean automaticamente lo entiende
    
    public void remove(Item i){
        for(Item item: cart){
            if(item.equals(i)){
                cart.remove(item);
                break;
            }
        }
    }
    
    
    public String payment(){
        return "payment";
    }
    
    
    
}
