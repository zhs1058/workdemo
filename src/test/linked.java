package test;

public class linked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Scanner input=new Scanner(System.in);
        // String str=input.next();
        Linked head = new Linked();
        Linked h1 = head;
        for(int i = 0; i < 10; i ++){
            Linked l = new Linked();
            l.value = i;
            head.next = l;
            head = l;
        }
        int l = 3;
        int r = 7;
        int i = 1;
        Linked newHead = new Linked();
        while(h1.next != null){
            if(i >= l && i <= r){
            	int j = 1;
            	Linked tempHead = h1;
                while(h1.next != null) {
                	if(j == r) {
                		Linked temp = new Linked();
                		temp = h1;
                		
                	}
                	j ++;
                	head = head.next;
                }
                
            }
            h1 = h1.next;
        }

        System.out.println("hello world");
    }

}

class Linked {
    int value;
    Linked next;
}
