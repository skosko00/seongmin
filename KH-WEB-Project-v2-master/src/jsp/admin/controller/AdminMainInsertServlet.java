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

import jsp.admin.model.service.AdminService;
import jsp.common.MyFileRenamePolicy;
import jsp.main.model.vo.MainPicTb;

/**
 * Servlet implementation class AdminMainInsertServlet
 */
@WebServlet(name = "AdminMainInsert", urlPatterns = { "/adminMainInsert" })
@SuppressWarnings("all")
public class AdminMainInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			// multipart로 전송 되었을 경우
			String uploadFilePath = getServletContext().getRealPath("/")+"Image"+"\\"+"main";
			
			File TemporaryDir = new File(uploadFilePath);
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1 * 1024 * 1024); //1메가가 넘지 않으면 메모리에서 바로 사용
			factory.setRepository(TemporaryDir); // 1메가 이상이면 TemporaryDir 경로 폴더로 이동
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10 * 1024 * 1024);
			ArrayList<FileItem> items = null;
			
			ArrayList<MainPicTb> mptlist = new ArrayList<MainPicTb>();
			
			try {
				items = (ArrayList<FileItem>)upload.parseRequest(request);
				Iterator iter = items.iterator();
				while(iter.hasNext())
				{
					FileItem fileItem = (FileItem)iter.next();
					if(fileItem.getSize()>0) {
						String fileName=fileItem.getName();
						String contentType=fileItem.getContentType();
						boolean isInMemory=fileItem.isInMemory();
						long sizeInBytes=fileItem.getSize();
						
						//String fileName = multi.getFilesystemName(fileValue); // 파일명
						// 파일 명명 규칙 - > cos와는 다르다
						MyFileRenamePolicy dfr  = new MyFileRenamePolicy();
						
						fileName = dfr.reFilename(fileName);
						
						MainPicTb mpt = new MainPicTb();
						
						mpt.setMainPicPath("/Image/main/"+fileName);
						
						mptlist.add(mpt);
						
						File uploadedFile = new File(uploadFilePath,fileName); //실제 디렉토리에 fileName으로 카피 된다.
						fileItem.write(uploadedFile);
						fileItem.delete(); //카피 완료후 temp폴더의 temp파일을 제거
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int result = new AdminService().mainInsert(mptlist);
			
			if(result>0)
			{
				response.sendRedirect("/adminTemplateManager");
			}else
			{
				response.sendRedirect("/View/error/error.jsp");
			}
			
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
