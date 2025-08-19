class Fibonacci{
	public static void main(String args[]){
		fibo f = new fibo();
		System.out.println("Fibonacci for 5: ");
		f.fibonacci(5);
		System.out.println("******************\n0\n1");
		f.fibonacci_recr(0, 1, 5);
	}
}

class fibo{

	void fibonacci(int k){
		int a = 0;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		for (int i=0;i<=k;i++){
			int t = b;
			b = a + b;
			System.out.println(b);
			a = t;
		}
	}

	void fibonacci_recr(int a, int b, int k){
		int t = b;
		b = a + b;
		System.out.println(b);
		a = t;
		k = k - 1;
		if(k>=0){
			fibonacci_recr(a, b, k);
		}
	}
}
