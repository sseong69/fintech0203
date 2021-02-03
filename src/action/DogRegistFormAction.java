package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

public class DogRegistFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 강아지 신규 입력폼으로 이동
		ActionForward forward = new ActionForward("dogRegistForm.jsp", false);
		return forward;
	}
	
}