package gui;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Datum {
	private int dan;
	private int mesec;
	private int godina;

	public Datum(int dan, int mesec, int godina) {
		super();
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}

	public Datum(Datum datumProveren) {
		// TODO Auto-generated constructor stub
		this.dan = datumProveren.dan;
		this.mesec = datumProveren.mesec;
		this.godina = datumProveren.godina;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

	public int getMesec() {
		return mesec;
	}

	public void setMesec(int mesec) {
		this.mesec = mesec;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	@Override
	public String toString() {
		return "=" + dan + "/" + mesec + "/" + godina + "";
	}

	public static boolean dateValidation(int dan2, int mesec2, int godina2) {
//		int dan2=dan;
//		int mesec2=mesec;
//		int godina2=godina;
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);

        String datum = dan2+"/"+mesec2+"/"+godina2;
        try {
            format.parse(datum);
        } catch (ParseException e) {
            System.out.println("Date " + datum + " is not valid according to " +
                ((SimpleDateFormat) format).toPattern() + " pattern.");
        }
		return true;
	}


}
