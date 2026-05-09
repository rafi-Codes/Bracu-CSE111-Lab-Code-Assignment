// Task01
public class CSEStudent extends Student {
  
  public String msg = "I want to transfer to CSE";
  
  public String shout(){
    return msg;
  }
}

public class CSE111Student extends CSEStudent {
  
  public String msg = "I love Java Programming";

  public String shout(){
    return msg;
  }
}


// Task02
public class PlatinumCard extends CreditCard {

  public PlatinumCard (String cardHolder, String accountNo){
    super(cardHolder, accountNo, 100);
  }

  public void spendCash(int amount) {
    int previousAmount = rewardPoints;
    if (amount >= 100) {
      rewardPoints += ( 2* (amount/100));
      System.out.println("Previous Reward Points: "+ previousAmount);
      System.out.println("Reward points after spending "+ amount +" taka: " + rewardPoints);
    }
  }
}

public class SignatureCard extends CreditCard {

  public SignatureCard (String cardHolder, String accountNo){
    super(cardHolder, accountNo, 200);
  }

  public void spendCash(int amount) {
    int previousAmount = rewardPoints;
    if (amount >= 100) {
      rewardPoints += ( 4 * (amount/100));
      System.out.println("Previous Reward Points: "+ previousAmount);
      System.out.println("Reward points after spending "+ amount +" taka: " + rewardPoints);
    }
  }

  public void cardDetails(){
       super.cardDetails();
       System.out.println("Possible Number of Companions for Lounge: 5");
   }

}
