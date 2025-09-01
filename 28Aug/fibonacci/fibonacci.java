class fibonacci{

	public void print(int n){
		int a =0, b = 1;
		System.out.println(a + " " + b);
		for (int i=2;i<n+2;i++){
			int c = a + b;
			System.out.println(c);
			a = b;
			b = c;
		}
	}

	public static void main(String args[]){
		fibonacci obj = new fibonacci();
		obj.print(11);
		obj.print(12);
		obj.print(20);


	}
}
