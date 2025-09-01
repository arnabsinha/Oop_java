

class NewThread extends Thread{
	String name;

	NewThread(){
		super("Demo Thread");
		System.out.println("Created a new child thread : " + this);
		start();
	}

	NewThread(String name1){
		super(name1);
		name = name1;
		System.out.println("Created a new child thread : " + this);
		start();
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
		
		for (int i=0;i<6;i++){
			String name = "thread " + i;
			NewThread nth = new NewThread(name);
		}
		
		//new NewThread();

		try {
			for (int i=0;i<5;i++){
				System.out.println("Main thread : " + i);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e){
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread is exiting");
	}
}
