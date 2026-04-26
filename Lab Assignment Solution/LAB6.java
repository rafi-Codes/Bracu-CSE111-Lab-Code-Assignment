// Task 01
public class Cow extends Animal{
    public String name;

    public Cow(){
        System.out.println("The cow says hello!");
    }
  
    public String getName(){
        return name;
    }
  
    public void updateSound(String sound){
        super.sound = sound;
    }
}

// Task 02
public class CheckingAccount extends Account {
  public static int count = 0;

  public CheckingAccount (double balance){
    super(balance);
    count++;
  }

  public CheckingAccount (){
    super(0.0);
    count++;
  }
}

// Task 03
public class Book extends Product {
  
  public String ISBN;
  public String publisher;

  public Book (int id, String title, int price, String ISBN, String publisher){
    this.ISBN = ISBN;
    this.publisher = publisher;
    super(id,title,price);
  }

  public String printDetail (){
    return getIdTitlePrice() + " ISBN: " + ISBN + " Publisher: "+publisher;
  }
}

public class CD extends Product {
  public int duration;
  public String band;
  public String genre;

  public CD (int id, String title, int price, String band, int duration, String genre){
    this.duration = duration;
    this.band = band;
    this.genre = genre;
    super(id,title,price);
  }

  public String printDetail (){
    return getIdTitlePrice() + " Band: " + band + " Duration: "+ duration + " minutes Genre: " + genre;
  }
}
