package example2;

public class Product implements ProductComponent{

    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public void display(){
        System.out.println("Product: " + name + " | Price: " + price + " EUR");
    }
}
