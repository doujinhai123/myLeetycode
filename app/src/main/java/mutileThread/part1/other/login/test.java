package mutileThread.part1.other.login;

public class test {
	public static void main(String[] args)  {

		Blogin blogin = new Blogin();
		blogin.setName("bbbb");
		blogin.start();
		Alogin alogin = new Alogin();
		alogin.start();
		alogin.setName("aaa");
	}
}
