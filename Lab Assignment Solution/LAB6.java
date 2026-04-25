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
