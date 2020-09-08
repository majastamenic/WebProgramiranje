package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;


import beans.Amenities;


public class AmenitiesDAO {

private static Map<Integer, Amenities> pogodnosti = new HashMap<>();
	
	
	public AmenitiesDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Mo�e se pristupiti samo iz servleta.
	 */
	public AmenitiesDAO(String contextPath) {
		ucitajPogodnosti();
	}
	
	/**
	 * Vra�a korisnika za prosle�eno korisni�ko ime i �ifru. Vra�a null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public Amenities find(Integer id) {
		if (!pogodnosti.containsKey(id)) {
			return null;
		}
		Amenities komm = pogodnosti.get(id);
		
		return komm;
	}
	
	public Collection<Amenities> findAll() {
		return pogodnosti.values();
	}
	
	/**
	 * U�itava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Klju� je korisni�ko ime korisnika.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	public static Map<Integer, Amenities> ucitajPogodnosti() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/pogodnosti.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					
					
					int id=Integer.parseInt(st.nextToken().trim());
					String naziv = st.nextToken().trim();
	
					
					pogodnosti.put(id, new Amenities(id, naziv));
				}
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
		return pogodnosti;
	}
	
public static Amenities findAmenitiesById(Integer id) {
		
	Amenities trazenaPogodnost = null;
		if(pogodnosti.size()==0) {
			ucitajPogodnosti();
		}
		if(pogodnosti.containsKey(id)) {
			trazenaPogodnost=pogodnosti.get(id);
			return trazenaPogodnost;
		}
		else
			return null;
		
	}
	

}