package mutileThread.part1.other.login;

public class Alogin extends Thread {
	
	@Override
	public void run() {
		LoginServlet.dopost("a", "aa");
	}

}	
