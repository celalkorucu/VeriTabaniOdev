package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {

		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy","root","");
			
			Statement myStat = con.createStatement();
			
			ResultSet pilots = myStat.executeQuery("select * from pilotlar");
			/*
			ResultSet ucuslar = myStat.executeQuery("select*from ucuslar");
			
			//ResultSet guzargahlar = myStat.executeQuery("select*from guzargahlar");
			ResultSet havalimanlarý = myStat.executeQuery("select*from havalimanlari");
			ResultSet musteriler = myStat.executeQuery("select*from musteriler");
			ResultSet ucaklar = myStat.executeQuery("select*from ucaklar");

*/
			
			while(pilots.next()) {
				int id = pilots.getInt("pilot_id");
				String ad = pilots.getString("ad");
				String soyad =pilots.getString("soyad");
				String tcno  = pilots.getString("tcno");
				String email = pilots.getString("email");
				
				System.out.println("ID : "+id);
				System.out.println("Ad : "+ad);
				System.out.println("Soyad : "+soyad);

				System.out.println("T.C : "+tcno);

				System.out.println("Email : "+email);
			}
			
			pilots.close();
			
			
			ResultSet biletler = myStat.executeQuery("select*from biletler");
			
			while(biletler.next()) {
				
				int id = biletler.getInt("bilet_id");
				String koltukNum = biletler.getString("koltuk_numarasi");
				String Date =biletler.getString("satin_alma_tarihi");
				String durum  = biletler.getString("bilet_durumu");
				String mID = biletler.getString("musteri_id");
				String uID = biletler.getString("ucus_id");

				String pID = biletler.getString("pilot_id");

				
				System.out.println("ID : "+id);
				System.out.println("koltuk numarasý : "+koltukNum);
				System.out.println("tarih : "+Date);

				System.out.println("durum : "+durum);

				System.out.println("musteri id : "+mID);
				System.out.println("ucus id : "+uID);

				System.out.println("pilot id : "+pID);

				
			}
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
