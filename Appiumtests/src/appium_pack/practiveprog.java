package appium_pack;
class practiveprog {
    public static void main(String[] args) {
        int number = 10;
        int kutta = 4;
        // checks if number is greater than 0
        if (number > 0) {
            System.out.println("The number is positive.");
            if(kutta >5) {
            	System.out.println("This is nested if");
            }
            else {
            	System.out.println("Okey");
            }
        }
        else {
        	System.out.println("This is main if condition: ");
        }
        System.out.println("This statement is always executed.");
    }
}


