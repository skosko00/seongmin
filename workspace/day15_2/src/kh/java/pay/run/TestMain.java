package kh.java.pay.run;

import kh.java.pay.controller.PayMgr;
import kh.java.pay.model.vo.Intern;
import kh.java.pay.model.vo.PartTime;
import kh.java.pay.model.vo.Permanent;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayMgr p = new PayMgr();
		p.insertData(new Permanent("ȫ�浿","������",2000000));
		p.insertData(new PartTime("�踻��","�ð���",6000,120));
		p.insertData(new Intern("������","������",2000000));
		p.showData();
	}

}
