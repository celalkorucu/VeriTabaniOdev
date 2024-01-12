package library;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Biletler {

	int id ;
	Date satin_alma_tarihi ;
	String bilet_durumu ;
	int musteri_id ;
	int ucus_id ;
	int bilet_fiyati ;
	String musteri_ad ;
	String musteri_soyad ;
	String ucak_model ;
	Date kalkis_tarihi , varis_tarihi ;
	String kalkis_havalimani , varis_havalimani ;
	
	DatabaseCoonection con = new DatabaseCoonection();
	
	
	public Biletler(int id, String musteri_ad ,String musteri_soyad,Date satin_alma_tarihi, String bilet_durumu, int bilet_fiyati,
			String ucak_model, Date kalkis_tarihi, Date varis_tarihi, String kalkis_havalimani,
			String varis_havalimani) {
		super();
		this.id = id;
		this.satin_alma_tarihi = satin_alma_tarihi;
		this.bilet_durumu = bilet_durumu;

		this.bilet_fiyati = bilet_fiyati;
		this.ucak_model = ucak_model;
		this.kalkis_tarihi = kalkis_tarihi;
		this.varis_tarihi = varis_tarihi;
		this.kalkis_havalimani = kalkis_havalimani;
		this.varis_havalimani = varis_havalimani;
		this.musteri_ad = musteri_ad;
		this.musteri_soyad = musteri_soyad;
	}
	
	public Biletler(int id , Date satin_alma_tarihi , String bilet_durumu , int musteri_id , int ucus_id) {
		this.id = id ;
		this.satin_alma_tarihi = satin_alma_tarihi ;
		this.bilet_durumu = bilet_durumu ;
		this.musteri_id = musteri_id;
		this.ucus_id = ucus_id;
	}
	
	public Biletler(String biletdurumu , int musteri_id , int ucus_id) {
		this.bilet_durumu = biletdurumu;
		this.musteri_id = musteri_id;
		this.ucus_id = ucus_id;
	}
	
	
	
	public String getMusteri_ad() {
		return musteri_ad;
	}

	public void setMusteri_ad(String musteri_ad) {
		this.musteri_ad = musteri_ad;
	}

	public String getMusteri_soyad() {
		return musteri_soyad;
	}

	public void setMusteri_soyad(String musteri_soyad) {
		this.musteri_soyad = musteri_soyad;
	}

	public Biletler() {
		
	}
	
	public boolean ProsedurBiletEkle(Biletler addedBilet) {
		
		
		String sqlProsedur = "{ call bilet_ekle(?,?,?) }";
        try {
        	CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
            callableStatement.setString(1, addedBilet.getBilet_durumu());
            callableStatement.setInt(2, addedBilet.getMusteri_id());
            callableStatement.setInt(3, addedBilet.getUcus_id());



            // Prosedürü çaðýr
            callableStatement.execute();
            System.out.println("Bilet eklendi.");
            return true ;
        }catch (Exception e) {
			e.printStackTrace();
		}
        return false ;
	}
	
	public ArrayList<Biletler> ProsedurTumBiletleriListele() {
		
		 ArrayList<Biletler> biletlerList = new ArrayList<>();
		    String sorgu = "call tum_biletleri_listele";
		    
		    try {
		        CallableStatement cstmt = con.getCon().prepareCall(sorgu);
		        ResultSet rs = cstmt.executeQuery();

		        while (rs.next()) {
		            int ID = rs.getInt("bilet_id");
		            String musteri_ad = rs.getString("musteri_ad");
		            String musteri_soyad = rs.getString("musteri_soyad");
		            Date bilet_satin_alma_tarihi = rs.getDate("bilet_satin_alma_tarihi");
		            String bilet_durumu = rs.getString("bilet_durumu");
		            int bilet_fiyati = rs.getInt("bilet_fiyati");
		            String ucak_model = rs.getString("ucak_model");
		            Date kalkis_tarihi = rs.getDate("kalkis_tarihi");
		            Date varis_tarihi = rs.getDate("varis_tarihi");
		            String kalkis_havalimani_adi = rs.getString("kalkis_havalimani_adi");
		            String varis_havalimani_adi = rs.getString("varis_havalimani_adi");

		            Biletler biletler = new Biletler(ID, musteri_ad, musteri_soyad, bilet_satin_alma_tarihi, bilet_durumu, bilet_fiyati, ucak_model, kalkis_tarihi, varis_tarihi, kalkis_havalimani_adi, varis_havalimani_adi);
		            biletlerList.add(biletler);
		        }

		        cstmt.close();
		        rs.close();
		        return biletlerList;
		    } catch (SQLException e) {
		        // Hata durumunda iþlemler
		        e.printStackTrace();
		    }
		    return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSatin_alma_tarihi() {
		return satin_alma_tarihi;
	}
	public void setSatin_alma_tarihi(Date satin_alma_tarihi) {
		this.satin_alma_tarihi = satin_alma_tarihi;
	}
	public String getBilet_durumu() {
		return bilet_durumu;
	}
	public void setBilet_durumu(String bilet_durumu) {
		this.bilet_durumu = bilet_durumu;
	}
	public int getMusteri_id() {
		return musteri_id;
	}
	public void setMusteri_id(int musteri_id) {
		this.musteri_id = musteri_id;
	}
	public int getUcus_id() {
		return ucus_id;
	}
	public void setUcus_id(int ucus_id) {
		this.ucus_id = ucus_id;
	}
	public int getBilet_fiyati() {
		return bilet_fiyati;
	}
	public void setBilet_fiyati(int bilet_fiyati) {
		this.bilet_fiyati = bilet_fiyati;
	}
	public String getUcak_model() {
		return ucak_model;
	}
	public void setUcak_model(String ucak_model) {
		this.ucak_model = ucak_model;
	}
	public Date getKalkis_tarihi() {
		return kalkis_tarihi;
	}
	public void setKalkis_tarihi(Date kalkis_tarihi) {
		this.kalkis_tarihi = kalkis_tarihi;
	}
	public Date getVaris_tarihi() {
		return varis_tarihi;
	}
	public void setVaris_tarihi(Date varis_tarihi) {
		this.varis_tarihi = varis_tarihi;
	}
	public String getKalkis_havalimani() {
		return kalkis_havalimani;
	}
	public void setKalkis_havalimani(String kalkis_havalimani) {
		this.kalkis_havalimani = kalkis_havalimani;
	}
	public String getVaris_havalimani() {
		return varis_havalimani;
	}
	public void setVaris_havalimani(String varis_havalimani) {
		this.varis_havalimani = varis_havalimani;
	}
	
	
}
