package ClassInit;

public class Hello$1 extends Thread {
	
	private String val$str;
	
	Hello$1(String paramString) {
		this.val$str = paramString;
	}
 
	public void run() {
		System.out.println(this.val$str);
	}
 
}