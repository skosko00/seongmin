package kh.java.pay.run;

import kh.java.pay.controller.PayMgr;
import kh.java.pay.model.vo.Intern;
import kh.java.pay.model.vo.PartTime;
import kh.java.pay.model.vo.Permanent;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayMgr p = new PayMgr();
		p.insertData(new Permanent("È«±æµ¿","Á¤±ÔÁ÷",2000000));
		p.insertData(new PartTime("±è¸»¶Ë","½Ã°£Á÷",6000,120));
		p.insertData(new Intern("±èÀÎÅÏ","ÀÎÅÏÁ÷",2000000));
		p.showData();
	}

}
