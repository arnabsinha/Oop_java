class clicker implements Runnable{
	long click = 0;
	Thread t;
	private volatile boolean running = true;

	public clicker(int p){
		t = new Thread(this);
		t.setPriority(p);
	}

	public void run(){
		while(running){
			click++;
			try{
				t.sleep(10);
			}
			catch(InterruptedException e){
				System.out.println("thread interrupted");
			}
		}
	}

	public void stop(){
		running = false;
	}

	public void startClickerObj(){
		t.start();
	}

}

class test{
	public static void main(String args[]){

		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		clicker hi = new clicker(Thread.NORM_PRIORITY + 4);
		clicker lo = new clicker(Thread.MIN_PRIORITY);

		lo.startClickerObj();
		hi.startClickerObj();
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println("Main thread interrupted");
		}

		lo.stop();
		hi.stop();

		try{
			lo.t.join();
			hi.t.join();
		}
		catch(InterruptedException e){
			System.out.println("InterruptedException caught");
		}

		System.out.println("Low-priority thread: " + lo.click);
		System.out.println("High-priority thread: " + hi.click);

	}
}

