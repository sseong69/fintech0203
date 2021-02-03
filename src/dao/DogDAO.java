package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Dog;

public class DogDAO {
	
	Connection con;
	private static DogDAO boardDAO;
	
	private DogDAO() {}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	//SingleTon(싱글톤 패턴)
	public static DogDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new DogDAO();
		}
		
		return boardDAO;
	}
	// 강아지 전체 리스트
	public ArrayList<Dog> selectDogList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Dog> dogList = null;
		String sql="";
		try {
			sql = "select * from dog";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(
							new Dog(
									rs.getInt("id"),
									rs.getString("kind"),
									rs.getInt("price"),
									rs.getString("image"),
									rs.getString("country"),
									rs.getInt("height"),
									rs.getInt("weight"),
									rs.getString("content"),
									rs.getInt("readcount")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}
	// 특정 강아지 정보를 가져온다.
	public Dog selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog dog = null;
		String sql="";
		try {
			sql = "select * from dog where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();//ResultSet? select문을 실행한 결과값을 가지는 객체
			// 다음에 가져올 자료가 있는지 여부체크
			if(rs.next()){
				dog = new Dog(
						rs.getInt("id"),
						rs.getString("kind"),
						rs.getInt("price"),
						rs.getString("image"),
						rs.getString("country"),
						rs.getInt("height"),
						rs.getInt("weight"),
						rs.getString("content"),
						rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return dog;
	}
	// 조회수 증가 시키기
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "update dog set readcount = readcount + 1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	// 신규 강아지 등록
	public int insertDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "insert into dog values(dog_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dog.getKind());
			pstmt.setInt(2, dog.getPrice());
			pstmt.setString(3, dog.getImage());
			pstmt.setString(4, dog.getCountry());
			pstmt.setInt(5, dog.getHeight());
			pstmt.setInt(6, dog.getWeight());
			pstmt.setString(7, dog.getContent());
			pstmt.setInt(8, dog.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
}
