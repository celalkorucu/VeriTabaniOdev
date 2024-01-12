package library;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Guzergah {

	int id;
	Date kalkis_tarihi, varis_tarihi;
	int mesafe, sure;
	int kalkis_havalimani_kod, varis_havalimani_kod;
	DatabaseCoonection con = new DatabaseCoonection();

	public Guzergah(Date kalkisSelectedDate, Date varisSelectedDate, int mesafe, int sure, int kalkis_havalimani_kod,
			int varis_havalimani_kod) {

		this.kalkis_tarihi = kalkisSelectedDate;
		this.varis_tarihi = varisSelectedDate;
		this.mesafe = mesafe;
		this.sure = sure;
		this.kalkis_havalimani_kod = kalkis_havalimani_kod;
		this.varis_havalimani_kod = varis_havalimani_kod;
	}
	
	public Guzergah() {
		
	}

	public Guzergah(int id, Date kalkis_tarihi, Date varis_tarihi, int mesafe, int sure, int kalkis_havalimani_kod,
			int varis_havalimani_kod) {
		this.id = id;
		this.kalkis_tarihi = kalkis_tarihi;
		this.varis_tarihi = varis_tarihi;
		this.mesafe = mesafe;
		this.sure = sure;
		this.kalkis_havalimani_kod = kalkis_havalimani_kod;
		this.varis_havalimani_kod = varis_havalimani_kod;
	}

	public  boolean guzergahEkle(Guzergah guzergah) throws ParseException {
		String sorgu = "{call guzargah_ekle(?, ?, ?, ?, ?, ?)}";
		
		 String formatPattern = "dd/MM/yyyy"; 

	        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
	        
	    
		try {
			
		  
			CallableStatement cstmt = con.getCon().prepareCall(sorgu);

	       
			cstmt.setDate(1, guzergah.kalkis_tarihi);
			cstmt.setDate(2, guzergah.varis_tarihi);
			cstmt.setInt(3, guzergah.mesafe);
			cstmt.setInt(4, guzergah.sure);
			cstmt.setInt(5, guzergah.kalkis_havalimani_kod);
			cstmt.setInt(6, guzergah.varis_havalimani_kod);

 			boolean sonuc = cstmt.execute();
			cstmt.close();

			return !sonuc; // Eðer sorgu çalýþtýysa true döner, çalýþmadýysa false döner

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Guzergah> guzergahlariListele(){
		String sorgu = "call guzargahlari_listele";
		ArrayList<Guzergah> guzergahList = new ArrayList<>();
		try {
	        CallableStatement cstmt = con.getCon().prepareCall(sorgu);
	        ResultSet rs = cstmt.executeQuery();

	        while (rs.next()) {
	            int ID = rs.getInt("guzergah_id");
	            Date kalkis_tarihi = rs.getDate("kalkis_tarihi");
	            Date varis_tarihi = rs.getDate("varis_tarihi");
	            int mesafe = rs.getInt("mesafe");
	            int sure = rs.getInt("sure");
	            int kalkis_havalimani_kodu = rs.getInt("kalkis_havalimani_kodu");
	            int varis_havalimani_kodu = rs.getInt("varis_havalimani_kodu");


	            Guzergah guzergah = new Guzergah(ID,kalkis_tarihi, varis_tarihi, mesafe, sure, kalkis_havalimani_kodu, varis_havalimani_kodu);
	            guzergahList.add(guzergah);
	        }

	        cstmt.close();
	        rs.close();
	        return guzergahList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return null ;
	}

	
	public  ArrayList<String> ProsedurGuzergahIDleriListele() {
		
        ArrayList<String> guzergahIDleri = new ArrayList<>();
        String sorgu = "{call guzergah_idleri_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String guzergah_id = rs.getString("guzergah_id");
                guzergahIDleri.add(guzergah_id);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guzergahIDleri;
    }
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMesafe() {
		return mesafe;
	}

	public void setMesafe(int mesafe) {
		this.mesafe = mesafe;
	}

	public int getSure() {
		return sure;
	}

	public void setSure(int sure) {
		this.sure = sure;
	}

	public int getKalkis_havalimani_kod() {
		return kalkis_havalimani_kod;
	}

	public void setKalkis_havalimani_kod(int kalkis_havalimani_kod) {
		this.kalkis_havalimani_kod = kalkis_havalimani_kod;
	}

	public int getVaris_havalimani_kod() {
		return varis_havalimani_kod;
	}

	public void setVaris_havalimani_kod(int varis_havalimani_kod) {
		this.varis_havalimani_kod = varis_havalimani_kod;
	}
}
