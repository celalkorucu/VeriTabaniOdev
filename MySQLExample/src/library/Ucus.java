package library;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DatabaseCoonection;

public class Ucus {

	int id, guzergah_id, bos_koltuk_sayisi, pilot_id, ucak_id, bilet_fiyati;
	DatabaseCoonection con = new DatabaseCoonection();

	public Ucus(int guzergah_id, int pilot_id, int ucak_id, int bilet_fiyati) {
		this.guzergah_id = guzergah_id;
		this.pilot_id = pilot_id;
		this.ucak_id = ucak_id;
		this.bilet_fiyati = bilet_fiyati;
	}
	
	public Ucus() {
		
	}

	public Ucus(int id, int guzergah_id, int bos_koltuk_sayisi, int pilot_id, int ucak_id, int bilet_fiyati) {
		this.id = id ;
		this.guzergah_id = id ;
		this.bos_koltuk_sayisi = bos_koltuk_sayisi;
		this.pilot_id = pilot_id;
		this.ucak_id = ucak_id;
		this.bilet_fiyati = bilet_fiyati;
	}
	
	
	public boolean ProsedurUcusEkle(Ucus ucus) {
		
		String sorgu = "{call ucus_ekle(?,?,?,?)}";
		try {
	    	CallableStatement callableStatement = con.getCon().prepareCall(sorgu);
	        callableStatement.setInt(1, ucus.getBilet_fiyati());
	        callableStatement.setInt(2, ucus.getPilot_id());
	        callableStatement.setInt(3, ucus.getGuzergah_id());
	        callableStatement.setInt(4, ucus.getUcak_id());



	        // Prosedürü çaðýr
	        callableStatement.execute();
	        System.out.println("Uçuþ  eklendi.");
	        return true ;
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    return false ;
	}

	
	public  ArrayList<String> ProsedurUcuslarIDleriListele() {
		
        ArrayList<String> ucusIDleri = new ArrayList<>();
        String sorgu = "{call ucus_idleri_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                String guzergah_id = rs.getString("ucus_id");
                ucusIDleri.add(guzergah_id);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ucusIDleri;
    }

	
	public ArrayList<Ucus> ProsedurUcuslariListele(){
		
		ArrayList<Ucus> ucuslar = new ArrayList<>();
        String sorgu = "{call ucuslari_listele()}";
        try {
        	
            CallableStatement cstmt = con.getCon().prepareCall(sorgu);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                int ucus_id = rs.getInt("ucus_id");
                int bos_koltuk_sayisi = rs.getInt("bos_koltuk_sayisi");

                int bilet_fiyati = rs.getInt("bilet_fiyati");

                int pilot_id  = rs.getInt("pilot_id");
                int guzergah_id  = rs.getInt("guzergah_id");

                int  ucak_id  = rs.getInt("ucak_id");
                
                Ucus ucus = new Ucus(ucus_id, guzergah_id, bos_koltuk_sayisi, pilot_id, ucak_id, bilet_fiyati);

                ucuslar.add(ucus);
            }

            cstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ucuslar;
	}
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public int getGuzergah_id() {
		return guzergah_id;
	}

	public void setGuzergah_id(int guzergah_id) {
		this.guzergah_id = guzergah_id;
	}

	public int getBos_koltuk_sayisi() {
		return bos_koltuk_sayisi;
	}

	public void setBos_koltuk_sayisi(int bos_koltuk_sayisi) {
		this.bos_koltuk_sayisi = bos_koltuk_sayisi;
	}

	public int getPilot_id() {
		return pilot_id;
	}

	public void setPilot_id(int pilot_id) {
		this.pilot_id = pilot_id;
	}

	public int getUcak_id() {
		return ucak_id;
	}

	public void setUcak_id(int ucak_id) {
		this.ucak_id = ucak_id;
	}

	public int getBilet_fiyati() {
		return bilet_fiyati;
	}

	public void setBilet_fiyati(int bilet_fiyati) {
		this.bilet_fiyati = bilet_fiyati;
	}
}
