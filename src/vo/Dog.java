package vo;

public class Dog {
	
	private int id;
	private String kind;
	private int price;
	private String image;
	private String country;
	private int height;
	private int weight;
	private String content;
	private int readcount;

	
	public Dog(int id, String kind, int price, String image, String country,
			int height, int weight, String content, int readcount) {
		super();
		this.id = id; //강아지 아이디
		this.kind = kind; // 품종
		this.price = price; // 가격
		this.image = image; // 개 이미지
		this.country = country; // 원산지
		this.height = height; // 신장
		this.weight = weight; // 체중
		this.content = content; // 내용
		this.readcount = readcount; // 조회수
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
    public String getKind(){
    	return kind;
    }
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
		
}
