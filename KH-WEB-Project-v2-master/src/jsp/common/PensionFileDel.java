package jsp.common;

import java.io.File;
import java.util.ArrayList;

import jsp.board.model.vo.DataFile;
import jsp.main.model.vo.PensionPicTb;

public class PensionFileDel {
	// 펜션 파일 삭제
	public PensionFileDel() {
		// TODO Auto-generated constructor stub
	}

	public boolean boardFileListDel(ArrayList<DataFile> list,String path) {
		boolean result = true;
		
		for(DataFile df : list) {
			/*System.out.println("-----");
			System.out.println("df file path : " + df.getBdFilePath());
			System.out.println("df path : " + path);*/
			File file = new File(path+df.getBdFilePath());
			if(!file.delete()){
				result = false;
			}else {
				System.out.println("파일 삭제 완료!");
			}
		}
		return result;
	}
	
	public boolean roomFileListDel(ArrayList<PensionPicTb> list,String path) {
		boolean result = true;
		
		for(PensionPicTb pt : list) {
			File file = new File(path+pt.getPsPicPath());
			if(!file.delete()){
				result = false;
			}else {
				
			}
		}
		return result;
	}
	

}
