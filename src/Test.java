import java.io.*;

public class Test {
	public static void main(String[] args) {
		try(BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\Кокон2\\Desktop\\test.txt"))){
			String output = "";
			
			while(fr.ready())
				output += (char)fr.read();
			System.out.println(output);
		} catch (FileNotFoundException e) {
			System.out.println(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
