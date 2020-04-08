import java.util.ArrayList;

public class Movie {
	protected String title;
	protected ArrayList<String> genre;
	protected int year;
	
	//no-args constructor
	public Movie() {
		title="";
		genre=new ArrayList<>();
		year=0;
		}
	
	//paraneterized constructor
	public Movie(String t, ArrayList<String> g, int y) {
		title=t;
		genre=g;
		year=y;
	}

	//toString method
	public String toString() {
		String str = title+" "+genre.toString()+" "+year+"\n";
		return str;
	}
}
