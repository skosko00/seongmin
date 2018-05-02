package kh.java.point.run;

import kh.java.point.controller.Pntmgr;
import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Silver;
import kh.java.point.model.vo.Vip;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pntmgr mgr = new Pntmgr();
		
		mgr.inserData(new Silver("»´±Êµø","silver",1000));
		mgr.inserData(new Silver("±Ë∏ª∂À","silver",2000));
		mgr.inserData(new Silver("∂À∂À¿Ã","silver",3000));
		mgr.inserData(new Gold("±Ë∫Œ¿Â","Gold",2000));
		mgr.inserData(new Gold("π⁄∫Œ¿Â","Gold",3000));
		mgr.inserData(new Vip("√÷ªÁ¿Â","Vip",3000));
		mgr.printData();

	}

}
