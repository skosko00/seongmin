package jsp.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jsp.admin.model.vo.MemberLoginLogVo;
import jsp.member.model.vo.MemberVo;
import jsp.reservation.model.vo.ReservationVo;

public class PensionExcelWriter {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	public PensionExcelWriter() {
		
	}

	// 회원 리스트 출력
	public boolean memberListWriter(ArrayList<MemberVo> list ,String path) {
		boolean result = false;
		if(list != null && !list.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			XSSFSheet sheet = workbook.createSheet();
			// 행 생성
			XSSFRow row = sheet.createRow(0);
			// 쎌 생성
			XSSFCell cell;

			// 헤더 정보 구성
			cell = row.createCell(0);
			cell.setCellValue("아이디");

			cell = row.createCell(1);
			cell.setCellValue("비밀번호");

			cell = row.createCell(2);
			cell.setCellValue("생년월일");
			
			

			cell = row.createCell(3);
			cell.setCellValue("이메일");
			
			cell = row.createCell(4);
			cell.setCellValue("휴대폰번호");
			
			cell = row.createCell(5);
			cell.setCellValue("성별");
			
			cell = row.createCell(6);
			cell.setCellValue("이름");
			
			cell = row.createCell(7);
			cell.setCellValue("가입일");
			
			cell = row.createCell(8);
			cell.setCellValue("주소");

			// 리스트의 size 만큼 row를 생성
			
			for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
				MemberVo vo = list.get(rowIdx);

				// 행 생성 -> 리스트 사이즈 +1 
				row = sheet.createRow(rowIdx+1);

				cell = row.createCell(0);
				cell.setCellValue(vo.getMbId());

				cell = row.createCell(1);
				cell.setCellValue(vo.getMbPwd());

				cell = row.createCell(2);;
				
				cell.setCellValue(formatter.format(vo.getMbBirth()));
				
				cell = row.createCell(3);
				cell.setCellValue(vo.getMbEmail());
				
				cell = row.createCell(4);
				cell.setCellValue(vo.getMbPhone());
				
				cell = row.createCell(5);
				cell.setCellValue(vo.getMbGender());
				
				cell = row.createCell(6);
				cell.setCellValue(vo.getMbName());
				
				cell = row.createCell(7);
				cell.setCellValue(formatter.format(vo.getMbEntDate()));
				
				cell = row.createCell(8);
				cell.setCellValue(vo.getMbAddress());

			}

			// 입력된 내용 파일로 쓰기
			//File file = new File("C:\\Users\\snugs\\git\\KH-WEB-Project-v2/test.xlsx");
			
			FileOutputStream fos = null;

			try {
				fos = new FileOutputStream(path);
				workbook.write(fos);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(workbook!=null) workbook.close();
					if(fos!=null) fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result = true;
		}else {
			// 리스트 없으면 false;
		}

		return result;
	}

	public boolean memberLogListWriter(ArrayList<MemberLoginLogVo> list, String path) {
		boolean result = false;
		if(list != null && !list.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 워크시트 생성
			XSSFSheet sheet = workbook.createSheet();
			// 행 생성
			XSSFRow row = sheet.createRow(0);
			// 쎌 생성
			XSSFCell cell;

			// 헤더 정보 구성
			cell = row.createCell(0);
			cell.setCellValue("아이디");

			cell = row.createCell(1);
			cell.setCellValue("접속 시간");

			cell = row.createCell(2);
			cell.setCellValue("접속 브라우저");

			cell = row.createCell(3);
			cell.setCellValue("접속 아이피");
			
			cell = row.createCell(4);
			cell.setCellValue("접속 국가");

			// 리스트의 size 만큼 row를 생성
			
			for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
				MemberLoginLogVo vo = list.get(rowIdx);

				// 행 생성 -> 리스트 사이즈 +1 
				row = sheet.createRow(rowIdx+1);

				cell = row.createCell(0);
				cell.setCellValue(vo.getMbLogId());

				cell = row.createCell(1);
				cell.setCellValue(formatter.format(vo.getMbLogTime()));
				
				cell = row.createCell(2);
				cell.setCellValue(vo.getMbLogBrowser());

				cell = row.createCell(3);
				cell.setCellValue(vo.getMbLogIp());
				
				cell = row.createCell(4);
				cell.setCellValue(vo.getMbLogLocale());

			}

			// 입력된 내용 파일로 쓰기
			//File file = new File("C:\\Users\\snugs\\git\\KH-WEB-Project-v2/test.xlsx");
			
			FileOutputStream fos = null;

			try {
				fos = new FileOutputStream(path);
				workbook.write(fos);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(workbook!=null) workbook.close();
					if(fos!=null) fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result = true;
		}else {
			// 리스트 없으면 false;
		}

		return result;
	}
	// 예약 정보 엑셀 다운 
	public boolean reservationLogListWriter(ArrayList<ReservationVo> list, String path) {
		boolean result = false;
		if(list != null && !list.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 워크시트 생성
			XSSFSheet sheet = workbook.createSheet();
			// 행 생성
			XSSFRow row = sheet.createRow(0);
			// 쎌 생성
			XSSFCell cell;

			// 헤더 정보 구성
			cell = row.createCell(0);
			cell.setCellValue("예약 번호");

			cell = row.createCell(1);
			cell.setCellValue("객실 명");

			cell = row.createCell(2);
			cell.setCellValue("아이디");

			cell = row.createCell(3);
			cell.setCellValue("숙박 인원");
			
			cell = row.createCell(4);
			cell.setCellValue("예약 날짜");
			
			cell = row.createCell(5);
			cell.setCellValue("입실일");
			
			cell = row.createCell(6);
			cell.setCellValue("퇴실 일");
			
			cell = row.createCell(7);
			cell.setCellValue("숙박 기간");
			
			cell = row.createCell(8);
			cell.setCellValue("비용");
			
			cell = row.createCell(9);
			cell.setCellValue("결제 날짜");

			// 리스트의 size 만큼 row를 생성
			
			for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
				ReservationVo vo = list.get(rowIdx);

				// 행 생성 -> 리스트 사이즈 +1 
				row = sheet.createRow(rowIdx+1);

				cell = row.createCell(0);
				cell.setCellValue(vo.getResNo());

				cell = row.createCell(1);
				cell.setCellValue(vo.getResRoomName());

				cell = row.createCell(2);
				cell.setCellValue(vo.getResId());

				cell = row.createCell(3);
				cell.setCellValue(vo.getResPersonnel());
				
				cell = row.createCell(4);
				cell.setCellValue(formatter.format(vo.getResReservationDate()));
				
				cell = row.createCell(5);
				cell.setCellValue(formatter.format(vo.getResInDate()));
				
				cell = row.createCell(6);
				cell.setCellValue(formatter.format(vo.getResOutDate()));
				
				cell = row.createCell(7);
				cell.setCellValue(vo.getResPeriod());
				
				cell = row.createCell(8);
				cell.setCellValue(vo.getResPrice());
				
				cell = row.createCell(9);
				cell.setCellValue(formatter.format(vo.getResPaymentDate()));

			}

			// 입력된 내용 파일로 쓰기
			//File file = new File("C:\\Users\\snugs\\git\\KH-WEB-Project-v2/test.xlsx");
			
			FileOutputStream fos = null;

			try {
				fos = new FileOutputStream(path);
				workbook.write(fos);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(workbook!=null) workbook.close();
					if(fos!=null) fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result = true;
		}else {
			// 리스트 없으면 false;
		}

		return result;
	}

}
