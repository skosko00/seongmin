package kh.java.thread;
// �ð� �帣�� Ŭ���� (����)
public class TestClass implements Runnable{
	
	public static int second = 30;	//�ð� ��
	
	@Override
	public void run()
	{
		do {
			System.out.println(second-- +"��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(second!=0);
	}
}
