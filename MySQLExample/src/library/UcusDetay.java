package library;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class UcusDetay {
	
	
	int ucus_id ,bilet_fiyati , bos_koltuk_sayisi;
	Date varis_tarihi , kalkis_tarihi ;
	
	String kalkis_havalimani_adi , varis_havalimani_adi ;
	String ucak_model;
	
	
	
	DatabaseCoonection con = new DatabaseCoonection();
	public UcusDetay() {
		
	}
	
	
	public UcusDetay(int ucus_id, int bilet_fiyati, int bos_koltuk_sayisi, Date varis_tarihi, Date kalkis_tarihi,
			String kalkis_havalimani_adi, String varis_havalimani_adi, String ucak_model) {
		this.ucus_id = ucus_id;
		this.bilet_fiyati = bilet_fiyati;
		this.bos_koltuk_sayisi = bos_koltuk_sayisi;
		this.varis_tarihi = varis_tarihi;
		this.kalkis_tarihi = kalkis_tarihi;
		this.kalkis_havalimani_adi = kalkis_havalimani_adi;
		this.varis_havalimani_adi = varis_havalimani_adi;
		this.ucak_model = ucak_model;
	}
	
	
	public ArrayList<UcusDetay> ProsedurUcusDetayListele(){
		ArrayList<UcusDetay> ucusDetayList = new ArrayList<>();
		
		String sorgu = "{call ucus_detay_listele()}";
		
		
	        try {
	        	
	            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
	            ResultSet rs = cstmt.executeQuery();

	            while (rs.next()) {
	            	
	                int ucus_id = rs.getInt("ucus_id");
	                int bos_koltuk_sayisi = rs.getInt("bos_koltuk_sayisi");
	                int bilet_fiyati = rs.getInt("bilet_fiyati");
	                Date kalkis_tarihi = rs.getDate("kalkis_tarihi");
	                Date varis_tarihi = rs.getDate("varis_tarihi");
	                String kalkis_havalimani_adi = rs.getString("kalkis_havalimani_adi");
	                String varis_havalimani_adi = rs.getString("varis_havalimani_adi");
	                String ucak_model = rs.getString("model");
	                
	                UcusDetay ucusDetay = new UcusDetay(ucus_id, bilet_fiyati, bos_koltuk_sayisi, varis_tarihi, kalkis_tarihi, kalkis_havalimani_adi, varis_havalimani_adi, ucak_model);
	                
	                ucusDetayList.add(ucusDetay);
	            }
	           
	            cstmt.close();
	            rs.close();
	            return ucusDetayList;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return ucusDetayList;
	    
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
	public int getBos_koltuk_sayisi() {
		return bos_koltuk_sayisi;
	}
	public void setBos_koltuk_sayisi(int bos_koltuk_sayisi) {
		this.bos_koltuk_sayisi = bos_koltuk_sayisi;
	}
	public Date getVaris_tarihi() {
		return varis_tarihi;
	}
	public void setVaris_tarihi(Date varis_tarihi) {
		this.varis_tarihi = varis_tarihi;
	}
	public Date getKalkis_tarihi() {
		return kalkis_tarihi;
	}
	public void setKalkis_tarihi(Date kalkis_tarihi) {
		this.kalkis_tarihi = kalkis_tarihi;
	}
	public String getKalkis_havalimani_adi() {
		return kalkis_havalimani_adi;
	}
	public void setKalkis_havalimani_adi(String kalkis_havalimani_adi) {
		this.kalkis_havalimani_adi = kalkis_havalimani_adi;
	}
	public String getVaris_havalimani_adi() {
		return varis_havalimani_adi;
	}
	public void setVaris_havalimani_adi(String varis_havalimani_adi) {
		this.varis_havalimani_adi = varis_havalimani_adi;
	}
	public String getUcak_model() {
		return ucak_model;
	}
	public void setUcak_model(String ucak_model) {
		this.ucak_model = ucak_model;
	}

	
	
}
