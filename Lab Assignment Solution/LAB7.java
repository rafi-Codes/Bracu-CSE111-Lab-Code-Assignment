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
