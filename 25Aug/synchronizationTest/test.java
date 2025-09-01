


class counter{
	private int count = 0;

	public void increment(){
		count ++;
	}

	public int getCount(){
		return count;
	}
}

class newThread extends Thread{

	private counter cObj;

	newThread(counter cObj){
		this.cObj = cObj;
	}

	public void run(){
		for(int i=0;i<1000;i++)
			cObj.increment();
	}

}

class test{

	public static void main(String args[]){
		
		counter cObj = new counter();

		newThread t1 = new newThread(cObj);
		newThread t2 = new newThread(cObj);

		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}
		catch (InterruptedException e){
		}

		System.out.println("The number of count  : " + cObj.getCount());

	}
}
