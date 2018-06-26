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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.DataFile;
import jsp.common.MyFileRenamePolicy;
import jsp.member.model.vo.MemberVo;
@SuppressWarnings("all")
/**
 * Servlet implementation class AdminBoardResistServlet
 */
@WebServlet(name = "AdminBoardResist", urlPatterns = { "/adminBoardResist" })
public class AdminBoardResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		HttpSession session = request.getSession(false);
		if(session != null &&((MemberVo)session.getAttribute("member"))!=null&& ((MemberVo)session.getAttribute("member")).getMbId().equals("thepension")) {

		if (isMultipart) {  

			String uploadFilePath = getServletContext().getRealPath("/") + "Image" + "\\" + "noticeFileUpload";                 //톰켓의 전체 경로를 가져오고 upload라는 폴더를 만들고 거기다
			
			File temporaryDir = new File(uploadFilePath);                                                 //업로드 된 파일의 임시 저장 폴더를 설정

			DiskFileItemFactory factory = new DiskFileItemFactory();                                   
			factory.setSizeThreshold(1 * 1024 * 1024);                  //1메가가 넘지 않으면 메모리에서 바로 사용
			factory.setRepository(temporaryDir);                        //1메가 이상이면 temporaryDir 경로 폴더로 이동
			//실제 구현단계 아님 설정단계였음
			ServletFileUpload upload = new ServletFileUpload(factory);                               
			upload.setSizeMax(10 * 1024 * 1024);                        //최대 파일 크기(10M)
			ArrayList<FileItem> items =null;
			
			ArrayList<DataFile> fileList = new ArrayList<DataFile>();
			// 파일
			BoardVo bv = new BoardVo();
			
			BoardTotalInfoVo btlv = null;
			bv.setBdWriter(((MemberVo)session.getAttribute("member")).getMbId());
			bv.setBdCategory("공지사항");
			
			try {
				items = (ArrayList<FileItem>) upload.parseRequest(request);
				Iterator iter=items.iterator();                                                                            //Iterator 사용
				while(iter.hasNext()){
					FileItem fileItem = (FileItem) iter.next();                                                            //파일을 가져온다
						// 파라미터
					if(fileItem.isFormField()){                                                                               //업로드도니 파일이 text형태인지 다른 형태인지 체크
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						switch (key) {
						case "bdName":
							bv.setBdName(value);
							break;
						case "bdcontents" :
							bv.setBdContents(value);
							break;
						}	
					}else{   
						//파일이면 이부분의 루틴을 탄다
						if(fileItem.getSize()>0){                                                                                 //파일이 업로드 되었나 안되었나 체크 size>0이면 업로드 성공
							String fieldName=fileItem.getFieldName();
							String fileName=fileItem.getName();
							String contentType=fileItem.getContentType();
							boolean isInMemory=fileItem.isInMemory();
							long sizeInBytes=fileItem.getSize();

							// 파일 명명 규칙 - > cos와는 다르다
							MyFileRenamePolicy dfr  = new MyFileRenamePolicy();
							
							fileName = dfr.reFilename(fileName);
							
							DataFile df = new DataFile();
							df.setBdFileName(fileName);
							df.setBdFileWriter(((MemberVo)session.getAttribute("member")).getMbId());
							df.setBdFilePath("/Image/noticeFileUpload/" + fileName);
							df.setBdFileSize(sizeInBytes);

							fileList.add(df);

							File uploadedFile=new File(uploadFilePath,fileName);  //실제 디렉토리에 fileName으로 카피 된다.
							fileItem.write(uploadedFile);
							fileItem.delete();                                     //카피 완료후 temp폴더의 temp파일을 제거

						}
					}
				}
				// 비즈니스 로직 시작
				btlv = new BoardTotalInfoVo(bv, fileList);

				boolean result = new AdminService().boardInsert(btlv);

				
				response.sendRedirect("/adminBoardList");
				
				
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
		
		}else {
			// 관리자로 로그인을 하지 않았을 때...
			response.sendRedirect("/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
