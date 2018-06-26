package jsp.board.controller;

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

import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.board.model.service.BoardService;
import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.DataFile;
import jsp.common.MyFileRenamePolicy;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class ReViewWriteServlet
 */
@WebServlet(name = "ReViewWrite", urlPatterns = { "/reViewWrite" })
@SuppressWarnings("all")
public class ReViewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReViewWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		HttpSession session = request.getSession(false);
		if (session != null && ((MemberVo) session.getAttribute("member")) != null) {

			if (isMultipart) {
				// multipart로 전송 되었을 경우
				String uploadFilePath = getServletContext().getRealPath("/") + "Image" + "\\" + "reViewFileUpload";

				File TemporaryDir = new File(uploadFilePath);

				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1 * 1024 * 1024); // 1메가가 넘지 않으면 메모리에서 바로 사용
				factory.setRepository(TemporaryDir); // 1메가 이상이면 TemporaryDir 경로 폴더사용

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024);
				ArrayList<FileItem> items = null;

				ArrayList<DataFile> fileList = new ArrayList<DataFile>();
				// 파일
				BoardVo bv = new BoardVo();

				BoardTotalInfoVo btlv = null;
				bv.setBdWriter(((MemberVo) session.getAttribute("member")).getMbId());
				bv.setBdCategory("후기");

				try {
					items = (ArrayList<FileItem>) upload.parseRequest(request);
					Iterator iter = items.iterator();
					while (iter.hasNext()) {
						FileItem fileItem = (FileItem) iter.next();
						// 파라미터
						if (fileItem.isFormField()) {
							String key = fileItem.getFieldName();
							String value = fileItem.getString("UTF-8");
							switch (key) {
							case "bd_Name":
								bv.setBdName(value);
								break;
							case "bd_Contents":
								bv.setBdContents(value);
								break;
							}
						} else {
							// 파일이면 루틴을 탄다
							if (fileItem.getSize() > 0) {
								String fieldName = fileItem.getFieldName();
								String fileName = fileItem.getName();
								String contentType = fileItem.getContentType();
								boolean isInMemory = fileItem.isInMemory();
								long sizeInBytes = fileItem.getSize();

								// 파일 명명 규칙 -> cos와는 다르다
								MyFileRenamePolicy dfr = new MyFileRenamePolicy();

								fileName = dfr.reFilename(fileName);

								DataFile df = new DataFile();
								df.setBdFileName(fileName);
								df.setBdFileWriter(((MemberVo) session.getAttribute("member")).getMbId());
								df.setBdFilePath("/Image/reViewFileUpload/" + fileName);
								df.setBdFileSize(sizeInBytes);

								fileList.add(df);

								File uploadedFile = new File(uploadFilePath, fileName); // 실제 디렉토리에 fileName으로 카피 된다.
								fileItem.write(uploadedFile);
								fileItem.delete(); // 카피 완료후 temp폴더의 temp파일을 제거
							}
						}
					}

					// 비즈니스 로직 시작
					btlv = new BoardTotalInfoVo(bv, fileList);

					boolean result = new BoardService().reViewInsert(btlv);

					response.sendRedirect("/review");

				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
