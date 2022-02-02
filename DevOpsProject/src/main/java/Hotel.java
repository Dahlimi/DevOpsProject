
public class Hotel {
	protected String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPricing() {
		return pricing;
	}
	public void setPricing(String pricing) {
		this.pricing = pricing;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Hotel(String name, String address, String pricing, String star, String image) {
		super();
		this.name = name;
		this.address = address;
		this.pricing = pricing;
		this.star = star;
		this.image = image;
	}
	protected String address;
	protected String pricing;
	protected String star;
	protected String image;

}
