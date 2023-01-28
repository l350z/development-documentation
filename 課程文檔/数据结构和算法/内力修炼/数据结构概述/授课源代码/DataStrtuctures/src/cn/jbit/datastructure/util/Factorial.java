package cn.jbit.datastructure.util;

public class Factorial {
	public static int factorial1(int n){
		int value=1;
		while(n>0){
			value*=n--;
		}
		return value;
	}

	public static int factorial(int n){
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	
	public static int F(int n){ //递归求Fibonacci数列的第N项
		if(n==0 || n==1)
			return 1;
		else
			return F(n-1)+F(n-2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(F(3));

	}

}
