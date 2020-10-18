package mutileThread.part1.other.login;

public class Blogin extends Thread {
	
	@Override
	public void run() {
		LoginServlet.dopost("b", "bb");
	}
	

}
