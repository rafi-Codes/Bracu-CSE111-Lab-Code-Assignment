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
