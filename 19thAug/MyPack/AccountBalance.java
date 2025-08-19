import TestPack.Balance;

class AccountBalance {
	public static void main(String args[]){
		Balance current[] = new Balance[3];
		current[0] = new Balance("A. Dhar", 1000.0);
		current[1] = new Balance("B. Goswami", 2000.0);
		current[2] = new Balance("C. Jamal", -40.2);

		for(int i=0;i<3;i++)
			current[i].show();

		current[0].changeBal(100);
		current[0].show();
	}
}
