//Write a Program to compute the volume of Earth in km^3 and miles^3

class Q1{
	public static void main(String[] args){
		int radius=6378;
		double VoE=(4/3)*3.14*Math.pow(radius,3);
		double miles=VoE*0.621371;
		System.out.print("The volume of earth in cubic kilometers is "+ VoE +" and cubic miles is "+miles);
	}
}