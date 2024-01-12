package library;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Musteri {

	int id ;
	String  ad , soyad , tcno , email,telno;
	DatabaseCoonection con = new DatabaseCoonection();
	
	public Musteri() {
		
	}
	
	public Musteri(String ad , String soyad , String tcno , String email ,String telno) {
		this.ad=ad;
		this.soyad=soyad;
		this.tcno = tcno;
		this.email=email;
		this.telno = telno;
	}
	public Musteri(int id ,String ad , String soyad , String tcno , String email ,String telno) {
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.tcno = tcno;
		this.email=email;
		this.telno = telno;
	}
	
	
	public boolean MusteriEkle(Musteri musteri) {
		
		String sorgu = "INSERT INTO musteriler (ad,soyad,tcno,email,telefon) VALUES (?,?,?,?,?)";
		try {
			
			PreparedStatement preparedStatement = con.getCon().prepareStatement(sorgu) ;
                // Parametreleri belirleme
                preparedStatement.setString(1, musteri.getAd());
                preparedStatement.setString(2, musteri.getSoyad());
                preparedStatement.setString(3, musteri.getTcno());
                preparedStatement.setString(4, musteri.getEmail());
                preparedStatement.setString(5, musteri.getTelno());


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
			e.printStackTrace();
		}
		
		return false ;
	}

	
	public ArrayList<Musteri> MusterileriGetir(){
		
		ArrayList<Musteri> musteriList = new ArrayList<>();
		
		String sorgu = "SELECT*FROM musteriler";
		
		try {
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			
			while(rs.next()) {
				int ID = rs.getInt("musteri_id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String tcno = rs.getString("tcno");
				String email = rs.getString("email");
				String telno = rs.getString("telefon");
				
				Musteri musteri = new Musteri(ID,ad, soyad, tcno, email, telno);
				musteriList.add(musteri);
			}
			
			st.close();
			rs.close();
			return musteriList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
	}

	
	
	public boolean ProsedurMusteriEkle(Musteri musteri) {
		
		String sqlProsedur = "{ call musteri_ekle(?, ?, ?, ?, ?) }";
		
		try {
			CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
			callableStatement.setString(1, musteri.getAd());
            callableStatement.setString(2, musteri.getSoyad());
            callableStatement.setString(3, musteri.getTcno());
            callableStatement.setString(4, musteri.getEmail());
            callableStatement.setString(5, musteri.getTelno());

            // Prosedürü çaðýr
            callableStatement.execute();
            System.out.println("Müþteri eklendi.");
            return true ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false ;
	}
	
	public ArrayList<Musteri> ProsedurMusterileriGetir() {
	    ArrayList<Musteri> musteriList = new ArrayList<>();
	    String sorgu = "call musterileri_listele";
	    
	    try {
	        CallableStatement cstmt = con.getCon().prepareCall(sorgu);
	        ResultSet rs = cstmt.executeQuery();

	        while (rs.next()) {
	            int ID = rs.getInt("musteri_id");
	            String ad = rs.getString("ad");
	            String soyad = rs.getString("soyad");
	            String tcno = rs.getString("tcno");
	            String email = rs.getString("email");
	            String telno = rs.getString("telefon");

	            Musteri musteri = new Musteri(ID, ad, soyad, tcno, email, telno);
	            musteriList.add(musteri);
	        }

	        cstmt.close();
	        rs.close();
	        return musteriList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	
	public  ArrayList<String> ProsedurMusterilerIDleriListele() {
		
        ArrayList<String> musteriIDleri = new ArrayList<>();
        String sorgu = "{call musteriler_idleri_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String guzergah_id = rs.getString("musteri_id");
                musteriIDleri.add(guzergah_id);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return musteriIDleri;
    }
	
	
	public boolean ProsedurMusteriSil(int musteri_id) {
String sqlProsedur = "{ call musteri_sil(?) }";
		
		try {
			CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
			callableStatement.setInt(1, musteri_id);

            // Prosedürü çaðýr
            callableStatement.execute();
            System.out.println("Müþteri Silindi .");
            return true ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false ;
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
	

}
