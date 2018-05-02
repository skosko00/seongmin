package kh.java.point.run;

import kh.java.point.controller.PntMgr;
import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Silver;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PntMgr mgr = new PntMgr();
		mgr.insertData(new Silver("ȫ�浿","Silver",1000));
		mgr.insertData(new Silver("�踻��","Silver",2000));
		mgr.insertData(new Silver("�˶���","Silver",3000));
		mgr.insertData(new Gold("�����","Gold",2000));
		mgr.insertData(new Gold("�ֺ���","Gold",3000));
		mgr.printData();
	}

}
