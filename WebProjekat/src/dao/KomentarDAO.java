package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import static util.Putanja._PROJECT_LOCATION;

import beans.Apartman;
import beans.Domacin;
import beans.Gost;
import beans.KomentarZaApartman;


public class KomentarDAO {
private static Map<Integer, KomentarZaApartman> komentari = new HashMap<>();
	
	
	public KomentarDAO() {
		
	}

	public static Map<Integer, KomentarZaApartman> getKomentari() {
		return komentari;
	}
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Mo�e se pristupiti samo iz servleta.
	 */
	public KomentarDAO(String contextPath) {
		ucitajKomentare();
	}
	
	/**
	 * Vra�a korisnika za prosle�eno korisni�ko ime i �ifru. Vra�a null ako korisnik ne postoji
	 * @param username
	 * @param password
	 * @return
	 */
	public KomentarZaApartman find(Integer id) {
		if (!komentari.containsKey(id)) {
			return null;
		}
		KomentarZaApartman komm = komentari.get(id);
		
		return komm;
	}
	
	public static Collection<KomentarZaApartman> findAll() {
		return komentari.values();
	}
	
	/**
	 * U�itava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #users}.
	 * Klju� je korisni�ko ime korisnika.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	public static Map<Integer, KomentarZaApartman> ucitajKomentare() {
		BufferedReader in = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/komentari.txt");
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
					int idGosta=Integer.parseInt(st.nextToken().trim());
					
					Gost gost= GostDAO.findGuestById(idGosta);
					int idApartmana=Integer.parseInt(st.nextToken().trim());
					Apartman apartman= ApartmanDAO.findApartmentById(idApartmana);
					String tekst =st.nextToken().trim();
					int ocena= Integer.parseInt(st.nextToken().trim());
	
					
					komentari.put(id, new KomentarZaApartman(id, gost, apartman, tekst, ocena));
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
		return komentari;
	}
	
	public static KomentarZaApartman findCommentById(Integer id) {
		
		KomentarZaApartman trazeniKomentar = null;
			if(komentari.size()==0) {
				ucitajKomentare();
			}
			if(komentari.containsKey(id)) {
				trazeniKomentar=komentari.get(id);
				return trazeniKomentar;
			}
			else
				return null;
			
		}
	
	/*public static void dodajKomentar(KomentarZaApartman komentar) throws IOException {
		komentari= ucitajKomentare();
		komentari.put(komentar.getId(), komentar);
		List<KomentarZaApartman> komentariLista= new ArrayList<KomentarZaApartman>(komentari.values());
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/komentari.txt");
			out = new BufferedWriter(new FileWriter(file));
			for(KomentarZaApartman komentarZaApartman: komentariLista) {
				out.write(komentarZaApartman.getGost().toString() + ";"+ komentarZaApartman.getApartman()+ ";"
						+ komentarZaApartman.getTekst()+ ";"+ komentarZaApartman.getOcena()+  "\n");
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
			finally {
		}
			if (out != null) {
				try {
					out.close();
				}
				catch (Exception e) { }
			}
		}
	      */
	
	public static Map<Integer, KomentarZaApartman> komentarNaApartman(Apartman apartman){
		if(komentari.isEmpty())
			komentari = ucitajKomentare();
		
		Map<Integer, KomentarZaApartman> komentariNaAktivne = new HashMap<Integer,KomentarZaApartman>();
		for(Map.Entry<Integer , KomentarZaApartman> komentar : komentari.entrySet()) {
				if(komentar.getValue().getApartman().getId() == apartman.getId()) {
					komentariNaAktivne.put(komentar.getValue().getId(), komentar.getValue());
				}
			}
		return komentariNaAktivne;
		}
	
	public static Map<Integer, KomentarZaApartman> ucitajKomentareNaAktivne(){
		komentari = ucitajKomentare();
		Map<Integer, KomentarZaApartman> komentariNaAktivne = new HashMap<Integer, KomentarZaApartman>();
		
		for(Apartman apartman: ApartmanDAO.aktivniApartmani().values()) {
			for(KomentarZaApartman komentar: komentari.values()) {
				if(komentar.getApartman().getId()==apartman.getId()) {
					komentariNaAktivne.put(komentar.getId(), komentar);
				}
			}
		}
		
		return komentariNaAktivne;
	}
	
	
	public static int vratiNajveciID() {
		int maxId = 0;
		for (Map.Entry<Integer , KomentarZaApartman> komentar : komentari.entrySet())
		{
		    if ( maxId < komentar.getKey().intValue())
		    {
		        maxId = komentar.getKey();
		    }
		}
		return maxId;
	}
	
	public static Map<Integer, KomentarZaApartman> ucitajKomentareNaApartmaneOdDomacina(Domacin domacin){
		komentari = ucitajKomentare();
		Map<Integer, KomentarZaApartman> komentariNaApartmane = new HashMap<Integer, KomentarZaApartman>();
		
		for(Apartman apartman: ApartmanDAO.ucitajApartmaneOdDomacina(domacin).values()) {
			for(KomentarZaApartman komentar: komentari.values()) {
				if(komentar.getApartman().getId()==apartman.getId()) {
					komentariNaApartmane.put(komentar.getId(), komentar);
				}
			}
		}
		
		return komentariNaApartmane;
	}
	
	public static void dodajKomentarUMapu(KomentarZaApartman noviKomentar) {
		if(komentari.isEmpty())
			komentari = ucitajKomentare();
			
			noviKomentar.setId(vratiNajveciID() + 1);
			komentari.put(vratiNajveciID() + 1, noviKomentar);
		
	}
	public static void sacuvajSveKomentareIzMape() throws IOException {
		
		
		BufferedWriter out = null;
		try {
			File file = new File(_PROJECT_LOCATION + "/komentari.txt");
			out = new BufferedWriter(new FileWriter(file));
			 for (Map.Entry<Integer, KomentarZaApartman> komentar : komentari.entrySet())  {
				out.write(komentar.getValue().ispisTXT());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
			finally {
		}
			if (out != null) {
				try {
					out.close();
				}
				catch (Exception e) { }
			}
		}
	



	public static Boolean izbrisiKomentar(Integer id) {
		komentari = ucitajKomentare();
		KomentarZaApartman komentar= new KomentarZaApartman();
		komentar = findCommentById(id);
		if (!(komentar == null)) {
			komentari.remove(id);
			List<KomentarZaApartman> komentariLista= new ArrayList<KomentarZaApartman>(komentari.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/komentari.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(KomentarZaApartman komentarZaApartman: komentariLista) {
					out.write(komentarZaApartman.getGost().toString() + ";"+ komentarZaApartman.getApartman()+ ";"
							+ komentarZaApartman.getTekst()+ ";"+ komentarZaApartman.getOcena()+  "\n");
				}
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
				finally {
			}
				if (out != null) {
					try {
						out.close();
					}
					catch (Exception e) { }
				}
			return true;
		}else
			return false;
	}
	
	public static Boolean izmeniKomentar(KomentarZaApartman izmenjenKomentar) {
		komentari = ucitajKomentare();
		KomentarZaApartman komentar= new KomentarZaApartman();
		komentar = findCommentById(izmenjenKomentar.getId());
		if (!(komentar == null)) {
			
			komentar.setGost(izmenjenKomentar.getGost());
			komentar.setApartman(izmenjenKomentar.getApartman());
			komentar.setTekst(izmenjenKomentar.getTekst());
			komentar.setOcena(izmenjenKomentar.getOcena());
			
			List<KomentarZaApartman> komentariLista= new ArrayList<KomentarZaApartman>(komentari.values());
			BufferedWriter out = null;
			try {
				File file = new File(_PROJECT_LOCATION + "/komentari.txt");
				out = new BufferedWriter(new FileWriter(file));
				for(KomentarZaApartman komentarZaApartman: komentariLista) {
					out.write(komentarZaApartman.getGost().toString() + ";"+ komentarZaApartman.getApartman()+ ";"
							+ komentarZaApartman.getTekst()+ ";"+ komentarZaApartman.getOcena()+  "\n");
				}
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
				finally {
			}
				if (out != null) {
					try {
						out.close();
					}
					catch (Exception e) { }
				}
			return true;
		}else
			return false;
	}
	

}
