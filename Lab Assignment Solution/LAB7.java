// Task 01
public class Butterfly extends Caterpillar {
  public Butterfly (String food, int age){
    super(food,age);
  }

  public void eat() {
   eat(1);
  }

  public void eat(int amount) {
    energy += (amount * 5);
    energy -= 5;
    System.out.println("Butterfly lost energy while flying and absorbed nectar");
  }
  
  public void transform() {
    System.out.println("Caterpillar transforms into Butterfly");
  }
  
  public void showDetails() {
    System.out.println("Food: " + food);
    System.out.println("Age: " + age);
    System.out.println("Energy: " + energy + " joules");
  }
}

public class Moth extends Caterpillar {
  public Moth (String food, int age){
    super(food,age);
  }

  public void eat() {
    eat(1);
  }

  public void eat(int amount) {
    energy += (amount * 2.5);
    energy -= 2.5;
    System.out.println("Moth lost energy due to nocturnal activity");
  }
  
  public void transform() {
    System.out.println("Caterpillar transforms into Moth");
  }

  public void showDetails() {
    System.out.println("Food: " + food);
    System.out.println("Age: " + age);
    System.out.println("Energy: " + energy + " joules");
  }
}

// Task 02
public class Concert {

  public String name,time,artistList = "";
  public int artistCount, soldTickets;
  public static int totalSoldTickets;

  public Concert (String name, String time){
    this.name = name;
    this.time = time;
  }

  public void addArtist(String artistName) {
    if (artistCount <= 5){
      artistList += "-" + artistName + "\n";
      artistCount++;
    } else {
      System.out.println("Maximum artist reached");
    }
  }

  public void showDetails() {
    System.out.println("Venue: " + name);
    System.out.println("Showtime: " + time);
    System.out.println("Artist: ");
    System.out.print(artistList);
    System.out.println("Tickets sold in this concert: " + soldTickets);
  }

  public void buyTicket(String zone, int amount){
    int price = 0;
    switch(zone){
      case "A":
        soldTickets += amount;
        price = 500 * amount;
        break;
      case "B":
        soldTickets += amount;
        price = 1000 * amount;
        break;
    }
    System.out.println("Total price: " + price);
    totalSoldTickets += amount;
  }
  
  public void buyTicket(String zone){
    buyTicket(zone,1);
  }

  public static void showTotalTicketsSold(){
    System.out.println("Total tickets sold (all venues): "+ totalSoldTickets);
  }
}

public class VIPConcert extends Concert {
  
  public VIPConcert (String name, String time){
    super(name,time);
  }

  public void buyTicket(){
    System.out.println("Total price: " + 2000);
    soldTickets++;
    totalSoldTickets++;
  }
}

// Task 03
public class BikeDriver extends GenericDriver {
    private String profile;
    public static String[] restrictedAreas = new String[0];
    private static int count = 0;

    public BikeDriver(String name, String profile) {
        super(name);
        this.profile = profile;
    }

    public String toString() {
        return getName() + "'s driver profile is " + profile;
    }

    public String acceptRide(boolean hasVehicle) {
        return super.acceptRide(hasVehicle) + "\n" + toString();
    }

    public static void restrictedAreas(String area) {
        String[] temp = new String[count+1];
        for (int i = 0; i < restrictedAreas.length; i++) {
          temp[i] = restrictedAreas[i];
        }
        temp[temp.length - 1] = area;
        restrictedAreas = temp;
        count++;
    }

    public void fightRestriction(String[] areas) {
        for (int j = 0; j < areas.length; j++) {
            boolean restricted = false;
            for (int i = 0; i < count; i++) {
                if (restrictedAreas[i].equals(areas[j])) {
                    restricted = true;
                    break;
                }
            }
            if (restricted) {
                System.out.println(getName() + " cannot enter " + areas[j]);
            } else {
                System.out.println(getName() + " can enter " + areas[j]);
            }
        }
    }
}

public class CarDriver extends GenericDriver {
    private String profile;
    public static String[] restrictedAreas = new String[0];
    private static int count = 0;

    public CarDriver(String name) {
        super(name);
        this.profile = "Premium";
    }

   public String toString() {
    return getName() + "'s driver profile is a " + profile;
   }

    public void hasSafetyTraining() {
        super.hasSafetyTraining();
        System.out.println("Premium drivers receive extra safety briefings.");
    }

    public String acceptRide(boolean hasVehicle) {
        return super.acceptRide(hasVehicle) + "\n" + toString();
    }

    public static void restrictedAreas(String area) {
        String[] temp = new String[count+1];
        for (int i = 0; i < restrictedAreas.length; i++) {
          temp[i] = restrictedAreas[i];
        }
        temp[temp.length - 1] = area;
        restrictedAreas = temp;
        count++;
    }

    public void fightRestriction(String[] areas) {
        for (int j = 0; j < areas.length; j++) {
            boolean restricted = false;
            for (int i = 0; i < count; i++) {
                if (restrictedAreas[i].equals(areas[j])) {
                    restricted = true;
                    break;
                }
            }
            if (restricted) {
                System.out.println(getName() + " cannot enter " + areas[j]);
            } else {
                System.out.println(getName() + " can enter " + areas[j]);
            }
        }
    }
}

// Task 04
public class Car extends Vehicle {
    private int seats;
    private static int carCount = 0;
    private static Car[] allCars = new Car[0];

    public Car(String model, int price, int seats) {
        super(model, price);
        this.seats = seats;
        addCar(this);
        this.vehicleId = "CAR00" + carCount;
        System.out.println("Vehicle ID: " + vehicleId + " created");
    }

    public void vehicleDetail() {
        super.vehicleDetail();
        System.out.println("Type: Regular Car");
        System.out.println("Seats: " + seats);
    }

    public static void showAllAvailableCars() {
        System.out.println("Total Car: " + carCount);
        System.out.println("Available Cars:");
        for (int i = 0; i < allCars.length; i++) {
            if (!allCars[i].sold) {
                System.out.println(allCars[i].vehicleId + " : " + allCars[i].model);
            }
        }
    }

    public static void showAllCars() {
        System.out.println("Total Car: " + carCount);
        for (int i = 0; i < allCars.length; i++) {
            String status;
            if (allCars[i].sold){
                status =  "sold";
            } else {
                status = "available";
            }
            System.out.println(allCars[i].vehicleId + " : " + allCars[i].model + " - " + status);
        }
    }

    public static void markAsSold(Car c) {
        c.sold = true;
    }

    public static void addCar(Car c) {
        Car[] temp = new Car[carCount+1];
        for (int i = 0; i < allCars.length; i++) {
          temp[i] = allCars[i];
        }
        temp[temp.length - 1] = c;
        allCars = temp;
        carCount++;
    }
}

public class ElectricCar extends Vehicle {
    private int batteryCapacity;
    private static int evCount = 0;
    private static ElectricCar[] allEVs = new ElectricCar[0];

    public ElectricCar(String model, int price, int batteryCapacity) {
        super(model, price);
        this.batteryCapacity = batteryCapacity;
        this.vehicleId = "EV000";
        System.out.println("Vehicle ID: " + vehicleId + " created");
        addEv(this);
    }

    public void vehicleDetail() {
        super.vehicleDetail();
        System.out.println("Type: Electric Vehicle");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }

    public static void markAsSoldEV(ElectricCar e) {
        e.sold = true;
    }

    public static void addEv(ElectricCar Ec) {
        ElectricCar[] temp = new ElectricCar[evCount+1];
        for (int i = 0; i < allEVs.length; i++) {
          temp[i] = allEVs[i];
        }
        temp[temp.length - 1] = Ec;
        allEVs = temp;
        evCount++;
    }
}

// Task 05
public class Manager extends Employee {
    public double bonusPercent;
    public double finalSalary;

    public Manager(String name, double baseSalary, int hoursWorked, double bonusPercent) {
        super(name, baseSalary, hoursWorked);
        this.bonusPercent = bonusPercent;
        this.finalSalary = baseSalary;
    }

    public void calculateSalary() {
        if (getHoursWorked() > 40) {
            finalSalary = getBaseSalary() + (getBaseSalary() * (bonusPercent / 100));
        } else {
            finalSalary = getBaseSalary();
        }
    }

    public void requestIncrement(double amount) {
        if (getHoursWorked() > 100) {
            setBaseSalary(getBaseSalary() + amount);
            System.out.println("$" + amount + " Increment approved.");
        } else if (getHoursWorked() > 80) {
            setBaseSalary(getBaseSalary() + (amount * 0.5));
            System.out.println("$" + (amount * 0.5) + " Increment approved.");
        } else {
            System.out.println("Increment denied.");
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: " + bonusPercent + " %");
        System.out.println("Final Salary: $" + finalSalary);
    }
}

public class Developer extends Employee {
    public String language;
    public double finalSalary;

    public Developer(String name, double baseSalary, int hoursWorked, String language) {
        super(name, baseSalary, hoursWorked);
        this.language = language;
        this.finalSalary = baseSalary;
    }

    public void calculateSalary() {
        finalSalary = getBaseSalary();
        if (language.equals("Java")) {
            finalSalary += 700;
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Language: " + language);
        System.out.println("Final Salary: $" + finalSalary);
    }
}

