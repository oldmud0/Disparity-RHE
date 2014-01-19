package genericRPG.races;

import java.util.ArrayList;
import java.util.List;

public class Race{
	public String name;
	
	public static List<String> getRaces() {
		List<String> races = new ArrayList<String>();
		races.add("HUMAN");
		races.add("GRYPHON");
		races.add("GNOME");
		races.add("ELF");
		races.add("DWARF");
		
		return races;
	}
}