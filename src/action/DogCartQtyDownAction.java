package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartQtyDownService;
import vo.ActionForward;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 강아지 품종 값을 가져와서 dogCartQtyUpService.downCartQty()메서드에서 spin control을 이용해서 수량만 1감소 시킨후 다시 장바구니 리스트로 이동
		String kind = request.getParameter("kind");
		System.out.println("kind = " + kind);
		DogCartQtyDownService dogCartQtyDownService = new DogCartQtyDownService();
		dogCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward("dogCartList.dog",true);
		return forward;
	}

}
