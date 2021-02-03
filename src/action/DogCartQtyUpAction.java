package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartQtyUpService;
import vo.ActionForward;

public class DogCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 강아지 품종 값을 가져와서 dogCartQtyUpService.upCartQty()메서드에서 
		// spin control을 이용해서 수량만 1증가 시킨후 다시 장바구니 리스트로 이동
		String kind = request.getParameter("kind");
		DogCartQtyUpService dogCartQtyUpService = new DogCartQtyUpService();
		dogCartQtyUpService.upCartQty(kind,request);
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}
