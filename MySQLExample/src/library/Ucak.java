package library;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Ucak {

	String model ;
	int kapasite ,id;
	DatabaseCoonection con  = new DatabaseCoonection();
	
	public Ucak() {
		
	}
	public Ucak(String model , int kapasite) {
		this.kapasite=kapasite;
		this.model=model ;
	}
	
	public Ucak(int id , String model , int kapasite) {
		this.id = id ;
		this.model = model ;
		this.kapasite = kapasite;
	}
	
	public boolean UcakEkle(Ucak ucak) {
		String sorgu = "INSERT INTO ucaklar (model,kapasite) VALUES(?,?)";
		
		try {
			PreparedStatement preparedStatement = con.getCon().prepareStatement(sorgu);
			preparedStatement.setString(1, ucak.getModel());
            preparedStatement.setInt(2, ucak.getKapasite());
  

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
	
	public ArrayList<Ucak> UcaklariGetir(){
		ArrayList<Ucak> ucaklarList = new ArrayList<>();
		String sorgu = "SELECT*FROM ucaklar";
		
		try {
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			
			while(rs.next()) {
				int ID = rs.getInt("ucak_id");
				String model = rs.getString("model");
				int kapasite  = rs.getInt("kapasite");
				Ucak ucak = new Ucak(ID,model,kapasite);
				
				ucaklarList.add(ucak);
			}
			return ucaklarList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
		
	}
	
	
	public  ArrayList<String> ProsedurUcakIDleriListele() {
		
        ArrayList<String> UcakIDleri = new ArrayList<>();
        String sorgu = "{call ucak_idleri_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String ucak_id = rs.getString("ucak_id");
                UcakIDleri.add(ucak_id);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return UcakIDleri;
    }
	
	
	
	public boolean ProsedurUcakEkle(Ucak ucak) {
		
		String sqlProsedur = "{ call ucak_ekle(?, ?) }";
        try {
        	CallableStatement callableStatement = con.getCon().prepareCall(sqlProsedur);
            callableStatement.setString(1, ucak.getModel());
            callableStatement.setInt(2, ucak.getKapasite());


            // Prosedürü çaðýr
            callableStatement.execute();
            System.out.println("Uçak eklendi.");
            return true ;
        }catch (Exception e) {
			e.printStackTrace();
		}
        return false ;
	}
	
	
	public ArrayList<Ucak> ProsedurUcaklariListele() {
	    ArrayList<Ucak> ucaklarList = new ArrayList<>();
	    String sorgu = "call ucaklari_listele";
	    
	    try {
	        CallableStatement cstmt = con.getCon().prepareCall(sorgu);
	        ResultSet rs = cstmt.executeQuery();

	        while (rs.next()) {
	            int ID = rs.getInt("ucak_id");
	            String model = rs.getString("model");
	            int kapasite  = rs.getInt("kapasite");
	            Ucak ucak = new Ucak(ID, model, kapasite);

	            ucaklarList.add(ucak);
	        }

	        cstmt.close();
	        rs.close();
	        return ucaklarList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getKapasite() {
		return kapasite;
	}
	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
