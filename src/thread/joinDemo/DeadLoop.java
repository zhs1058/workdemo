package thread.joinDemo;

public class DeadLoop {

	
	public static void main(String[] args) {
		String string = "abs";
		int i = 0;
		while(true) {
			string = string.concat("abs");
			i ++;
			
		}
	}
}
