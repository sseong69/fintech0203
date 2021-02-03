package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogViewService;
import vo.ActionForward;
import vo.Dog;
// 강아지상세보기를 처리하는 비지니스 로직
public class DogViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DogViewService dogViewService = new DogViewService();
		// 강아지 리스트에서 클릭한 특정 강아지의 아이디 가져오기
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = dogViewService.getDogView(id);
		// 리턴된 Dog정보를 dog라는 속성으로 지정
		request.setAttribute("dog", dog);
		// 쿠키정보도 생성: 강아지 목록에서 오늘 클릭한 강아지 정보를 보여주기 위해 클릭한 강아지에 대한 쿠키정보를 생성한다.
		Cookie todayImageCookie = new Cookie("today"+id, dog.getImage());
		// 쿠키정보의 유효시간 24시간
		todayImageCookie.setMaxAge(60*60*24);
		// 응답처리에 쿠키정보를 추가
		response.addCookie(todayImageCookie);
		// 특정강아지 상세보기 화면으로 이동
		ActionForward forward = new ActionForward("dogView.jsp", false);
		return forward;
	}
	
}