package kh.java.point.run;

import kh.java.point.controller.Pntmgr;
import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Silver;
import kh.java.point.model.vo.Vip;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pntmgr mgr = new Pntmgr();
		
		mgr.inserData(new Silver("ȫ�浿","silver",1000));
		mgr.inserData(new Silver("�踻��","silver",2000));
		mgr.inserData(new Silver("�˶���","silver",3000));
		mgr.inserData(new Gold("�����","Gold",2000));
		mgr.inserData(new Gold("�ں���","Gold",3000));
		mgr.inserData(new Vip("�ֻ���","Vip",3000));
		mgr.printData();

	}

}
