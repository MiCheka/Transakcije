package guiS;

import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import guiS.Transakcija;

public class TransactionService {

	public double izvrsiTransakciju(double stanje, Transakcija t) {

		boolean uplata = t.isUplata();

		if (uplata) {

			stanje += t.getSuma();
		} else {
			stanje -= t.getSuma();
		}

		return stanje;
	}

	public static ArrayList<Transakcija> dodajUplate(Transakcija t) {

		ArrayList<Transakcija> listaUplata = new ArrayList<Transakcija>();
		boolean uplata = t.isUplata();
		if (uplata) {
			listaUplata.add(t);
		} else {
			return null;
		}

		return listaUplata;
	}

	public static ArrayList<Transakcija> dodajIsplate(Transakcija t) {

		ArrayList<Transakcija> listaIsplata = new ArrayList<Transakcija>();
		boolean uplata = t.isUplata();
		if (!uplata) {
			listaIsplata.add(t);
		} else {
			return null;
		}

		return listaIsplata;
	}
	
	public boolean isTekuciMesec(Date datum) {
		
		Calendar cal1= Calendar.getInstance();
		Calendar cal2= Calendar.getInstance();
		
		//set the given date in one of the instance and current date in the other
		
		cal1.setTime(datum);
		cal2.setTime(new Date());
		
		if(cal1.get(Calendar.YEAR)== cal2.get(Calendar.YEAR)) {
			if(cal1.get(Calendar.MONTH)== cal2.get(Calendar.MONTH)) {
				return true;
			}else return false;
		}else return false;
	}

	public Date getDatum(Transakcija t) {
		String value = t.getDan() + "." + t.getMesec() + "." + t.getGodina();
		
		DateFormat original = new SimpleDateFormat("dd.MM.yyyy");
		
		try {
			Date datum = original.parse(value);
			return datum;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int daysInMonth(int year, int month) {
		int days = 0;

		if (year > 1900 && year < 3000 && month > 0 && month < 13) {
			YearMonth ym = YearMonth.of(year, month);

			days = ym.lengthOfMonth();

		} else {
			return -1;
		}
		return days;
	}	
	
	public static void main(String[] args) {
		TransactionService ts = new TransactionService();

		System.out.println(ts.daysInMonth(1999, 14));

	}

}
