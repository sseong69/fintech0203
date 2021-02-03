package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Dog;
import dao.DogDAO;
public class DogViewService {
	//특정 강아지 상세보기
	public Dog getDogView(int id) {
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		// 조회수 1증가 시킴
		int updateCount = dogDAO.updateReadCount(id);
		
		if(updateCount>0){
			commit(con);
		}else{
			rollback(con);
		}
		// 특정 강아지에 대한 정보를 가져온다.
		Dog dog = dogDAO.selectDog(id);
		close(con);
		return dog;
	}

}
