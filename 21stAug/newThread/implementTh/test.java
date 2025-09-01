

class NewThread implements Runnable{
	Thread t;
	String name;

	NewThread(){
		//super("Demo Thread");
		t = new Thread(this, "Demo Thread");
		//System.out.println("Created a new child thread : " + this);
		System.out.println("Created a new child thread : " + t);
		//start();
		t.start();
	}

	NewThread(String name){
		//super(name);
		t = new Thread(this, name);
		this.name = name;
		//System.out.println("Created a new child thread : " + this);
		System.out.println("Created a new child thread : " + t);
		//start();
		t.start();
	}

	boolean isAlive(){
		return t.isAlive();
	}
	
	public void start(){
		t.start();
	}
	public void join(){
		try{
			t.join();
		}
		catch(InterruptedException e){
			System.out.println("Child thread " + name +" is interupted.");
		}
	}

	public void run(){
		try {
			for(int i=0;i<5;i++){
				System.out.println("Child Thread (" + name + "): " + i);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e){
			System.out.println("Child thread " + name +" is interupted.");
		}
		System.out.println("Exiting child thread" + name);
	}
}

class test{
	public static void main(String args[]){
		
		NewThread[] nthArr = new NewThread[5];
		for (int i=0;i<5;i++){
			String name = "" + i;
			nthArr[i] = new NewThread(name);
			//nthArr[i].start();
			//nthArr[i].join();
		}
		
		//new NewThread();
		Thread t = Thread.currentThread();
		System.out.println("Current thread : " + t);
		t.setName("Main thread");
		System.out.println("Current thread (after changing name) : " + t);
		try {
			for (int i=0;i<5;i++){
				System.out.println("Main thread : " + i);
				//Thread.sleep(1000);
				t.sleep(1000); 	//// (EXP)
			}
		}
		catch (InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread is exiting");
		
		for(int i=0;i<5;i++)
			nthArr[i].join();
			
		
		System.out.println("Is main thread alive ? " + t.isAlive());	//// (EXP)
		for(int i=0;i<5;i++)
			System.out.println("Is child thread alive ? " + nthArr[i].isAlive());	//// (EXP)
	}
}
