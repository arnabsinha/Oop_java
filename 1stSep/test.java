class Gen<T> {

	T ob;

	Gen(T o){
		ob = o;
	}

	T getob(){
		return ob;
	}

	void showType(){
		System.out.println("Type of T is: " + ob.getClass().getName());
	}

}

class test{
	public static void main(String args[]){
		Gen<Integer> iOb;
		iOb = new Gen<Integer>(88);

		int v = iOb.getob();
		System.out.println("value: "+ v);
		iOb.showType();

		Gen<String> strOb = new Gen<String>("Test of generic");
		strOb.showType();

		String str = strOb.getob();
		System.out.println("value: " + str);
	}
}
