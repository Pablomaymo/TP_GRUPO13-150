package ar.utn.ap.pronosticos;

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesE1;
	private int golesE2;
	
	
	public Partido(Equipo equipo1, Equipo equipo2, int golesE1, int golesE2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesE1 = golesE1;
		this.golesE2 = golesE2;
	}
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGolesE1() {
		return golesE1;
	}
	public void setGolesE1(int golesE1) {
		this.golesE1 = golesE1;
	}
	public int getGolesE2() {
		return golesE2;
	}
	public void setGolesE2(int golesE2) {
		this.golesE2 = golesE2;
	}
	
	public String resultado (Equipo equipo) {
		if(golesE1==golesE2) {
			return "EMPATE";
		}
		
		if(equipo.equals(equipo1)) {
			if(equipo.getNombre().equals(equipo1.getNombre())) {
				if(golesE1>golesE2) {
				return "GANADOR";
			} else {
				return "PERDEDOR";
			}
			}else {
		    	if(golesE2>golesE1) {
					return "GANADOR";
				}else {
					return "PERDEDOR";
				}
		    }
		    }
			
			
	   return null;
		
	}
	
	

}
