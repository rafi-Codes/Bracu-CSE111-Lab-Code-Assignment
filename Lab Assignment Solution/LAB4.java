// Task 01
public class Triangle {  
    public int side1, side2, side3;
    public int perimeter;

    public Triangle (int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        perimeter = side1 + side2 + side3;
    }

    public String printTriangleType (){
        if (side1 == side2 && side2 == side3) return "This is an Equilateral Triangle.";
        else if (side1 == side2 || side2 == side3 || side1 == side3) return "This is an Isosceles Triangle.";
        else return "This is a Scalene Triangle.";
    }
    
    public void triangleDetails (){
        System.out.printf("Three sides of the triangle are: %d, %d, %d\n", side1, side2, side3);
        System.out.println("Perimeter: " + perimeter);
    }

    public void compareTriangles (Triangle t){
        if (this == t) {
            System.out.println("These two triangle objects have the same address.");
        } else if (this.side1 == t.side1 && this.side2 == t.side2 & this.side3 == t.side3) {
            System.out.println("Addresses are different but the sides of the triangles are equal.");
        } else if (this.perimeter == t.perimeter) {
            System.out.println("Only the perimeter of both triangles is equal.");
        } else {
            System.out.println("Addresses, length of the sides and perimeter all are different.");
        }
    }
}

// Task 02
public class Player {  

    public String name;
    public int currentHp;
    public String[] defeatedList = new String[5];
    public int defeated;

    public Player (String name, int hp){
        this.name = name;
        currentHp = hp;
        System.out.println(name +" joined the game\nHP: " + currentHp);
    }

    public Player (String name){
       this(name, 100);
    }

    public void viewInfo (){
        System.out.println("Player Name: " + name +"\nCurrent HP: " + currentHp);
        if (defeated > 0) {
            System.out.println("Defeated:");
            for (int i = 0; i < defeated; i++){
                System.out.print(defeatedList[i]);
            }
            System.out.println();
        }
    }
    
    public void defeatVillain (Player p){
        if (defeated < defeatedList.length){
            if (currentHp >= p.currentHp) {
                System.out.println("defeated " + p.name);
                currentHp += p.currentHp;
                defeatedList[defeated++] = p.name + ", ";
            } else {
                System.out.println("failed to defeat " + p.name);
            }
        }
    }

    public void defeatVillain (String name, int hp){
        if (defeated < defeatedList.length){
            if (currentHp >= hp) {
                System.out.println("defeated " + name);
                currentHp += hp;
                defeatedList[defeated++] =  name + ", " ;
            } else {
                System.out.println("failed to defeat " + name);
            }
        }
    }

    public void defeatVillain (char multiplier, String name, int hp){
        currentHp *= ((int)(multiplier - '0'));
        System.out.println("HP with " + multiplier + "x boost: " + currentHp);
        defeatVillain(name,hp);
    }
}

// Task 03
public class Student {  
    public String name;
    public int id;
    public String department;
    public String email;
    private String password;
    private boolean loginStatus;
    public String[] advisedCourses = new String[3];

    public Student(String name, int id, String department) {
        this.department = department;
        this.id = id;
        this.name = name;
        System.out.println("Student object is created");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }
}

public class Connect {  

    public int totalAdvisee = 0;
    public Student[] students = new Student[5];

    public Connect (){
        System.out.println("Connect is ready to use!");
    }
    
    public void login (Student s){
        if (s.email == null || s.getPassword() == null){
            System. out.println("Email and password need to be set.");
        } else {
            s.setLoginStatus(true);
            System.out.println("Login successful");
        }
    }

    public void advising (Student s){
        if(!s.isLoginStatus()){
            System.out.println("Please login to advise courses!");
        } else {
            System.out.println("You haven't selected any courses.");
        }
    }

    public void advising (Student s, String course1, String course2, String course3){
        if(!s.isLoginStatus()){
            System.out.println("Please login to advise courses!");
        } else {
            s.advisedCourses[0] = course1;
            s.advisedCourses[1] = course2;
            s.advisedCourses[2] = course3;
            students[totalAdvisee++] = s;
            System.out.println("Advising successful!");
        }
    }

    public void advising (Student s, String course1, String course2, String course3, String course4){
        System.out.println("You need special approval to take more than 3 courses.");
    }

    public void allAdviseeInfo(){
        System.out.println("Total Advisee: " + totalAdvisee);
        for  (int i = 0; i < totalAdvisee; i++){
            System.out.printf("Name: %s ID: %d\n", students[i].name, students[i].id);
            System.out.println("Department: " + students[i].department);
            for (int j = 0; j < students[i].advisedCourses.length; j++){
                System.out.print(students[i].advisedCourses[j] + " ");
            }
            System.out.println("\n==============");
        }
    }
}

// Task 04
public class Cargo {  
    private String itemName;
    private  int weight;

    public Cargo(String itemName, int weight) {
        this.itemName = itemName;
        this.weight = weight;
    }
    
    public String getItemName() {
        return itemName;
    }

    public int getWeight() {
        return weight;
    }
}

public class Spaceship {  
    private String name;
    private  int currentWeight;
    private int MAX_CAPACITY;
    public int loadedItems;
    public Cargo[] cargoItems = new Cargo[100];

    public Spaceship(String name, int MAX_CAPACITY) {
        this.name = name;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void loadCargo (Cargo c){
        if ((currentWeight + c.getWeight()) <= MAX_CAPACITY){
            cargoItems[loadedItems++] = c;
            currentWeight += c.getWeight();
        } else {
            int Exceeds = (currentWeight + c.getWeight()) - MAX_CAPACITY;
            System.out.printf("Warning: Unable to load %s inside %s. Exceeds capacity by %d.\n", c.getItemName(), name, Exceeds);
        }
    }

    public void displayDetails() {
        System.out.println("Spaceship Name: "+ name);
        System.out.println("Capacity: " + MAX_CAPACITY);
        System.out.println("Current Cargo Weight: " + currentWeight);
        if (loadedItems > 0) {
            System.out.print("Cargo:");
            for (int i = 0; i < loadedItems; i++){
                System.out.print(cargoItems[i].getItemName() + " ");
            }
            System.out.println();
        }
    }
}

