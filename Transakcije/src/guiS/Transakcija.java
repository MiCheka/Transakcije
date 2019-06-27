package guiS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transakcija {		
	
		private boolean uplata;
		private double suma;
		private int dan;
		private int mesec;
		private int godina;		
		
		
		public Transakcija() {
			super();
			
		}

		public Transakcija(boolean uplata, double suma, int dan, int mesec, int godina) {
			super();
			this.uplata = uplata;
			this.suma = suma;
			this.dan = dan;
			this.mesec = mesec;
			this.godina = godina;
		}

		public double getSuma() {
			return suma;
		}		
		
		public boolean isUplata() {
			return uplata;
		}

		public void setUplata(boolean uplata) {
			this.uplata = uplata;
		}

		public void setSuma(double suma) {
			this.suma = suma;
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
			return suma + " " + dan + "." + mesec + "." + godina + ".";
		}
		
		
}