
public class Coffee extends Food {

	private String aroma;
	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	public void consume() {
		System.out.println(this+" выпито");

	}
	public Coffee(String aroma){
		super("Кофе");
		this.aroma=aroma;
	}
	public String toString() {
		return super.toString()+" с ароматом '" +aroma.toUpperCase()+"'";
	}

	


}
