// Task 01
public class Triangle {  
    public int side1, side2, side3;
    public int perimeter;

    public Triangle (int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        perimeter = side1 + side2 + side3;
    }

    public String printTriangleType (){
        if (side1 == side2 && side2 == side3) return "This is an Equilateral Triangle.";
        else if (side1 == side2 || side2 == side3 || side1 == side3) return "This is an Isosceles Triangle.";
        else return "This is a Scalene Triangle.";
    }
    
    public void triangleDetails (){
        System.out.printf("Three sides of the triangle are: %d, %d, %d\n", side1, side2, side3);
        System.out.println("Perimeter: " + perimeter);
    }

    public void compareTriangles (Triangle t){
        if (this == t) {
            System.out.println("These two triangle objects have the same address.");
        } else if (this.side1 == t.side1 && this.side2 == t.side2 & this.side3 == t.side3) {
            System.out.println("Addresses are different but the sides of the triangles are equal.");
        } else if (this.perimeter == t.perimeter) {
            System.out.println("Only the perimeter of both triangles is equal.");
        } else {
            System.out.println("Addresses, length of the sides and perimeter all are different.");
        }
    }
}


