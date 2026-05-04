// Task 01
public class Butterfly extends Caterpillar {
  public Butterfly (String food, int age){
    super(food,age);
  }

  public void eat() {
    energy += 5;
    energy -= 5;
    System.out.println("Butterfly lost energy due to nocturnal activity");
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
    energy += 2.5;
    energy -= 2.5;
    System.out.println("Moth lost energy due to nocturnal activity");
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
