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

// Task 04
public class Animalkeepers {

    public int id;
    public String name;
    public static int kCount = 0;
    public static int tCount = 0;
    public static String[] Animals = {"Lion", "Tiger", "Seal", "Gorilla", "Deer"};
    public static String[] Tasks = new String[Animals.length];


    public Animalkeepers (String name) {
        this.name = name;
        id = 100 + (++kCount);
        System.out.println(name + " with ID "+ id +" got the job!");
    }

    public void doTask(String animal, String task) {
        boolean assigned = false;
        switch(animal) {
            case "Lion":
                Tasks[0] = task + "  (Keeper - "+ name + ") === " + "Lion";
                assigned = true;
                break;
            case "Tiger":
                Tasks[1] = task + "  (Keeper - "+ name + ") === " + "Tiger";
                assigned = true;
                break;
            case "Seal":
                Tasks[2] = task + "  (Keeper - "+ name + ") === " + "Seal";
                assigned = true;
                break;
            case "Gorilla":
                Tasks[3] = task + "  (Keeper - "+ name + ") === " + "Gorilla";
                assigned = true;
                break;
            case "Deer":
                Tasks[4] = task + "  (Keeper - "+ name + ") === " + "Deer";
                assigned = true;
                break;
            default:
                System.out.println("Animal not in the Safari");
                break;
        }
        if (assigned){
            System.out.println("Task assigned to "+ name);
        }
        tCount = tasksCount();
    }

    public static void printTasks() {
        if (tCount > 0){
            for (int i = 0; i < Tasks.length; i++){
                if (Tasks[i] != null){
                    System.out.println(Tasks[i]);
                }
            }
        } else {
            System.out.println("No tasks assigned.");
        }
        
    }

    public static int tasksCount() {
        int count = 0;
        for (int i = 0; i < Tasks.length; i++){
            if (Tasks[i] != null){
                count++;
            }
        }
        return count;
    }

    public static void details() {
        if (kCount > 0) {
            System.out.println("Total Animal Keeper: " + kCount);
            System.out.println("Total Task assigned: " + tCount);
        } else {
            System.out.println("No Animal Keepers working yet.");
        }
        printTasks();
    }
}

// Task 05
public class Event {

    private String date;
    private String name;
    public static Event[] Events = new Event[5];
    public static int storedEvent = 0;

    public Event(String name, String date) {
        this.date = date;
        this.name = name;
        if (storedEvent < Events.length) Events[storedEvent++] = this;
    }

    public static void allEventInfo() {
        System.out.println("Total Events: "+ storedEvent +"\nEvent Details:");
        if (storedEvent > 0) {
            for (int i = 0; i < storedEvent; i++) {
                System.out.println("Event "+ (i + 1) +":");
                System.out.println(Events[i].details());
            }
        }
    }

    public String details() {
        return "Name: "+ name +"\nDate: "+ date;
    }
    
    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }
}

public class Organizer {
	public String name;
    public Event[] organizedEvents = new Event[4];
    public int orgCount = 0;
    
    public Organizer() {
        System.out.println("Please provide the organizer's name");
    }
    
    public Organizer(String name) {
        this.name = name;
    }

    public void organizeEvent(Event ev) {
        if (orgCount < organizedEvents.length) {
            organizedEvents[orgCount++] = ev;
            System.out.println(name + " successfully organized "+ ev.getName());
        }
    }

    public void searchEventByDate(String date) {
        boolean found = false;
        for (int i = 0; i < orgCount; i++){
            if (date.equals(organizedEvents[i].getDate())){
                System.out.println(organizedEvents[i].getName());
                found= true;
                break;
            }
        }
        if (!found) System.out.println("No event is scheduled for " + date);
    }
}

