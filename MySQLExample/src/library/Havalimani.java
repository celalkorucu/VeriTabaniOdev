package library;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Havalimani {

	int kod ;
	String ad , sehir,ulke;
	DatabaseCoonection con = new DatabaseCoonection();
	
	public Havalimani() {
		
	}
	public Havalimani(int kod , String ad , String sehir , String ulke) {
		this.kod = kod ;
		this.ad = ad ;
		this.sehir = sehir;
		this.ulke = ulke ;
	}
	
	public boolean HavalimaniEkle(Havalimani havalimani) {
		
		String sorgu = "INSERT INTO havalimanlari(havalimani_kodu , havalimani_adi,sehir,ulke) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = con.getCon().prepareStatement(sorgu);
			preparedStatement.setInt(1, havalimani.getKod());
            preparedStatement.setString(2, havalimani.getAd());
            preparedStatement.setString(3, havalimani.getSehir());
            preparedStatement.setString(4, havalimani.getUlke());


            // Sorguyu çalýþtýrma
            int affectedRows = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (affectedRows > 0) {
                System.out.println("Veri eklendi!");
                return true ;
            } else {
                System.out.println("Veri eklenemedi!");
                return false ;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
	}

	
	public ArrayList<Havalimani> HavalimanlariniGetir(){
		
		ArrayList<Havalimani> havalimaniList = new ArrayList<>();
		String sorgu = "SELECT * FROM havalimanlari";
		try {
			Statement statement = con.getCon().createStatement();
			ResultSet rs = statement.executeQuery(sorgu);
			
			while(rs.next()) {
				int kod = rs.getInt("havalimani_kodu");
				String havalimani_ad = rs.getString("havalimani_adi");
				String sehir = rs.getString("sehir");
				String ulke = rs.getString("ulke");
				
				Havalimani havalimani = new Havalimani(kod, havalimani_ad, sehir, ulke);
				
				havalimaniList.add(havalimani);
			}
			
			statement.close();
			rs.close();
			return havalimaniList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}

	
	public boolean ProsedurHavalimaniEkle(Havalimani havalimani) {
		
		String sqlProsedur = "{ call havalimani_ekle(?,?,?,?) }" ;
	    try {
	    	CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
	        callableStatement.setInt(1, havalimani.getKod());
	        callableStatement.setString(2, havalimani.getAd());
	        callableStatement.setString(3, havalimani.getSehir());
	        callableStatement.setString(4, havalimani.getUlke());



	        // Prosedürü çaðýr
	        callableStatement.execute();
	        System.out.println("Havalimaný eklendi.");
	        return true ;
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    return false ;
	}
	
	
	public ArrayList<Havalimani> ProsedurHavalimaniListele(){
		
		ArrayList<Havalimani> havalimaniList = new ArrayList<>();
		String sorgu = "call havalimanlari_listele";
		try {
		    CallableStatement cstmt = con.getCon().prepareCall(sorgu);
		    ResultSet rs = cstmt.executeQuery();

		    while (rs.next()) {
		        int kod = rs.getInt("havalimani_kodu");
		        String havalimani_ad = rs.getString("havalimani_adi");
		        String sehir = rs.getString("sehir");
		        String ulke = rs.getString("ulke");

		        Havalimani havalimani = new Havalimani(kod, havalimani_ad, sehir, ulke);

		        havalimaniList.add(havalimani);
		    }

		    cstmt.close();
		    rs.close();
		    return havalimaniList;
		} catch (SQLException e) {
		    // Handle the exception
		    e.printStackTrace();
		}
		return null;
	}
	
	public  ArrayList<String> prosedurHavalimaniKodlariniListele() {
		
        ArrayList<String> havalimaniKodlari = new ArrayList<>();
        String sorgu = "{call havalimani_kodlarini_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String kod = rs.getString("havalimani_kodu");
                havalimaniKodlari.add(kod);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return havalimaniKodlari;
    }
	
	
	public int getKod() {
		return kod;
	}
	public void setKod(int kod) {
		this.kod = kod;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getUlke() {
		return ulke;
	}
	public void setUlke(String ulke) {
		this.ulke = ulke;
	}
}
