package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File oldFile) {
		// 업로드된 파일명을 변경하는 로직
		// ex) 파일명.txt 라고 되어 있다면
		// 시간_랜덤수.txt 로 변경 하도록 할 것임
		// ex) a.txt -> 20180531_1155428985_98483.txt
		
		// 1. 시간값을 가져옴
		long currentTimeValue = Calendar.getInstance().getTimeInMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String currentTime = sdf.format(new Date(currentTimeValue));
		// java.util.*에서 가져옴
		
		// 2. 랜덤 수를 가져옴
		int randomSu = new Random().nextInt(100000);
		
		// 3. 확장자명 추출
		String oldFileName = oldFile.getName(); //기존 파일명
		String ext = null; // 현재 확장자명은 없음
		int dot = oldFileName.lastIndexOf(".");
		// lastIndexOf 메소드는 찾으면 index값(위치) 리턴
		// 못 찾았다면(없다면) -1을 리턴
		
		if(dot>-1)
		{
			ext = oldFileName.substring(dot); // 확장자가 있다면 확장자명만 잘라서 가져옴
		}else {
			ext = ""; //확장자가 없다면
		}
		
		// 4. 위의 정보를 바탕으로 새로운 파일명을 생성
		String newFileNmae = currentTime+"_"+randomSu+ext;
		
		// 5. 원본 파일이 저장되는 디렉토리에 새로운 이름으로 파일 객체를 생성
		File newFile = new File(oldFile.getParent(),newFileNmae);
		
		// 6. 새로운 파일정보로 File 객체를 리턴
		return newFile;
	}
	
}
