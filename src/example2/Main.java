package example2;

public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 1200.0);
        Product mouse = new Product("Wireless Mouse", 25.0);
        Product keyboard = new Product("Mechanical Keyboard", 55.0);

        ProductBundle accessoriesBundle = new ProductBundle("Accessories");
        accessoriesBundle.add(mouse);
        accessoriesBundle.add(keyboard);

        ProductBundle officePackage = new ProductBundle("Office Package");
        officePackage.add(laptop);
        officePackage.add(accessoriesBundle);

        officePackage.display();



    }
}