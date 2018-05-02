package kh.java.thread;
// 시간 흐르는 클래스 (감소)
public class TestClass implements Runnable{
	
	public static int second = 30;	//시간 값
	
	@Override
	public void run()
	{
		do {
			System.out.println(second-- +"초");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(second!=0);
	}
}
