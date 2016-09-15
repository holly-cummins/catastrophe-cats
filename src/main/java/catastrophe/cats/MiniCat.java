package catastrophe.cats;

public class MiniCat {
	private long id;
	private String image;

	public MiniCat() {
	}

	public MiniCat(long id, String image) {
		this.id = id;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public String getImage() {
		return image;

	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
