package ClassInit;

public class Sta {
	public static long date=System.currentTimeMillis();//1
	public int da=1;//3,5
	static{
		System.out.println("Sta:"+System.currentTimeMillis());//2
	}
	public Sta(){
		System.out.println(System.currentTimeMillis());//4,6
	}
	 static class st{
		public static long date=System.currentTimeMillis();//8
	}
	public long getDate(){
		return st.date;//7,9
	}
	public static void main(String[] args) {
		Sta t=new Sta();
		Sta t1=new Sta();
		System.out.println(t.getDate());
		System.out.println(t1.getDate());
	}
}