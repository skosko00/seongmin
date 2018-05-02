package kh.java.thread;

public class Table {
	public void dataPrint(int n)
	{
		System.out.println("dataPrint 메소드가 호출 되었습니다.");
		
		synchronized (this) {
			for(int i=1; i<9;i++)
			{
				System.out.println(n+"x"+i+"="+(n*i));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}

