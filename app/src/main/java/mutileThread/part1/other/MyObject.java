package mutileThread.part1.other;

//suspend��resume������ȱ��--���ݲ�ͬ��
public class MyObject {

	private String username = "a";
	private String password = "aa";
	
	public void setUsernameAndPassword(String username,String password){
		this.username = username;
		if(Thread.currentThread().getName().equals("a")){
			Thread.currentThread().suspend();//�� �̵߳�������a�Ļ����ͽ����if��䣬Ȼ����ͣ
		}
		this.password = password;
	}
	
	public void print(){
		System.out.println(username + password);
		
	}
	
}
