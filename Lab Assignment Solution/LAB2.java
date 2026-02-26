// Task 01
public class ImaginaryNumber { 
    public int realPart = 0; 
    public int imaginaryPart = 0; 

    public String printNumber(){
        return realPart + " + " + imaginaryPart + "i";
    }
}

// Task 02
public class Assignment { 
    public int tasks = 0; 
    public String difficulty; 
    public boolean submission = false;

    public void printDetails(){
        System.out.println("Number of tasks: " + tasks);
        System.out.println("Difficulty level: " + difficulty);
        System.out.println("Submission required: " + submission);
    }

    public String makeOptional(){
        if (!submission){
            return "Submission is already not required";
        } else {
            submission = false;
            return "Assignment will not require submission";
        }
    }
}

// Task 03
public class Employee { 
    public String name; 
    public double salary; 
    public String designation;

    public void newEmployee(String name){
        this.name = name;
        salary = 30000; 
        designation = "junior";
    }

    public void displayInfo(){
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary + " Tk");
        System.out.println("Employee Designation: " + designation);
    }

    public void promoteEmployee(String designation){
        this.designation = designation;
        switch(designation){
            case "senior":
                salary += 25000;
                break;
            case "lead":
                salary += 50000;
                break;
            case "manager":
                salary += 75000;
                break;
            default:
                break;
        }
        System.out.println(name + " has been promoted to " + designation);
        System.out.printf("New Salary: %.2f Tk\n",salary);
    }

    public void calculateTax(){
        if (salary > 50000){
            double tax = salary * 0.30;
            System.out.println( name + " Tax Amount: " + tax + " Tk");
        } else if (salary > 30000) {
            double tax = salary * 0.10;
            System.out.println( name + " Tax Amount: " + tax + " Tk");
        } else {
            System.out.println("No need to pay tax");
        }
    }
}

// Task 04
public class MobilePhone {  
    public String[] contactsName = new String[0];
    public int[] contactsNumber = new int[0];
    public int storedContacts;

    public void setContactCapacity(int size){
        String[] temp = new String[size];
        int[] tempN = new int[size];
        for (int i = 0; i < contactsName.length; i++){
            temp[i] = contactsName[i];
            tempN[i] = contactsNumber[i];
        }
        contactsName = temp;
        contactsNumber = tempN;
    }

    public void addContact(String name, int number){
        if (storedContacts < contactsName.length){
            contactsName[storedContacts] = name;
            contactsNumber[storedContacts] = number;
            storedContacts++;
            System.out.println("The contact of " + name + " is added.");
        } else {
            System.out.println("Storage Full!!");
            storedContacts = contactsName.length;
        }
    }

    public void details(){
        System.out.println("Total Contacts: " + storedContacts);
        System.out.println("Contact List:");
        for (int i = 0; i < storedContacts; i++){
            System.out.println(contactsName[i] + ":" + contactsNumber[i]);
        }
    }

    public void makeCall(int number){
        for (int i = 0; i < storedContacts; i++){
            if (contactsNumber[i] == number){
                System.out.println("Calling " + contactsName[i] + " . . .");
                return;
            }
        }
        System.out.println("Calling " + number + " . . .");
    }
}
