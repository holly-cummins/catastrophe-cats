package catastrophe.cats;

public class MiniCat {
	private long id;
	private String image;
	private String realName;
	private String attribution;

	public MiniCat(long id, String realName, String image, String attribution) {
		this.id = id;
		this.image = image;
		this.realName = realName;
		this.attribution = attribution;
	}

	public MiniCat(long id, String image) {
		this.id = id;
		this.image = image;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRealName() {
		return realName;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
}
