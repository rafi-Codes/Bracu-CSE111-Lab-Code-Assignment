// Task 01
public class Toy {  
    public String name = "";
    public int price = 0;

    public Toy (String name, int price){
        this.name = name;
        this.price = price;
        System.out.println("A new toy has been made!");
    }

    public void showPrice(){
        System.out.println("price: " + price + " Taka");
    }

    public void updateName (String name){
        System.out.println("Changing old name: " + this.name);
        this.name = name;
        System.out.println("new name: " + name);
    }

    public void updatePrice (int price){
        this.price = price;
    } 
}

// Task 02
public class Cart {  
    public int number = 0;
    public int cartSize = 3;
    public double[] itemPrices = new  double [cartSize];
    public String[] itemNames = new  String [cartSize];
    public int itemCount = 0;
    public double discount = 0;

    public void create_cart(int number){
        this.number = number;
    }

    public void cartDetails(){
        double totalPrice = 0.0;
        System.out.println("Your cart(c"+ number +") : ");
        for (int i = 0; i < itemCount; i++){
            System.out.println(itemNames[i] + " - " + itemPrices[i]);
            totalPrice += itemPrices[i];
        }
        System.out.println("Discount Applied: "+ discount +"%");
        System.out.println("Total price: " + (totalPrice - (totalPrice * (discount / 100))));
    }

    public void addItem (String itemName, double itemPrice){
        if (itemCount < cartSize){
            System.out.println(itemName + " added to cart " + number + ".");
            itemPrices[itemCount] = itemPrice;
            itemNames[itemCount] = itemName;
            System.out.println("You have "+ ++itemCount +" item(s) in your cart now.");
        } else {
            System.out.println("You already have "+ cartSize +" items on your cart");
            itemCount = cartSize;
        }
    }

    public void addItem (double itemPrice, String itemName){
        addItem(itemName, itemPrice);
    }

    public void giveDiscount (double discount){
        this.discount = discount;
    }
}
