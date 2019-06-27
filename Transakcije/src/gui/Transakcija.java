package gui;

import gui.Datum;

public class Transakcija {
//	private double pocetnoStanje;
	private double suma;
	private static double trenutnoStanje;
	protected static boolean uspesno;
	static boolean vrstaTranskacije;
	private Datum datum;
	private int dan;
	private int mesec;
	private int godina;
	
	public Transakcija(double suma, int dan, int mesec, int godina, boolean vrstaTranskacije) {
		super();
		this.suma = suma;
		datum=new Datum(dan, mesec, godina);
		this.vrstaTranskacije = vrstaTranskacije;
	}

	public Transakcija(double suma, Datum datumProveren, boolean vrstaTranskacije) {
		super();
		this.suma = suma;
		datum = new Datum(datumProveren);
		this.vrstaTranskacije = vrstaTranskacije;
	}

	public boolean izvrsiTransakciju() {
		boolean uspesno=true;
		if (vrstaTranskacije==true) {
			trenutnoStanje = trenutnoStanje+suma;
		} else {
			if(trenutnoStanje-suma >=0) {
				trenutnoStanje = trenutnoStanje-suma;
				uspesno=true;
			} else {
				uspesno=false;
			}
		}
		return uspesno;
	}
	
	public double suma() {
		return suma;
	}
	public Datum datum() {
		return datum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Transakcija");
		builder.append(suma);
		builder.append(", ");
		builder.append(datum);
		return builder.toString();
	}

	public static double tekuceStanje() {
		// TODO Auto-generated method stub
		return trenutnoStanje;
	}

	public static boolean vrstaTranskacije(boolean b) {
		// TODO Auto-generated method stub
		return b;
	}
	
	
	
}
