package jsp.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.RoomTotalInfoVo;
import jsp.common.MyFileRenamePolicy;
import jsp.main.model.vo.PensionPicTb;
import jsp.reservation.model.vo.PensionVo;

/**
 * Servlet implementation class AdminRoomManagerServlet
 */
@SuppressWarnings("all")
@WebServlet(name = "AdminRoomInsert", urlPatterns = { "/adminRoomInsert" })
public class AdminRoomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRoomInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 1. 객실 정보들을 불러오는 페이지...
	// 2. 페이지를 불러올 필요는 없을 것이다. (객실이 많지는 않을 것 )
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {  
			// multipart로 전송 되었을 경우
			String uploadFilePath = getServletContext().getRealPath("/") + "Image" + "\\" + "room";                 //톰켓의 전체 경로를 가져오고 upload라는 폴더를 만들고 거기다
			
			File temporaryDir = new File(uploadFilePath);                                                 //업로드 된 파일의 임시 저장 폴더를 설정
			//tmp의 폴더의 전송된 파일을 upload 폴더로 카피 한다.
			
			
			DiskFileItemFactory factory = new DiskFileItemFactory();                                   
			factory.setSizeThreshold(1 * 1024 * 1024);                  //1메가가 넘지 않으면 메모리에서 바로 사용
			factory.setRepository(temporaryDir);                        //1메가 이상이면 temporaryDir 경로 폴더로 이동
			//실제 구현단계 아님 설정단계였음
			ServletFileUpload upload = new ServletFileUpload(factory);                               
			upload.setSizeMax(10 * 1024 * 1024);                        //최대 파일 크기(10M)
			ArrayList<FileItem> items =null;
			
			PensionVo pv = new PensionVo();
			ArrayList<PensionPicTb> picList = new ArrayList<PensionPicTb>();
			RoomTotalInfoVo ptlv = null;
			String yn = "N";
	
			try {
				items = (ArrayList<FileItem>) upload.parseRequest(request);
				Iterator iter=items.iterator();                                                                            //Iterator 사용
				while(iter.hasNext()){
					FileItem fileItem = (FileItem) iter.next();                                                            //파일을 가져온다
					// 
					if(fileItem.isFormField()){                                                                               //업로드도니 파일이 text형태인지 다른 형태인지 체크
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						switch (key) {
						case "PS_Weekday":
							pv.setPsWeekday(Integer.parseInt(value));
							break;
						case "PS_MaxPerson":
							pv.setPsMaxPersonnel(Integer.parseInt(value));
							break;
						case "PS_Name":
							pv.setPsName(value);
							break;
						case "PS_Contents":
							pv.setPsContents(value);
							break;
						case "PS_Addition_Price":
							pv.setPsAddtionalPrice(Integer.parseInt(value));
							break;
						case "PS_Person":
							pv.setPsPersonnel(Integer.parseInt(value));
							break;
						case "PS_Weekend":
							pv.setPsWeekend(Integer.parseInt(value));
							break;
						}
						
					}else{                                                                                                         //파일이면 이부분의 루틴을 탄다
						if(fileItem.getSize()>0){                                                                                 //파일이 업로드 되었나 안되었나 체크 size>0이면 업로드 성공
							String fieldName=fileItem.getFieldName();
							String fileName=fileItem.getName();
							String contentType=fileItem.getContentType();
							boolean isInMemory=fileItem.isInMemory();
							long sizeInBytes=fileItem.getSize();

							//String fileValue = (String) formNames.nextElement();
	
							if (fieldName.equals("input_main")) {
								yn = "Y";
							} else {
								yn = "N";
							}
							
							//String fileName = multi.getFilesystemName(fileValue); // 파일명
							// 파일 명명 규칙 - > cos와는 다르다
							MyFileRenamePolicy dfr  = new MyFileRenamePolicy();
							
							fileName = dfr.reFilename(fileName);
							
							PensionPicTb piv = new PensionPicTb(pv.getPsName(), "/Image/room/" + fileName, yn);

							picList.add(piv);

	

							File uploadedFile=new File(uploadFilePath,fileName);  //실제 디렉토리에 fileName으로 카피 된다.
							fileItem.write(uploadedFile);
							fileItem.delete();                                     //카피 완료후 temp폴더의 temp파일을 제거

						}
					}
				}
				// 비즈니스 로직 시작
				ptlv = new RoomTotalInfoVo(pv, picList);

				boolean result = new AdminService().roomInsert(ptlv);

				if (result) {
					response.sendRedirect("/adminRoomManager");
				} else {
					response.sendRedirect("/View/error/errorPage.jsp");
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//실제 업로드 부분(이부분에서 파일이 생성된다)
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}else{
			//System.out.println("인코딩 타입이 multipart/form-data 가 아님.");
		}
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
