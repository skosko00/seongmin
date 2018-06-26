package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.main.model.vo.PensionPicTb;
import jsp.reservation.model.vo.PensionVo;

public class RoomTotalInfoVo {
	private PensionVo pv ;
	private ArrayList<PensionPicTb> list ;
	public PensionVo getPv() {
		return pv;
	}
	public void setPv(PensionVo pv) {
		this.pv = pv;
	}
	public ArrayList<PensionPicTb> getList() {
		return list;
	}
	public void setList(ArrayList<PensionPicTb> list) {
		this.list = list;
	}
	public RoomTotalInfoVo(PensionVo pv, ArrayList<PensionPicTb> list) {
		super();
		this.pv = pv;
		this.list = list;
	}
	public RoomTotalInfoVo() {
		super();
	}
	@Override
	public String toString() {
		return "RoomTotalInfoVo [pv=" + pv.toString() + ", list=" + list.toString() + "]";
	} 
}

