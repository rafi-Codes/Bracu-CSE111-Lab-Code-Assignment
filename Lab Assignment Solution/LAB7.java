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
    System.out.println("Butterfly lost energy due to nocturnal activity");
  }
  
  public void transform() {
    System.out.println("Caterpillar transforms into Butterfly");
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
    public static String[] restrictedAreas = new String[1];
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
    public static String[] restrictedAreas = new String[1];
    private static int count = 0;

    public CarDriver(String name) {
        super(name);
        this.profile = "Premium";
    }

    public String toString() {
        return getName() + "'s driver profile is " + profile;
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
