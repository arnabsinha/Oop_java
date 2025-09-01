class NonGen{
	Object ob;

	NonGen(Object o){
		ob = o;
	}

	Object getob(){
		return ob;
	}

	void showType(){
		System.out.println("Type of ob is: " + ob.getClass().getName());
	}

}

class testnongen{
	public static void main(String args[]){
		NonGen iOb;
		iOb = new NonGen(88);
		iOb.showType();

		int v = (Integer) iOb.getob();
		System.out.println("value: "+ v);

		NonGen strOb = new NonGen("non-generic one");
		strOb.showType();

		String str = (String) strOb.getob();
		System.out.println("value: " + str);

		iOb = strOb;
		v = (Integer) iOb.getob();
	}
}
