package mutileThread.part1.other.login;

public class LoginServlet {
	private static String usernameREF;
	private static String passwordREF;
	
	 public synchronized static void dopost(String username,String password){
		try {
			usernameREF = username;
			System.out.println("获取线程名字=" +Thread.currentThread().getName() + "username=" + username );
			if(username.equals("a")){
				Thread.sleep(5000);
			}
			passwordREF = password;
			System.out.println("username=" + usernameREF + "   " + "password=" + passwordREF+"虎丘编程名字"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
