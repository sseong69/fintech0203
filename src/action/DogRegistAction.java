package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import svc.DogRegistService;
import vo.ActionForward;
import vo.Dog;

public class DogRegistAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//파일을 서버에 업로드후 파일의 정보를 데이터베이스에 저장하는 비지니스 로직 구현
		DogRegistService dogRegistService = new DogRegistService();
		String realFolder = ""; //파일 업로드될 서버 상의 물리적인 경로
		
		
		//String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024; //한번에 업로드 할 수 있는 파일의 크기
		
		
//		ServletContext context = request.getServletContext();
//		realFolder = context.getRealPath(saveFolder);
		
		realFolder = "D:\\jspStudy\\DogShopping\\WebContent\\resources\\images";
		//업로드 관련 설정
		MultipartRequest multi = new MultipartRequest(request,//내장객체선언
								realFolder,//업로드되는 서버위치
								maxSize, // 업로드시 최대파일 크기
								encType, // 인코딩방식
								new DefaultFileRenamePolicy());// 업로드시 파일명 처리 정책 선언
		// 서버에 업로드된 실제 파일명 가져옴->getFilesystemName
		String image = multi.getFilesystemName("image");
		// Dog 인스턴스 생성
		Dog dog = new Dog(
							0, //아이디 값
							multi.getParameter("kind"), 
							// 문자열을 정수로 변환
							Integer.parseInt(multi.getParameter("price")), 
							image, 
							multi.getParameter("nation"), 
							Integer.parseInt(multi.getParameter("height")), //문자열을 정수로 변환
							Integer.parseInt(multi.getParameter("weight")), //문자열을 정수로 변환
							multi.getParameter("content"), 
							0); //조회수
		boolean isRegistSuccess = dogRegistService.registDog(dog);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			forward = new ActionForward("dogList.dog", true); //강아지 목록 리스트 이동
		}else{ // 강아지 신규 등록이 실패하면
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패하였습니다!');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
