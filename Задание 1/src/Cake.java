

public class Cake extends Food {

	private String nacinka;
	public String getNacinka() {
		return nacinka;
	}

	public void setNacinka(String nacinka) {
		this.nacinka = nacinka;
	}
	public void consume() {
		System.out.println(this+" съедено");

	}
	public Cake(String nacinka){
		super("Пирог");
		this.nacinka=nacinka;
	}
	public String toString() {
		return super.toString()+" с начинкой'" +nacinka.toUpperCase()+"'";
	}
	
}
