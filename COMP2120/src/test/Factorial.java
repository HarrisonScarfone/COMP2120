package test;

public class Factorial {

	public static int calc(int n) {
		if(n==0 || n==1) {
			return 1;
		}else {
			System.out.println(n);
			return n*calc(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(calc(5));
	}
	
}
