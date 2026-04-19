// Task 01
public class Product {
    public String name;
    public int quantity;
    public static Product[] products = new Product[3];
    public static int stored = 0;

    public Product (String name, int quantity){
        this.name = name;
        this.quantity = quantity;
        if (stored < 3) {
            products[stored++] = this;
            System.out.println("Stored: "+ name);
        } else {
            System.out.println("Storage is full! Cannot add " + name);
        }
    }

    public static void displayProducts (){
        System.out.println("=== Stored Products ===");
        for (int i = 0; i < stored; i++){
            System.out.println(products[i].name + " - Qty: " + products[i].quantity);
        }
    }

    public static void buy (String name, int amount){
        boolean found = false;
        for (int i = 0; i < stored; i++){
            if (name.equals(products[i].name)){
                if (products[i].quantity > amount) {
                    products[i].quantity -= amount;
                    System.out.println("Product Sold");
                } else {
                    System.out.println("Quantity low");
                }
                found = true;
            }
        }
        if (!found) System.out.println("Product not found");
    }
}
