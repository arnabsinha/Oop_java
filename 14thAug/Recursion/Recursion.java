class Factorial{
	int factor(int n){
		int result;
		if (n==1) return 1;
		result = factor(n-1) * n;
		return result;
	}

}

class Recursion{
	public static void main(String args[]){
		Factorial f = new Factorial();

		System.out.println("Factorial of 3 is : " + f.factor(3));
		System.out.println("Factorial of 5 is : " + f.factor(5));
		System.out.println("Factorial of 6 is : " + f.factor(6));
	}
}
