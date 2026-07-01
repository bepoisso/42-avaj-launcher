package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.coordinates.Coordinates;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public  void updateConditions() {
		// TODO
	}

	@Override
	public String getHeader() {
		return String.format("Balloon#%s(%d)", name, id);
	}
}
