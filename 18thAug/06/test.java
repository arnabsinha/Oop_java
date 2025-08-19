//import java.io.FileReader;
import java.io.*;

class test{
	public static void main(String args[]) {
		try {
		readFile("myFile.txt");
		}
		catch(){
		}
	}

	private static void readFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
	}
}
