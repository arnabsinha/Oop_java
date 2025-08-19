class Exc{
	public static void main(String args[]){
		int d, a;

		try{
			d = 0;
			a = 42/d;
			System.out.println("Will it be printed ?");
		}
		catch(ArithmeticException e){
			System.out.println(e);
		}
		System.out.println("Well .... does it work !!!");
	}
}
