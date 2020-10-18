package mutileThread.part1.other.synchronizedObject;

/*
 * ���ǲ���ʹ��stop()�����ͷ���������Ӱ��
 */
public class SynchronizedObject {

	private String username = "a";
	private String password = "aa";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//��һ�ݼ����ķ�������
	synchronized public void printString(String username,String password){
		try {
			this.username = username;
			Thread.sleep(1000);
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
