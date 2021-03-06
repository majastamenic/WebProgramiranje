package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Apartman {
	private int id;
	private TipApartmana tip;
	private int brojSoba;
	private int brojGostiju;
	private Lokacija lokacija;
	private Date datumZaIzdavanje;
	private List<Date> dostupnostPoDatumima;
	private Domacin domacin;
	private List<KomentarZaApartman> komentar;
	//slike
	private float cenaPoNoci;
	private String vremeZaPrijavu;
	private String vremeZaOdjavu;
	private StatusApartman status;
	private List<Amenities> sadrzajApartmana = new ArrayList<Amenities>();
	private List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
	

	public String ispisTXT() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return id + ";"+ tip.toString() + ";"+ brojSoba + ";"+ brojGostiju+ ";"+ lokacija.getId()+ ";"
					+ dateFormat.format(datumZaIzdavanje) + ";"+ domacin.getId() 
				 + ";"+ cenaPoNoci + ";"+ vremeZaPrijavu
					+ ";"+ vremeZaOdjavu + ";"+ status.toString() + "\n";
	
	} 
	
	public Apartman() {
		dostupnostPoDatumima = new ArrayList<Date>();
		sadrzajApartmana = new ArrayList<Amenities>();
		rezervacije = new ArrayList<Rezervacija>();
	}

	public Apartman(int id, TipApartmana tip, int brojSoba, int brojGostiju, Lokacija lokacija, Date datumZaIzdavanje,
			List<Date> dostupnostPoDatumima, Domacin domacin, List<KomentarZaApartman> komentar, float cenaPoNoci,
			String vremeZaPrijavu, String vremeZaOdjavu, StatusApartman status, List<Amenities> sadrzajApartmana,
			List<Rezervacija> rezervacije) {
		super();
		this.id=id;
		this.tip = tip;
		this.brojSoba = brojSoba;
		this.brojGostiju = brojGostiju;
		this.lokacija = lokacija;
		this.datumZaIzdavanje = datumZaIzdavanje;
		this.dostupnostPoDatumima = dostupnostPoDatumima;
		this.domacin = domacin;
		this.setKomentar(komentar);
		this.cenaPoNoci = cenaPoNoci;
		this.vremeZaPrijavu = vremeZaPrijavu;
		this.vremeZaOdjavu = vremeZaOdjavu;
		this.status = status;
		this.sadrzajApartmana = sadrzajApartmana;
		this.rezervacije = rezervacije;
	}
	
	public Apartman(int id, TipApartmana tip, int brojSoba, int brojGostiju, Lokacija lokacija, Date datumZaIzdavanje,
			 Domacin domacin, float cenaPoNoci,
			String vremeZaPrijavu, String vremeZaOdjavu, StatusApartman status) {
		super();
		this.id=id;
		this.tip = tip;
		this.brojSoba = brojSoba;
		this.brojGostiju = brojGostiju;
		this.lokacija = lokacija;
		this.datumZaIzdavanje = datumZaIzdavanje;
		this.domacin = domacin;	
		this.cenaPoNoci = cenaPoNoci;
		this.vremeZaPrijavu = vremeZaPrijavu;
		this.vremeZaOdjavu = vremeZaOdjavu;
		this.status = status;
		
	}

	

	 





	public TipApartmana getTip() {
		return tip;
	}

	public void setTip(TipApartmana tip) {
		this.tip = tip;
	}

	public int getBrojSoba() {
		return brojSoba;
	}

	public void setBrojSoba(int brojSoba) {
		this.brojSoba = brojSoba;
	}

	public int getBrojGostiju() {
		return brojGostiju;
	}

	public void setBrojGostiju(int brojGostiju) {
		this.brojGostiju = brojGostiju;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	public Date getDatumZaIzdavanje() {
		return datumZaIzdavanje;
	}

	public void setDatumZaIzdavanje(Date datumZaIzdavanje) {
		this.datumZaIzdavanje = datumZaIzdavanje;
	}

	public List<Date> getDostupnostPoDatumima() {
		return dostupnostPoDatumima;
	}

	public void setDostupnostPoDatumima(List<Date> dostupnostPoDatumima) {
		this.dostupnostPoDatumima = dostupnostPoDatumima;
	}

	public Domacin getDomacin() {
		return domacin;
	}

	public void setDomacin(Domacin domacin) {
		this.domacin = domacin;
	}

	

	public float getCenaPoNoci() {
		return cenaPoNoci;
	}

	public void setCenaPoNoci(float cenaPoNoci) {
		this.cenaPoNoci = cenaPoNoci;
	}

	public String getVremeZaPrijavu() {
		return vremeZaPrijavu;
	}

	public void setVremeZaPrijavu(String vremeZaPrijavu) {
		this.vremeZaPrijavu = vremeZaPrijavu;
	}

	public String getVremeZaOdjavu() {
		return vremeZaOdjavu;
	}

	public void setVremeZaOdjavu(String vremeZaOdjavu) {
		this.vremeZaOdjavu = vremeZaOdjavu;
	}

	public StatusApartman getStatus() {
		return status;
	}

	public void setStatus(StatusApartman status) {
		this.status = status;
	}

	public List<Amenities> getSadrzajApartmana() {
		return sadrzajApartmana;
	}

	public void setSadrzajApartmana(List<Amenities> sadrzajApartmana) {
		this.sadrzajApartmana = sadrzajApartmana;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<KomentarZaApartman> getKomentar() {
		return komentar;
	}

	public void setKomentar(List<KomentarZaApartman> komentar) {
		this.komentar = komentar;
	}
	
	
}
