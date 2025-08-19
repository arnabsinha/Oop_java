class CallByRef1 {
	public static void main(String args[]){
		Test ob = new Test(15,20);

		Test ob1 = new Test();

		System.out.println("ob.a and ob.b before call : " + ob.a + " " + ob.b);

		ob.meth(ob);

		System.out.println("ob.a and ob.b after call : " + ob.a + " " + ob.b);

	}
}
class Test {
	int a, b;

	Test(){
		System.out.println("The object is getting instantiated from no parameter");

	}

	Test(int i, int j){
		System.out.println("The object is getting instantiated");
		a = i;
		b = j;
	}

	void meth(Test o){
		o.a *= 2;
		o.b /= 2;
	}
}

