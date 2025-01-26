package example2;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements ProductComponent {

    private String name;
    private List<ProductComponent> components = new ArrayList<>();

    public ProductBundle(String name) {
        this.name = name;
    }

    public void add(ProductComponent element) {
        components.add(element);
    }

    public void remove(ProductComponent element) {
        components.remove(element);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (ProductComponent component : components) {
            totalPrice += component.getPrice(); // total price
        }
        return totalPrice;
    }

    @Override
    public void display(){

        for(ProductComponent component: components){
            component.display();
        }
        System.out.println("Bundle: " + name + " | Total Price: " + getPrice() + " EUR");
    }
}
