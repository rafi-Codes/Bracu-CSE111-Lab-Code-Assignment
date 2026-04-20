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

// Task 02
public class Character {

    public int health;
    public String name;
    public String type;
    public int _id;

    public static String strongest = "None";
    public static int Kids = 0;
    public static int Teens = 0;
    public static int Adults = 0;
    public static int totalHealth;
    public static int totalCharacters;
    public static int maxHealth;
    public static int id = 1;

    public Character(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;

        switch(type){
            case "Kid": 
                Kids++;
                break;
            case "Adult": 
                Adults++; 
                break;
            case "Teen": 
                Teens++; 
                break;
        }

        _id = id++;
        totalHealth += health;
        totalCharacters = Kids + Adults + Teens;

        if (health > maxHealth) {
            maxHealth = health;
            strongest = name;
        }
    }

    public Character(String name, int health) {
        this(name, "Teen", health);
    }

    public static void printStats() {
        int avgHealth = totalCharacters <= 0 ? 0 : totalHealth / totalCharacters;
        System.out.println("Total Characters: " + totalCharacters);
        System.out.println("Kids: " + Kids);
        System.out.println("Teens: " + Teens);
        System.out.println("Adults: " + Adults);
        if (avgHealth == 0) {
            System.out.println("Average Health: 0");
        } else {
            System.out.println("Average Health: " + (double) avgHealth);
        }
        if (strongest.equals("None")) System.out.println("Strongest Character: " + strongest); 
        else System.out.println("Strongest Character:\n" + strongest + " (Health " + maxHealth + ")");
    }

    public void printDetails() {
        System.out.println("ID: " + _id + ", Name: " + name);
        System.out.println("Group: " + type);
        System.out.println("Health: " + health);
    }
}

// Task 03
public class Artifact {

    private int power;
    private String name;
    private String adderName;

    private static int maxPower = 0;
    private static Artifact[] vault = new Artifact[4];
    private static int stored = 0;
    private static String strongest;

    public Artifact (String name, String adderName) {
        this.name = name;
        this.adderName = adderName;
        power = CalcPower();
        CalcStrongest();    
    }

    public Artifact (String name) {
        this(name,"Okabe");
    }

    public static void AddtoVault(Artifact a) {
        if (stored < vault.length) {
            vault[stored++] = a;
            System.out.println(a.GetAdderName() + " added "+ a.GetName() +" successfully to the vault.");
        } else { 
            System.out.println("!!"+ a.GetAdderName() + " unsuccessful in adding artifact to the vault!!");
        }
    }

    public static void labReport() {
        System.out.println("=== Future Gadget Lab ===");
        for (int i = 0; i < stored; i++){
            vault[i].revealArtifact();
        }
    }

    public void revealArtifact() {
        System.out.println(GetName() + " added by "+ GetAdderName() +" has power of " + GetPower() + ".");
    }

    public void changeName(String name){
        this.name = name;
        power = CalcPower();
        CalcStrongest(); 
        System.out.println("Name changed and power recalculated.");
    }

    public int CalcPower() {
        int sum = 0;
        int idx = name.length() % 2;
        for (int i = idx; i < name.length(); i+=2){
            sum += name.charAt(i);
        }
        return sum;
    }

    public void CalcStrongest() {
        if (power > maxPower){
            strongest = name;
            maxPower = power;
        }
    }

    public String GetName() {
        return name;
    }

    public String GetAdderName() {
        return adderName;
    }

    public int GetPower() {
        return power;
    }

    public static String strongest(){
        return strongest;
    }
}

