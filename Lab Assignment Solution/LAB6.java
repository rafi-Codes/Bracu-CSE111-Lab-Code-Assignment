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

// Task 04
public class ComplexNumber extends RealNumber {
  public double imgVal;

  public ComplexNumber (double realVal, double imgVal){
    super(realVal);
    this.imgVal = imgVal;
  }

  public ComplexNumber (){
    super(1.0);
    this.imgVal = 1.0;
  }

  public String details(){
    return getReal() + "\nImaginaryPart: " + imgVal;
  }
}

// Task 05
public class CSEStudent extends Student {
  public static int cseStudentCount;
  public static String labCourses = "CSE110 CSE111 CSE220 CSE221";

  public CSEStudent(String name, int id){
    super(name,id);
    cseStudentCount++;
  }

  public void addLabBasedCourse(String course){
    if(labCourses.contains(course)){

      if(courses.equals("")) 
          courses += course;
      else 
          courses += (" " + course);

    } else {
      System.out.println("It is not a lab based course!");
    }
  }

  public static void details(){
    System.out.println("Total CSE Students: " + cseStudentCount);
    System.out.println("Available Lab Based Courses:\n"+ labCourses);
  }
}
