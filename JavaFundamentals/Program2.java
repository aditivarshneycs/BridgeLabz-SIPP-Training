import java.util.Scanner;

class Program2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double h=sc.nextDouble();
		double base=sc.nextDoule();
		double km=sc.nextDouble();
		int fee=sc.nextInt();
		int dp=sc.nextInt();
		double a = sc.nextDouble();
        	double b = sc.nextDouble();
		double c=sc.nextDouble();
		double perimeter = sc.nextDouble();
		double feet=sc.nextDouble();
		double unitPrice = sc.nextDouble();
        	int quantity = sc.nextInt();
		int number1 = sc.nextInt();
        	int number2 = sc.nextInt();
		int d = sc.nextInt();
        	int e = sc.nextInt();
        	int f = sc.nextInt();
		Q1();
		Q2();
		Q3();
		Q4();
		Q5(h);
		Q6(km);
		Q7();
		Q8();
		Q9(fee,dp);
		Q10();
		Q11(a,b);
		Q12(h,base);
		Q13(perimeter);
		Q14(feet);
		Q15(unitPrice,quality);
		Q16(number1,number2);
		Q17(d,e,f);
		Q18(a,b,c);
		Q19(number1,number2);
		Q20();
		Q21();
		Q22();
		Q23();
		Q24();
		Q25();
		Q26();
		Q27();
		Q28();

	}

	//Write a Program to compute the volume of Earth in km^3 and miles^3

	public static void Q1(){
		int radius=6378;
		double VoE=(4/3)*3.14*Math.pow(radius,3);
		double miles=VoE*0.621371;
		System.out.println("The volume of earth in cubic kilometers is "+ VoE +" and cubic miles is "+miles);
	}


	// divide 14 pens among 3 students equally. how many pens each student will get if the pens must be divided equally.

	public static void Q2(){
		int mod=14%3;
		int div=14/3;
		System.out.println("The Pen Per Student is "+div+" and the remaining pen not distributed is "+mod);
	}

	//Create a program to convert the distance of 10.8 kilometers to miles.
	
	public static void Q3(){
		double mile=10.8*0.621371;
		System.out.println("The distance 10.8 km in miles is "+mile);
	}

	//CP to calculate the profit and loss in number and percentage based on the cost price of INR 129 and the selling price of INR 191.

	public static void Q4(){
		int cp=129,sp=191;
		int profit = sp - cp;
		double pp = profit / cp * 100;
		System.out.println("The Cost Price is INR "+cp+" and the Selling Price is INR "+ sp+"\nThe Profit is INR "+ profit+" and the Profit Percentage is "+pp);
	}
	
	//WAP that takes your height in centimeters and converts it into feet and inches.
	
	public static void Q5(double h){
		double in=2.54*h;
		double ft=12*in;
		System.out.println("Your Height in cm is "+h+" while in feet is "+ft+" and inches is "+in);
	}

	//Create a program to convert distance in kilometers to miles.

	public static void Q6(double km){
		double miles=1.6*km;
		System.out.println("The total miles is "+miles+" mile for the given "+km+" km");
	}

	/*University is charging the student a fee of INR 125000 for the course.The University is willing find the discounted amount and discounted price 	the student will pay for the courseto offer a discount of 10%.*/

	public static void Q7(){
		float discount=125000f*0.1f;
		float sub=125000f-discount;
		System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+sub);
	}

	//Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM.

	public static void Q8(){
		int p=95,c=96,m=94;
		float avg=(p+c+m)/3;
		System.out.println("Sam’s average mark in PCM is "+avg);
	}

	// user input for Student Fee and University Discount to compute the discounted amount and discounted price the student will pay for the course.

	public static void Q9(int fee,int dp){
		double dis=fee*dp*0.1;
		double fd= fee-dis;
		System.out.println("The discount amount is INR "+dis+" and final discounted fee is INR "+fd);
	}

	//find the age of Harry if the birth year is 2000. Assume the Current Year is 2024.

	public static void Q10(){
		int birthYear = 2000;
        	int currentYear = 2024;
        	int age = currentYear - birthYear;
        	System.out.println("Harry's age in 2024 is " + age);
	}

	//calculator

	public static void Q11(double a,double b){
		System.out.println("Addition: " + (a + b));
        	System.out.println("Subtraction: " + (a - b));
        	System.out.println("Multiplication: " + (a * b));
        	System.out.println("Division: " + (a / b));
	}

	//Area of triangle

	public static void Q12(double h,double base){
		double areaCM = 0.5 * base * h;
        	double areaInches = areaCM / (2.54 * 2.54);
        	System.out.println("The Area of the triangle in sq in is " + areaInches + " and sq cm is " + areaCM);
	}

	//side of square from perimeter

	public static void Q13(double perimeter){
		double side = perimeter / 4;
        	System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
	}

	//Feet to yards and miles

	public static void Q14(double feet){
		double yards = feet / 3;
        	double miles = yards / 1760;
        	System.out.println("The distance in yards is " + yards + " while the distance in miles is " + miles);
	}

	//Total purchase price

	public static void Q15(double unitPrice,int quality){
		double total = unitPrice * quantity;
        	System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and the unit price is INR " + unitPrice);
	}

	//Quotient and remainder

	public static void Q16(int number1,int number2){
		System.out.println("The Quotient is " + (number1 / number2) + " and Reminder is " + (number1 % number2));
	}

	//Integer operations

	public static void Q17(int d,int e,int cf){
		System.out.println("Results: " + (d + e * f) + ", " + (d * e + f) + ", " + (d + e / f) + ", " + (d % e + f));
	}

	//Double operations

	public static void Q18(double a,double b, double c){
		System.out.println("Results: " + (a + b * c) + ", " + (a * b + c) + ", " + (c + a / b) + ", " + (a % b + c));
	}

	//Swap two numbers
	
	public static void Q19(int number1,int number2){
		int temp = number1;
        	number1 = number2;
        	number2 = temp;
		System.out.println("The swapped numbers are " + number1 + " and " + number2);
	}

	//Celsius to Fahrenheit

	public static void Q20(){
		Scanner input = new Scanner(System.in);
        	double celsius = input.nextDouble();
        	double fahrenheit = (celsius * 9 / 5) + 32;
        	System.out.println("The " + celsius + " celsius is " + fahrenheit + " fahrenheit");
	}

	//Pounds to kilograms

	public static void Q21(){
		Scanner input = new Scanner(System.in);
        	double pounds = input.nextDouble();
        	double kg = pounds / 2.2;
        	System.out.println("The weight of the person in pounds is " + pounds + " and in kg is " + kg);
	}

	//Divide chocolates

	public static void Q22(){
		Scanner input = new Scanner(System.in);
        	int chocolates = input.nextInt();
        	int children = input.nextInt();
        	System.out.println("Each child gets " + (chocolates / children) + " chocolates and remaining chocolates are " + (chocolates % children));
	}

	//Maximum handshakes

	public static void Q23(){
		Scanner input = new Scanner(System.in);
        	int n = input.nextInt();
        	int handshakes = (n * (n - 1)) / 2;
        	System.out.println("The number of possible handshakes is " + handshakes);
	}

	//Triangular run rounds

	public static void Q24(){
		Scanner input = new Scanner(System.in);
        	double s1 = input.nextDouble();
        	double s2 = input.nextDouble();
       		double s3 = input.nextDouble();
        	double perimeter = s1 + s2 + s3;
        	double rounds = 5000 / perimeter;
        	System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
	}

	//Travel distance and time

	public static void Q25(){
		Scanner input = new Scanner(System.in);
        	String name = input.nextLine();
        	String fromCity = input.nextLine();
        	String viaCity = input.nextLine();
        	String toCity = input.nextLine();
        	double fromToVia = input.nextDouble();
        	double viaToFinal = input.nextDouble();
        	double time1 = input.nextDouble();
        	double time2 = input.nextDouble();
        	double totalDistance = fromToVia + viaToFinal;
        	double totalTime = time1 + time2;
        	System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km and the Total Time taken is " + totalTime + " minutes");
	}

	//Total income

	public static void Q26(){
		Scanner input = new Scanner(System.in);
        	double salary = input.nextDouble();
        	double bonus = input.nextDouble();
        	double income = salary + bonus;
        	System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus + ". Hence Total Income is INR " + income);
	}

	//Fahrenheit to Celsius

	public static void Q27(){
		Scanner input = new Scanner(System.in);
        	double fahrenheit = input.nextDouble();
        	double celsius = (fahrenheit - 32) * 5 / 9;
        	System.out.println("The " + fahrenheit + " fahrenheit is " + celsius + " celsius");
	}

	//Simple interest

	public static void Q28(){
		Scanner input = new Scanner(System.in);
        	double principal = input.nextDouble();
        	double rate = input.nextDouble();
        	double time = input.nextDouble();
        	double si = (principal * rate * time) / 100;
        	System.out.println("The Simple Interest is " + si + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
	}



}