package kh.java.point.run;

import kh.java.point.controller.PntMgr;
import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Silver;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PntMgr mgr = new PntMgr();
		mgr.insertData(new Silver("»´±Êµø","Silver",1000));
		mgr.insertData(new Silver("±Ë∏ª∂À","Silver",2000));
		mgr.insertData(new Silver("∂À∂À¿Ã","Silver",3000));
		mgr.insertData(new Gold("±Ë∫Œ¿Â","Gold",2000));
		mgr.insertData(new Gold("√÷∫Œ¿Â","Gold",3000));
		mgr.printData();
	}

}
