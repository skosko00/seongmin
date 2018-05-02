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
		
		mgr.insertData(new Silver("È«±æµ¿","silver",1000));
		mgr.insertData(new Silver("±è¸»¶Ë","silver",2000));
		mgr.insertData(new Silver("¶Ë¶ËÀÌ","silver",3000));
		mgr.insertData(new Gold("±èºÎÀå","Gold",2000));
		mgr.insertData(new Gold("¹ÚºÎÀå","Gold",3000));
		mgr.insertData(new Vip("ÃÖ»çÀå","Vip",3000));
		mgr.insertData(new Vvip("Á¤È¸Àå","VVip",3000));
		
		mgr.printData();

	}

}
