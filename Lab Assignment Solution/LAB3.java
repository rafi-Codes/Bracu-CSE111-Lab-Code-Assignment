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

// Task 03
public class Reader {  

    public String name;
    public int bookCapacity;
    public String[] books;
    public int booksAdded = 0;

    public Reader (String name, int bookCapacity){
        this.name = name;
        this.bookCapacity = bookCapacity;
        books = new String[bookCapacity];
        System.out.println("A new reader is created!");
    }
    
    public Reader (String name){
        this(name,2);
    }

    public void readerInfo() {
        System.out.println("Name: " + name);
        System.out.println("Capacity: " + bookCapacity);
        System.out.println("Books:");
        if (booksAdded <= 0){
            System.out.println("No books added yet");
        } 
        else {
            for (int i = 0; i < bookCapacity; i++){
                System.out.println("Book " + (i+1) +": " + books[i]);
            }
        }
    }

    public void addBook (String book){
        if (booksAdded < bookCapacity){
            books[booksAdded++] = book;
        } else {
            System.out.println("No more capacity");
            booksAdded = bookCapacity;
        }
    }

    public void updateCapacity (int newCapacity){
        String[] temp = new String[newCapacity];
        for (int i = 0; i < bookCapacity; i++){
            temp[i] = books[i];
        }
        books = temp;
        bookCapacity = newCapacity;
        System.out.println("Capacity has changed to " + bookCapacity);
    }
}

// Task 04
public class MoneyTracker {  

    public String name = null;
    public double balance = 0.0;
    public double lastSpent = 0.0;
    public double lastIncome = 0.0;

    public MoneyTracker(){
        System.out.println("A new money tracker has been launched.");
    }

    public void createTracker (String name){
        this.name = name;
        balance = 1.0;
    }
    
    public void income (double income){
        balance += income;
        lastIncome = income;
        System.out.println("Balance Updated!");
    }

    public void expense (double expense){
        if (balance >= expense) {
            balance -= expense;
            lastSpent = expense;
            if (balance > 0) {
                System.out.println("Balance Updated!");
            } else {
                System.out.println("You're broke!");
            }
        } else {
            System.out.println("Not enough balance.");
        }
    }

    public String info() {
       return "Name: "+ name + "\n" +"Current Balance: " + balance;
    }

    public void showHistory (){
        System.out.println("Last added: " + lastIncome);
        System.out.println("Last spent: " + lastSpent);
    }
}


