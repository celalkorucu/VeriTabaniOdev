package library;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Pilot {

	int id ;
	String ad ,soyad ,tcno,email,telno,ehliyet;
	DatabaseCoonection con = new DatabaseCoonection();
	
	
	public Pilot(int id , String ad  , String soyad , String tcno , String email , String telno, String ehliyet) {
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.tcno=tcno;
		this.email=email;
		this.telno=telno;
		this.ehliyet=ehliyet;
	}
	
	public Pilot( String ad  , String soyad , String tcno , String email , String telno, String ehliyet) {
		this.ad=ad;
		this.soyad=soyad;
		this.tcno=tcno;
		this.email=email;
		this.telno=telno;
		this.ehliyet=ehliyet;
	}
	
	public Pilot() {
		
	}
	
	public boolean PilotEkle(Pilot pilot) {

		
		String sorgu = "INSERT INTO pilotlar (ad,soyad,tcno,email,telno,ehliyet_tipi) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = con.getCon().prepareStatement(sorgu);
			 // Parametreleri belirleme
            preparedStatement.setString(1, pilot.getAd());
            preparedStatement.setString(2, pilot.getSoyad());
            preparedStatement.setString(3, pilot.getTcno());
            preparedStatement.setString(4, pilot.getEmail());
            preparedStatement.setString(5, pilot.getTelno());
            preparedStatement.setString(6, pilot.getEhliyet());

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
		return false;
		
	}
	
	
	public ArrayList<Pilot> PilotlariGetir(){
		
		ArrayList<Pilot> pilotList = new ArrayList<>();
		String sorgu = "SELECT*FROM pilotlar";
		
		try {
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			
			while(rs.next()) {
				int ID = rs.getInt("pilot_id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String tcno = rs.getString("tcno");
				String email = rs.getString("email");
				String telno = rs.getString("telno");
				String ehliyet_tipi = rs.getString("ehliyet_tipi");

				
				Pilot pilot  = new Pilot(ID,ad,soyad, tcno, email, telno, ehliyet_tipi);
				pilotList.add(pilot);
			}
			
			st.close();
			rs.close();
			return pilotList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
		
	}
	
	
	public boolean ProsedurPilotEkle(Pilot pilot) {
		
		String sqlProsedur = "{ call pilot_ekle(?, ?,?,?,?,?) }";
        try {
        	CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
            callableStatement.setString(1, pilot.getAd());
            callableStatement.setString(2, pilot.getSoyad());
            callableStatement.setString(3, pilot.getTcno());
            callableStatement.setString(4, pilot.getEmail());
            callableStatement.setString(5, pilot.getTelno());
            callableStatement.setString(6, pilot.getEhliyet());


            // Prosedürü çaðýr
            callableStatement.execute();
            System.out.println("Pilot eklendi.");
            return true ;
        }catch (Exception e) {
			e.printStackTrace();
		}
        return false ;
	}
	
	
	public ArrayList<Pilot> ProsedurPilotlariListele() {
	    ArrayList<Pilot> pilotList = new ArrayList<>();
	    String sorgu = "call pilotlari_listele";
	    
	    try {
	        CallableStatement cstmt = con.getCon().prepareCall(sorgu);
	        ResultSet rs = cstmt.executeQuery();

	        while (rs.next()) {
	            int ID = rs.getInt("pilot_id");
	            String ad = rs.getString("ad");
	            String soyad = rs.getString("soyad");
	            String tcno = rs.getString("tcno");
	            String email = rs.getString("email");
	            String telno = rs.getString("telno");
	            String ehliyet_tipi = rs.getString("ehliyet_tipi");

	            Pilot pilot = new Pilot(ID, ad, soyad, tcno, email, telno, ehliyet_tipi);
	            pilotList.add(pilot);
	        }

	        cstmt.close();
	        rs.close();
	        return pilotList;
	    } catch (SQLException e) {
	        // Hata durumunda iþlemler
	        e.printStackTrace();
	    }
	    return null;
	}

	public  ArrayList<String> ProsedurPilotIDleriListele() {
		
        ArrayList<String> PilotIDleri = new ArrayList<>();
        String sorgu = "{call pilot_idleri_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String guzergah_id = rs.getString("pilot_id");
                PilotIDleri.add(guzergah_id);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return PilotIDleri;
    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getEhliyet() {
		return ehliyet;
	}
	public void setEhliyet(String ehliyet) {
		this.ehliyet = ehliyet;
	}
	
	
	
}
