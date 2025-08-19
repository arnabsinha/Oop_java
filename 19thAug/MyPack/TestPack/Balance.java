package TestPack;

public class Balance {
        String name;
        double bal;

        public Balance(String n, double b){
                name = n;
                bal = b;
        }

        public void show(){
                if (bal<0)
                        System.out.println("-->");
                System.out.println(name + ": $" + bal);
        }

	public void changeBal(double ch){
		incrementBalance(ch);
	}

	private void incrementBalance(double p){
		bal += p;
	}
}

