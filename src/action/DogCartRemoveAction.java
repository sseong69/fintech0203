package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartRemoveService;
import vo.ActionForward;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 장바구니에서 삭제처리하려는 항목앞 체크박스에 체크하고 삭제버튼을 클릭 장바구니에서 삭제처리
		// 삭제위해 클릭한 강아지 정보를 배열에 대입
		String[] kindArray = request.getParameterValues("remove");
		DogCartRemoveService dogCartRemoveService = new DogCartRemoveService();
		dogCartRemoveService.cartRemove(request,kindArray);
		// 삭제처리 후 장바구니 리스트로 리다이렉트(강제로 보냄)처리
		ActionForward forward = new ActionForward("dogCartList.dog",true);
		return forward;
	}
	
}