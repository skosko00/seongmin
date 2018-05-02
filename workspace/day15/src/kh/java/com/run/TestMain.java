package kh.java.com.run;

import kh.java.com.controller.Pntmgr;
import kh.java.com.model.vo.Gold;
import kh.java.com.model.vo.Silver;
import kh.java.com.model.vo.Vip;
import kh.java.com.model.vo.Vvip;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pntmgr mgr = new Pntmgr();
		
		mgr.insertData(new Silver("ȫ�浿","silver",1000));
		mgr.insertData(new Silver("�踻��","silver",2000));
		mgr.insertData(new Silver("�˶���","silver",3000));
		mgr.insertData(new Gold("�����","Gold",2000));
		mgr.insertData(new Gold("�ں���","Gold",3000));
		mgr.insertData(new Vip("�ֻ���","Vip",3000));
		mgr.insertData(new Vvip("��ȸ��","VVip",3000));
		
		mgr.printData();

	}

}
