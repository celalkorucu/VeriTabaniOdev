package library;

import java.awt.BorderLayout;import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

public class VeriTabaniOdev extends JFrame {

	private JPanel contentPane;
	private JTextField musteri_ad_text;
	private JTextField musteri_soyad_text;
	private JTextField musteri_tc_text;
	private JTextField musteri_telefon_text;
	private JTextField musteri_email_text;
	private JTable musteriler_table;
    DefaultTableModel musteriler_table_model = new DefaultTableModel();
    DefaultTableModel pilotlar_table_model = new DefaultTableModel();
    DefaultTableModel havalimanlari_table_model = new DefaultTableModel();
    DefaultTableModel ucaklar_table_model = new DefaultTableModel();
    DefaultTableModel guzergah_table_model = new DefaultTableModel();
    DefaultTableModel ucuslar_table_model = new DefaultTableModel();


    DefaultTableModel biletler_musteriler_table_model = new DefaultTableModel();
    DefaultTableModel biletler_ucuslar_table_model = new DefaultTableModel();
    DefaultTableModel biletler_table_model = new DefaultTableModel();


    private JTextField pilotlar_telno_text;
    private JTextField pilotlar_email_text;
    private JTextField pilotlar_tcno_text;
    private JTextField pilotlar_soyad_text;
    private JTextField pilotlar_ad_text;
    private JTable pilotlar_table;
    private JTextField havalimani_kod;
    private JTextField havalimani_ad;
    private JTextField havalimani_sehir;
    private JTextField havalimani_ulke;
    private JTable havalimani_table;
    private JTextField ucaklar_model_text;
    private JTextField ucaklar_kapasite_txt;
    private JTable ucaklar_table;
    private JTextField guzergahlar_mesafe_text;
    private JTextField guzergahlar_sure_text;
    private JTable guzergahlar_table;
    private JTextField ucuslar_bilet_fiyat;
    private JTable ucuslar_table;
    private JTable biletler_musteriler_table;
    private JTable biletler_ucuslar_table;
    private JTable biletler_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeriTabaniOdev frame = new VeriTabaniOdev();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VeriTabaniOdev() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		tabbedPane.setBounds(0, 0, 884, 461);
		contentPane.add(tabbedPane);
		
		JPanel musteriler = new JPanel();
		musteriler.setBackground(Color.WHITE);
		tabbedPane.addTab("Muþteriler", null, musteriler, null);
		musteriler.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad : ");
		lblNewLabel.setBounds(10, 11, 100, 30);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		musteriler.add(lblNewLabel);
		
		musteri_ad_text = new JTextField();
		musteri_ad_text.setBounds(90, 16, 150, 30);
		musteriler.add(musteri_ad_text);
		musteri_ad_text.setColumns(10);
		
		JLabel lblSoyad = new JLabel("Soyad : ");
		lblSoyad.setBounds(10, 57, 100, 30);
		lblSoyad.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		musteriler.add(lblSoyad);
		
		musteri_soyad_text = new JTextField();
		musteri_soyad_text.setBounds(90, 57, 150, 30);
		musteri_soyad_text.setColumns(10);
		musteriler.add(musteri_soyad_text);
		
		JLabel lblTc = new JLabel("TC : ");
		lblTc.setBounds(10, 112, 100, 30);
		lblTc.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		musteriler.add(lblTc);
		
		musteri_tc_text = new JTextField();
		musteri_tc_text.setBounds(90, 112, 150, 30);
		musteri_tc_text.setColumns(10);
		musteriler.add(musteri_tc_text);
		
		JLabel lblTelefon = new JLabel("Telefon : ");
		lblTelefon.setBounds(10, 167, 100, 30);
		lblTelefon.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		musteriler.add(lblTelefon);
		
		musteri_telefon_text = new JTextField();
		musteri_telefon_text.setBounds(90, 167, 150, 30);
		musteri_telefon_text.setColumns(10);
		musteriler.add(musteri_telefon_text);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(10, 232, 100, 30);
		lblEmail.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		musteriler.add(lblEmail);
		
		musteri_email_text = new JTextField();
		musteri_email_text.setBounds(90, 232, 150, 30);
		musteri_email_text.setColumns(10);
		musteriler.add(musteri_email_text);
		
		String[] columnNames = {"ID", "Ad", "Soyad" ,"TC" , "Email" , "Tel No"};
		musteriler_table_model.setColumnIdentifiers(columnNames);

		Musteri musteri2 = new Musteri();
		Object [] musteriData = new Object[6];
		for (Musteri musteri : musteri2.ProsedurMusterileriGetir()) {
	
			musteriData[0] = musteri.getId();
			musteriData[1] = musteri.getAd();
			musteriData[2] = musteri.getSoyad();
			musteriData[3] = musteri.getTcno();
			musteriData[4] = musteri.getEmail();
			musteriData[5] = musteri.getTelno();

			musteriler_table_model.addRow(musteriData);
		}
		
		JButton musteri_ekle_button = new JButton("EKLE");
		//MÜÞTERÝ EKLE BUTTON CLÝCK LÝSTENER
		
		musteri_ekle_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Veri tabanýna veri ekleme metodu
				String musteri_ad  = musteri_ad_text.getText();
				String musteri_soyad = musteri_soyad_text.getText();
				String musteri_tcno = musteri_tc_text.getText();
				String musteri_email = musteri_email_text.getText();
				String musteri_telno = musteri_telefon_text.getText();
				
				Musteri musteri = new Musteri(musteri_ad, musteri_soyad, musteri_tcno, musteri_email, musteri_telno);
				musteri.ProsedurMusteriEkle(musteri);
				
				
				Musteri musteri2 = new Musteri();
				Object [] musteriData = new Object[6];
				musteriler_table_model.setRowCount(0);
				for (Musteri listMusteri : musteri2.ProsedurMusterileriGetir()) {
			
					musteriData[0] = listMusteri.getId();
					musteriData[1] = listMusteri.getAd();
					musteriData[2] = listMusteri.getSoyad();
					musteriData[3] = listMusteri.getTcno();
					musteriData[4] = listMusteri.getEmail();
					musteriData[5] = listMusteri.getTelno();

					musteriler_table_model.addRow(musteriData);
				}
				
				
			}
		});
		musteri_ekle_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_ekle_button.setBounds(90, 287, 150, 40);
		musteriler.add(musteri_ekle_button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 11, 620, 315);
		musteriler.add(scrollPane);
		
		musteriler_table = new JTable(musteriler_table_model);
		musteriler_table.setBackground(Color.WHITE);
		scrollPane.setViewportView(musteriler_table);
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < musteriler_table.getColumnCount(); i++) {
            musteriler_table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
		
		musteriler_table.setRowHeight(40);
		
		JLabel lblMteriSil = new JLabel("M\u00FC\u015Fteri Sil : ");
		lblMteriSil.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblMteriSil.setBounds(486, 380, 124, 40);
		musteriler.add(lblMteriSil);
		
		JComboBox<String> musteriler_silinecek_idler_cb = new JComboBox<String>();
		musteriler_silinecek_idler_cb.setBounds(609, 380, 100, 40);
		musteriler.add(musteriler_silinecek_idler_cb);
		

        DefaultComboBoxModel<String> musterisilcbmodel = new DefaultComboBoxModel<>();


        
        for(int i = 0 ; i<musteri2.ProsedurMusterilerIDleriListele().size() ; i++) {
        	musterisilcbmodel.addElement(musteri2.ProsedurMusterilerIDleriListele().get(i));
        }

        musteriler_silinecek_idler_cb.setModel(musterisilcbmodel);
		
		
		JButton musteri_sil_button = new JButton("S\u0130L");
		musteri_sil_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selinecek_id = Integer.parseInt(musteriler_silinecek_idler_cb.getSelectedItem().toString());
				musteri2.ProsedurMusteriSil(selinecek_id);
				
				
				Musteri musteri2 = new Musteri();
				Object [] musteriData = new Object[6];
				musteriler_table_model.setRowCount(0);
				for (Musteri listMusteri : musteri2.ProsedurMusterileriGetir()) {
			
					musteriData[0] = listMusteri.getId();
					musteriData[1] = listMusteri.getAd();
					musteriData[2] = listMusteri.getSoyad();
					musteriData[3] = listMusteri.getTcno();
					musteriData[4] = listMusteri.getEmail();
					musteriData[5] = listMusteri.getTelno();

					musteriler_table_model.addRow(musteriData);
				}
				
			}
		});
		musteri_sil_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_sil_button.setBounds(719, 380, 150, 40);
		musteriler.add(musteri_sil_button);
		
		JButton musteri_sil_button_1 = new JButton("G\u00FCncelle");
		musteri_sil_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		musteri_sil_button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_sil_button_1.setBounds(719, 329, 150, 40);
		musteriler.add(musteri_sil_button_1);
		
		JComboBox<String> musteriler_guncellenecek_idler_cb = new JComboBox<String>();
		musteriler_guncellenecek_idler_cb.setBounds(609, 329, 100, 40);
		musteriler.add(musteriler_guncellenecek_idler_cb);
		
		
		
		JLabel lblMteriSil_1 = new JLabel("M\u00FC\u015Fteri G\u00FCncelle : ");
		lblMteriSil_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblMteriSil_1.setBounds(426, 329, 173, 40);
		musteriler.add(lblMteriSil_1);
		musteriler_table.getColumnModel().getColumn(0).setPreferredWidth(6);
		musteriler_table.getColumnModel().getColumn(1).setPreferredWidth(60);
		musteriler_table.getColumnModel().getColumn(2).setPreferredWidth(60);

        DefaultComboBoxModel<String> musteriguncellecbmodel = new DefaultComboBoxModel<>();

		for(int i = 0 ; i<musteri2.ProsedurMusterilerIDleriListele().size() ; i++) {
			musteriguncellecbmodel.addElement(musteri2.ProsedurMusterilerIDleriListele().get(i));
        }

        musteriler_guncellenecek_idler_cb.setModel(musteriguncellecbmodel);
		


		
		
		
		JPanel pilotlar = new JPanel();
		pilotlar.setBackground(Color.WHITE);
		tabbedPane.addTab("Pilotlar", null, pilotlar, null);
		pilotlar.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad : ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 100, 30);
		pilotlar.add(lblNewLabel_1);
		
		JLabel lblSoyad_1 = new JLabel("Soyad : ");
		lblSoyad_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblSoyad_1.setBounds(10, 57, 100, 30);
		pilotlar.add(lblSoyad_1);
		
		JLabel lblTc_1 = new JLabel("TC : ");
		lblTc_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblTc_1.setBounds(10, 98, 100, 30);
		pilotlar.add(lblTc_1);
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblEmail_1.setBounds(10, 148, 100, 30);
		pilotlar.add(lblEmail_1);
		
		JLabel lblTelNo = new JLabel("Tel No : ");
		lblTelNo.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblTelNo.setBounds(10, 203, 100, 30);
		pilotlar.add(lblTelNo);
		
		JLabel lblEhliyetTipi = new JLabel("Ehliyet T.: ");
		lblEhliyetTipi.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblEhliyetTipi.setBounds(10, 244, 130, 30);
		pilotlar.add(lblEhliyetTipi);
		
		pilotlar_telno_text = new JTextField();
		pilotlar_telno_text.setColumns(10);
		pilotlar_telno_text.setBounds(90, 203, 150, 30);
		pilotlar.add(pilotlar_telno_text);
		
		pilotlar_email_text = new JTextField();
		pilotlar_email_text.setColumns(10);
		pilotlar_email_text.setBounds(90, 148, 150, 30);
		pilotlar.add(pilotlar_email_text);
		
		pilotlar_tcno_text = new JTextField();
		pilotlar_tcno_text.setColumns(10);
		pilotlar_tcno_text.setBounds(90, 98, 150, 30);
		pilotlar.add(pilotlar_tcno_text);
		
		pilotlar_soyad_text = new JTextField();
		pilotlar_soyad_text.setColumns(10);
		pilotlar_soyad_text.setBounds(90, 57, 150, 30);
		pilotlar.add(pilotlar_soyad_text);
		
		pilotlar_ad_text = new JTextField(); 
		pilotlar_ad_text.setColumns(10);
		pilotlar_ad_text.setBounds(90, 11, 150, 30);
		pilotlar.add(pilotlar_ad_text);
		
		JComboBox<String> pilotlar_ehliyet_tipi_text = new JComboBox<String>();
		pilotlar_ehliyet_tipi_text.setBounds(90, 244, 150, 30);
		pilotlar.add(pilotlar_ehliyet_tipi_text);
		
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        comboBoxModel.addElement("PPL");
        comboBoxModel.addElement("ATPL");
        comboBoxModel.addElement("CPL");
        comboBoxModel.addElement("IFR");
        comboBoxModel.addElement("ME");

        pilotlar_ehliyet_tipi_text.setModel(comboBoxModel);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(249, 11, 620, 315);
		pilotlar.add(scrollPane_1);
		
		
		String[] pilot_table_colums = {"ID", "Ad", "Soyad" ,"TC" , "Email" , "Tel No","Ehliyet T."};
		pilotlar_table_model.setColumnIdentifiers(pilot_table_colums);

		
		Pilot pilot = new Pilot();
		Object [] pilotData = new Object[7];
		for (Pilot pilot2 : pilot.ProsedurPilotlariListele()) {
	
			pilotData[0] = pilot2.getId();
			pilotData[1] = pilot2.getAd();
			pilotData[2] = pilot2.getSoyad();
			pilotData[3] = pilot2.getTcno();
			pilotData[4] = pilot2.getEmail();
			pilotData[5] = pilot2.getTelno();
			pilotData[6] = pilot2.getEhliyet();

			pilotlar_table_model.addRow(pilotData);
		}
		
		
		
		//PÝLOTLAR EKLE BUTTON CLÝCK
		JButton pilotlar_ekle_button = new JButton("EKLE");
		pilotlar_ekle_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pilot_ad = pilotlar_ad_text.getText();
				String pilot_soyad = pilotlar_soyad_text.getText();
				String pilot_tcno = pilotlar_tcno_text.getText();
				String pilot_email = pilotlar_email_text.getText();
				String pilot_telno = pilotlar_telno_text.getText();
				String pilot_ehliyet = pilotlar_ehliyet_tipi_text.getSelectedItem().toString();
				
				Pilot addedPilot = new Pilot(pilot_ad,pilot_soyad,pilot_tcno,pilot_email,pilot_telno,pilot_ehliyet);
				addedPilot.ProsedurPilotEkle(addedPilot);
				
				
				Pilot pilot = new Pilot();
				Object [] pilotData = new Object[7];
				pilotlar_table_model.setRowCount(0);
				for (Pilot pilot2 : pilot.ProsedurPilotlariListele()) {
			
					pilotData[0] = pilot2.getId();
					pilotData[1] = pilot2.getAd();
					pilotData[2] = pilot2.getSoyad();
					pilotData[3] = pilot2.getTcno();
					pilotData[4] = pilot2.getEmail();
					pilotData[5] = pilot2.getTelno();
					pilotData[6] = pilot2.getEhliyet();

					pilotlar_table_model.addRow(pilotData);
				}
				
			}
		});
		
		
		pilotlar_table = new JTable(pilotlar_table_model);
		scrollPane_1.setViewportView(pilotlar_table);
		
		
		DefaultTableCellRenderer pilot_CenterRenderer = new DefaultTableCellRenderer();
		pilot_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < pilotlar_table.getColumnCount(); i++) {
        	pilotlar_table.getColumnModel().getColumn(i).setCellRenderer(pilot_CenterRenderer);
        }
		
		
		
		
		pilotlar_table.setRowHeight(40);
		pilotlar_table.getColumnModel().getColumn(0).setPreferredWidth(6);
		pilotlar_table.getColumnModel().getColumn(1).setPreferredWidth(60);
		pilotlar_table.getColumnModel().getColumn(2).setPreferredWidth(60);
		pilotlar_table.getColumnModel().getColumn(6).setPreferredWidth(10);

		
		pilotlar_ekle_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		pilotlar_ekle_button.setBounds(90, 286, 150, 40);
		pilotlar.add(pilotlar_ekle_button);
		
		JLabel lblMteriSil_1_1 = new JLabel("Pilot G\u00FCncelle : ");
		lblMteriSil_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblMteriSil_1_1.setBounds(462, 336, 143, 40);
		pilotlar.add(lblMteriSil_1_1);
		
		JComboBox musteriler_idler_cb_1_1 = new JComboBox();
		musteriler_idler_cb_1_1.setBounds(609, 336, 100, 40);
		pilotlar.add(musteriler_idler_cb_1_1);
		
		JButton musteri_sil_button_1_1 = new JButton("G\u00FCncelle");
		musteri_sil_button_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_sil_button_1_1.setBounds(719, 336, 150, 40);
		pilotlar.add(musteri_sil_button_1_1);
		
		JButton musteri_sil_button_2 = new JButton("S\u0130L");
		musteri_sil_button_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_sil_button_2.setBounds(719, 387, 150, 40);
		pilotlar.add(musteri_sil_button_2);
		
		JComboBox musteriler_idler_cb_2 = new JComboBox();
		musteriler_idler_cb_2.setBounds(609, 387, 100, 40);
		pilotlar.add(musteriler_idler_cb_2);
		
		JLabel lblPilotSil = new JLabel("Pilot Sil : ");
		lblPilotSil.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblPilotSil.setBounds(462, 387, 137, 40);
		pilotlar.add(lblPilotSil);
		
		JPanel havalimanlari = new JPanel();
		havalimanlari.setBackground(Color.WHITE);
		tabbedPane.addTab("Hava Limanlarý", null, havalimanlari, null);
		havalimanlari.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kod : ");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 11, 100, 30);
		havalimanlari.add(lblNewLabel_1_1);
		
		havalimani_kod = new JTextField();
		havalimani_kod.setColumns(10);
		havalimani_kod.setBounds(110, 11, 150, 30);
		havalimanlari.add(havalimani_kod);
		
		havalimani_ad = new JTextField();
		havalimani_ad.setColumns(10);
		havalimani_ad.setBounds(110, 71, 150, 30);
		havalimanlari.add(havalimani_ad);
		
		JLabel lblSoyad_1_1 = new JLabel("Ad : ");
		lblSoyad_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblSoyad_1_1.setBounds(10, 72, 100, 30);
		havalimanlari.add(lblSoyad_1_1);
		
		JLabel lblTc_1_1 = new JLabel("\u015Eehir : ");
		lblTc_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblTc_1_1.setBounds(10, 127, 100, 30);
		havalimanlari.add(lblTc_1_1);
		
		havalimani_sehir = new JTextField();
		havalimani_sehir.setColumns(10);
		havalimani_sehir.setBounds(110, 132, 150, 30);
		havalimanlari.add(havalimani_sehir);
		
		havalimani_ulke = new JTextField();
		havalimani_ulke.setColumns(10);
		havalimani_ulke.setBounds(110, 177, 150, 30);
		havalimanlari.add(havalimani_ulke);
		
		JLabel lblEmail_1_1 = new JLabel("\u00DClke : ");
		lblEmail_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblEmail_1_1.setBounds(10, 177, 100, 30);
		havalimanlari.add(lblEmail_1_1);
		
		
		String[] havalimani_table_colums = {"H.Kod", "H.Ad", "Þehir" ,"Ülke"};
		havalimanlari_table_model.setColumnIdentifiers(havalimani_table_colums);
		
		Havalimani havalimani = new Havalimani();
		Object [] havalimaniData = new Object[4];
		for (Havalimani havalimani2 : havalimani.ProsedurHavalimaniListele()) {
	
			havalimaniData[0] = havalimani2.getKod();
			havalimaniData[1] = havalimani2.getAd();
			havalimaniData[2] = havalimani2.getSehir();
			havalimaniData[3] = havalimani2.getUlke();
	

			havalimanlari_table_model.addRow(havalimaniData);
		}
		
		
		JButton havalimani_ekle_button = new JButton("EKLE");
		havalimani_ekle_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int kod = Integer.parseInt(havalimani_kod.getText());
				String Shavalimani_ad = havalimani_ad.getText();
				String Shavalimani_sehir = havalimani_sehir.getText();
				String Shavalimani_ulke = havalimani_ulke.getText();
				
				Havalimani addedHavalimani = new Havalimani(kod,Shavalimani_ad,Shavalimani_sehir,Shavalimani_ulke);
				addedHavalimani.ProsedurHavalimaniEkle(addedHavalimani);
				
				
				havalimanlari_table_model.setRowCount(0);
				Havalimani havalimani = new Havalimani();
				Object [] havalimaniData = new Object[4];
				for (Havalimani havalimani2 : havalimani.ProsedurHavalimaniListele()) {
			
					havalimaniData[0] = havalimani2.getKod();
					havalimaniData[1] = havalimani2.getAd();
					havalimaniData[2] = havalimani2.getSehir();
					havalimaniData[3] = havalimani2.getUlke();
			

					havalimanlari_table_model.addRow(havalimaniData);
				}
			}
		});
		
		
		
		
	

		
		havalimani_ekle_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		havalimani_ekle_button.setBounds(110, 343, 150, 40);
		havalimanlari.add(havalimani_ekle_button);
		
		JScrollPane havalimani_scroll_pane = new JScrollPane();
		havalimani_scroll_pane.setBounds(274, 11, 595, 405);
		havalimanlari.add(havalimani_scroll_pane);
		
		havalimani_table = new JTable(havalimanlari_table_model);
		havalimani_scroll_pane.setViewportView(havalimani_table);
		
		
		DefaultTableCellRenderer havalimani_CenterRenderer = new DefaultTableCellRenderer();
		havalimani_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < havalimani_table.getColumnCount(); i++) {
        	havalimani_table.getColumnModel().getColumn(i).setCellRenderer(havalimani_CenterRenderer);
        }
		
		
		havalimani_table.setRowHeight(40);
		havalimani_table.getColumnModel().getColumn(0).setPreferredWidth(6);
		
		
		JPanel ucaklar = new JPanel();
		ucaklar.setBackground(Color.WHITE);
		tabbedPane.addTab("Uçaklar", null, ucaklar, null);
		ucaklar.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Model : ");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 11, 100, 30);
		ucaklar.add(lblNewLabel_1_1_1);
		
		ucaklar_model_text = new JTextField();
		ucaklar_model_text.setColumns(10);
		ucaklar_model_text.setBounds(110, 11, 150, 30);
		ucaklar.add(ucaklar_model_text);
		
		ucaklar_kapasite_txt = new JTextField();
		ucaklar_kapasite_txt.setColumns(10);
		ucaklar_kapasite_txt.setBounds(110, 70, 150, 30);
		ucaklar.add(ucaklar_kapasite_txt);
		
		JLabel lblSoyad_1_1_1 = new JLabel("Kapasite : ");
		lblSoyad_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblSoyad_1_1_1.setBounds(10, 70, 100, 30);
		ucaklar.add(lblSoyad_1_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(274, 11, 595, 405);
		ucaklar.add(scrollPane_2);
		
		
		
		
		String[] ucak_table_colums = {"ID", "Model", "Kapasite" };
		ucaklar_table_model.setColumnIdentifiers(ucak_table_colums);
		
		Ucak ucak = new Ucak();
		Object [] ucakData = new Object[3];
		for (Ucak ucak2 : ucak.ProsedurUcaklariListele()) {
	
			ucakData[0] = ucak2.getId();
			ucakData[1] = ucak2.getModel();
			ucakData[2] = ucak2.getKapasite();
	

			ucaklar_table_model.addRow(ucakData);
		}
		
		
		
		
		
		JButton ucak_ekle_button = new JButton("EKLE");
		ucak_ekle_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ucak_model  = ucaklar_model_text.getText();
				int ucak_kapasite = Integer.parseInt(ucaklar_kapasite_txt.getText());
				
				Ucak addedUcak = new Ucak(ucak_model, ucak_kapasite);
				addedUcak.ProsedurUcakEkle(addedUcak);				
				ucaklar_table_model.setRowCount(0);
				Ucak ucak = new Ucak();
				Object [] ucakData = new Object[3];
				for (Ucak ucak2 : ucak.ProsedurUcaklariListele()) {
			
					ucakData[0] = ucak2.getId();
					ucakData[1] = ucak2.getModel();
					ucakData[2] = ucak2.getKapasite();
			

					ucaklar_table_model.addRow(ucakData);
				}
				
			}
		});
		
		
		
		
		
		ucaklar_table = new JTable(ucaklar_table_model);
		scrollPane_2.setViewportView(ucaklar_table);
		
		
		
		DefaultTableCellRenderer ucak_CenterRenderer = new DefaultTableCellRenderer();
		ucak_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < ucaklar_table.getColumnCount(); i++) {
        	ucaklar_table.getColumnModel().getColumn(i).setCellRenderer(ucak_CenterRenderer);
        }
		
		
		ucaklar_table.setRowHeight(40);
		ucaklar_table.getColumnModel().getColumn(0).setPreferredWidth(6);
		ucaklar_table.getColumnModel().getColumn(1).setPreferredWidth(160);

		ucaklar_table.getColumnModel().getColumn(2).setPreferredWidth(60);

		
		
		ucak_ekle_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		ucak_ekle_button.setBounds(110, 155, 150, 40);
		ucaklar.add(ucak_ekle_button);
		
		JPanel biletal = new JPanel();
		biletal.setBackground(Color.WHITE);
		tabbedPane.addTab("Bilet Al", null, biletal, null);
		biletal.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("M\u00FC\u015Fteri ID : ");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 11, 120, 30);
		biletal.add(lblNewLabel_1_1_1_1);
		
		JComboBox<String> biletler_musteri_idler_cb = new JComboBox<String>();
		biletler_musteri_idler_cb.setBounds(140, 11, 124, 30);
		biletal.add(biletler_musteri_idler_cb);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("U\u00E7u\u015F ID : ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(10, 52, 120, 30);
		biletal.add(lblNewLabel_1_1_1_1_1);
		
		JComboBox <String>biletler_ucus_idler_cb = new JComboBox<String>();
		biletler_ucus_idler_cb.setBounds(140, 52, 124, 30);
		biletal.add(biletler_ucus_idler_cb);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(274, 11, 595, 405);
		biletal.add(scrollPane_2_1);
		
	
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 150, 256, 266);
		biletal.add(scrollPane_4);
		
		biletler_musteriler_table = new JTable(musteriler_table_model);
		scrollPane_4.setViewportView(biletler_musteriler_table);
		
		JButton btnNewButton = new JButton("AL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int biletler_musteri_id = Integer.parseInt(biletler_musteri_idler_cb.getSelectedItem().toString());
				int biletler_ucus_id = Integer.parseInt(biletler_ucus_idler_cb.getSelectedItem().toString());
				
				Biletler addedBilet = new Biletler("satildi",biletler_musteri_id, biletler_ucus_id);
				addedBilet.ProsedurBiletEkle(addedBilet);
			}
		});
		btnNewButton.setBounds(140, 108, 124, 36);
		biletal.add(btnNewButton);
		
		JPanel ucuslar = new JPanel();
		ucuslar.setBackground(Color.WHITE);
		tabbedPane.addTab("Uçuþlar", null, ucuslar, null);
		ucuslar.setLayout(null);
		
		JLabel lblGzergah = new JLabel("G\u00FCzergah ID :");
		lblGzergah.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblGzergah.setBounds(10, 11, 130, 30);
		ucuslar.add(lblGzergah);
		
		JComboBox<String> guzergahlar_idler_cb = new JComboBox<String>();
		guzergahlar_idler_cb.setBounds(144, 11, 120, 30);
		ucuslar.add(guzergahlar_idler_cb);
		
		JLabel lblPilotId = new JLabel("Pilot ID : ");
		lblPilotId.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblPilotId.setBounds(10, 52, 130, 30);
		ucuslar.add(lblPilotId);
		
		JComboBox pilotlar_idler_cb = new JComboBox();
		pilotlar_idler_cb.setBounds(144, 52, 120, 30);
		ucuslar.add(pilotlar_idler_cb);
		
		JLabel lblUakId = new JLabel("U\u00E7ak ID :");
		lblUakId.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblUakId.setBounds(10, 93, 130, 30);
		ucuslar.add(lblUakId);
		
		JComboBox ucaklar_idler_cb = new JComboBox();
		ucaklar_idler_cb.setBounds(144, 93, 120, 30);
		ucuslar.add(ucaklar_idler_cb);
		
		JLabel lblBiletFiyat = new JLabel("Bilet Fiyat : ");
		lblBiletFiyat.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblBiletFiyat.setBounds(10, 134, 130, 30);
		ucuslar.add(lblBiletFiyat);
		
		ucuslar_bilet_fiyat = new JTextField();
		ucuslar_bilet_fiyat.setColumns(10);
		ucuslar_bilet_fiyat.setBounds(144, 134, 120, 30);
		ucuslar.add(ucuslar_bilet_fiyat);
		
		
		
		String[] ucuslar_table_colums = {"ID", "Boþ koltuk", "Fiyat", "Pilot ID" , "Güzergah ID" , "Uçak ID"};
		ucuslar_table_model.setColumnIdentifiers(ucuslar_table_colums);
		
		Ucus ucus = new Ucus();
		Object [] ucusData = new Object[6];
		for (Ucus Ucus2 : ucus.ProsedurUcuslariListele()) {
	
			ucusData[0] = Ucus2.getId();
			ucusData[1] = Ucus2.getBos_koltuk_sayisi();
			ucusData[2] = Ucus2.getBilet_fiyati();
			ucusData[3] = Ucus2.getPilot_id();

			ucusData[4] = Ucus2.getGuzergah_id();

			ucusData[5] = Ucus2.getUcak_id();

	

			ucuslar_table_model.addRow(ucusData);
		}
		
		
		JButton havalimani_ekle_button_1 = new JButton("EKLE");
		havalimani_ekle_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ucus_guzergah_id = Integer.parseInt(guzergahlar_idler_cb.getSelectedItem().toString()) ;
				int ucus_pilot_id = Integer.parseInt(pilotlar_idler_cb.getSelectedItem().toString()) ;
				int ucus_ucak_id = Integer.parseInt(ucaklar_idler_cb.getSelectedItem().toString()) ;
				int ucus_bilet_fiyat = Integer.parseInt(ucuslar_bilet_fiyat.getText());
				
				
				
				Ucus addedUcus = new Ucus(ucus_guzergah_id, ucus_pilot_id, ucus_ucak_id, ucus_bilet_fiyat);
				addedUcus.ProsedurUcusEkle(addedUcus);
				
				
				Ucus ucus = new Ucus();
				Object [] ucusData = new Object[6];
				for (Ucus Ucus2 : ucus.ProsedurUcuslariListele()) {
			
					ucusData[0] = Ucus2.getId();
					ucusData[1] = Ucus2.getBos_koltuk_sayisi();
					ucusData[2] = Ucus2.getBilet_fiyati();
					ucusData[3] = Ucus2.getPilot_id();

					ucusData[4] = Ucus2.getGuzergah_id();

					ucusData[5] = Ucus2.getUcak_id();

			

					ucuslar_table_model.addRow(ucusData);
				}
				
				
			}
		});
		havalimani_ekle_button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		havalimani_ekle_button_1.setBounds(144, 205, 120, 40);
		ucuslar.add(havalimani_ekle_button_1);
		
		JScrollPane havalimani_scroll_pane_1 = new JScrollPane();
		havalimani_scroll_pane_1.setBounds(274, 11, 595, 405);
		ucuslar.add(havalimani_scroll_pane_1);
		
		ucuslar_table = new JTable(ucuslar_table_model);
		havalimani_scroll_pane_1.setViewportView(ucuslar_table);
		
		
		DefaultTableCellRenderer ucus_CenterRenderer = new DefaultTableCellRenderer();
		ucus_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < ucuslar_table.getColumnCount(); i++) {
        	ucuslar_table.getColumnModel().getColumn(i).setCellRenderer(ucus_CenterRenderer);
        }
		
		
        ucuslar_table.setRowHeight(40);
        ucuslar_table.getColumnModel().getColumn(0).setPreferredWidth(6);
        ucuslar_table.getColumnModel().getColumn(1).setPreferredWidth(160);

        ucuslar_table.getColumnModel().getColumn(2).setPreferredWidth(60);
		
		
		JPanel guzergahlar = new JPanel();
		guzergahlar.setBackground(Color.WHITE);
		tabbedPane.addTab("Güzergahlar", null, guzergahlar, null);
		guzergahlar.setLayout(null);
		
		JPanel musteriler_1 = new JPanel();
		musteriler_1.setLayout(null);
		musteriler_1.setBackground(Color.WHITE);
		musteriler_1.setBounds(0, 0, 879, 427);
		guzergahlar.add(musteriler_1);
		
		JLabel lblKalkHkod = new JLabel("Kalk\u0131\u015F H.Kod : ");
		lblKalkHkod.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblKalkHkod.setBounds(10, 10, 134, 30);
		musteriler_1.add(lblKalkHkod);
		
		JLabel lblVarHkod = new JLabel("Var\u0131\u015F H.Kod :");
		lblVarHkod.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblVarHkod.setBounds(10, 57, 134, 30);
		musteriler_1.add(lblVarHkod);
		

		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(274, 11, 595, 405);
		musteriler_1.add(scrollPane_3);
		
		
		
		JDateChooser kalkisDateChooser = new JDateChooser();
		kalkisDateChooser.setBounds(134, 103, 130, 30);
		musteriler_1.add(kalkisDateChooser);
		
		
		
		JLabel lblKalkTarihi = new JLabel("Kalk\u0131\u015F Tarihi : ");
		lblKalkTarihi.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblKalkTarihi.setBounds(10, 103, 134, 30);
		musteriler_1.add(lblKalkTarihi);
		
		JLabel lblVarTarihi = new JLabel("Var\u0131\u015F Tarihi : ");
		lblVarTarihi.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblVarTarihi.setBounds(10, 144, 134, 30);
		musteriler_1.add(lblVarTarihi);
		
		JDateChooser varis_dateChooser = new JDateChooser();
		varis_dateChooser.setBounds(134, 144, 130, 30);
		musteriler_1.add(varis_dateChooser);
		
		JLabel lblMesafe = new JLabel("Mesafe : ");
		lblMesafe.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblMesafe.setBounds(10, 185, 134, 30);
		musteriler_1.add(lblMesafe);
		
		JLabel lblSre = new JLabel("S\u00FCre : ");
		lblSre.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblSre.setBounds(10, 226, 134, 30);
		musteriler_1.add(lblSre);
		
		guzergahlar_mesafe_text = new JTextField();
		guzergahlar_mesafe_text.setColumns(10);
		guzergahlar_mesafe_text.setBounds(134, 185, 130, 30);
		musteriler_1.add(guzergahlar_mesafe_text);
		
		guzergahlar_sure_text = new JTextField();
		guzergahlar_sure_text.setColumns(10);
		guzergahlar_sure_text.setBounds(134, 226, 130, 30);
		musteriler_1.add(guzergahlar_sure_text);
		
		JComboBox guzergah_kalkis_kod_cb = new JComboBox();
		guzergah_kalkis_kod_cb.setBounds(134, 16, 130, 30);
		musteriler_1.add(guzergah_kalkis_kod_cb);
	
		JComboBox guzergah_varis_kod_cb = new JComboBox();
		guzergah_varis_kod_cb.setBounds(134, 62, 130, 30);
		musteriler_1.add(guzergah_varis_kod_cb);
		
		
		DefaultComboBoxModel<String> kalkisGuzergahComboBoxModel = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> varisGuzergahComboBoxModel = new DefaultComboBoxModel<>();


		Havalimani kodlistele = new Havalimani();
		for (String kod : kodlistele.prosedurHavalimaniKodlariniListele()) {
			
			kalkisGuzergahComboBoxModel.addElement(kod);
		}
		
		for (String kod : kodlistele.prosedurHavalimaniKodlariniListele()) {
			
			varisGuzergahComboBoxModel.addElement(kod);
		}
		

        guzergah_kalkis_kod_cb.setModel(kalkisGuzergahComboBoxModel);
        guzergah_varis_kod_cb.setModel(varisGuzergahComboBoxModel);
        
        
        
        String[] guzergah_table_colums = {"ID", "KalkýþT", "VarýþT","Mesafe","Süre","KalkýþHK","VarýþHK"};
		guzergah_table_model.setColumnIdentifiers(guzergah_table_colums);
		
		Guzergah guzergah = new Guzergah();
		Object [] guzergahData = new Object[7];
		
		for (Guzergah guzergah2 : guzergah.guzergahlariListele()) {
	
			guzergahData[0] = guzergah2.getId();
			guzergahData[1] = guzergah2.getKalkis_tarihi();
			guzergahData[2] = guzergah2.getVaris_tarihi();
			guzergahData[3] = guzergah2.getMesafe();
			guzergahData[4] = guzergah2.getSure();
			guzergahData[5] = guzergah2.getKalkis_havalimani_kod();
			guzergahData[6] = guzergah2.getVaris_havalimani_kod();

	

			guzergah_table_model.addRow(guzergahData);
        
		}
        
		JButton musteri_ekle_button_1 = new JButton("EKLE");
		musteri_ekle_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int kalkis_havalimani_kod =	Integer.parseInt(kalkisGuzergahComboBoxModel.getSelectedItem().toString());
			int varis_havalimani_kod =Integer.parseInt(	varisGuzergahComboBoxModel.getSelectedItem().toString());
			
			Date kalkisSelectedDate =  kalkisDateChooser.getDate();
            Date varisSelectedDate = varis_dateChooser.getDate();

		
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Deðiþtirildi
        
            String kalkis_format_date = dateFormat.format(kalkisSelectedDate);
            String varis_format_date = dateFormat.format(varisSelectedDate);
            try {
            	
            	java.util.Date parsedUtilDateKalkis = dateFormat.parse(kalkis_format_date);
                java.util.Date parsedUtilDateVaris = dateFormat.parse(varis_format_date);

                java.sql.Date sqlDateKalkis = new java.sql.Date(parsedUtilDateKalkis.getTime());
                java.sql.Date sqlDateVaris = new java.sql.Date(parsedUtilDateVaris.getTime());

                int guzergah_mesafe = Integer.parseInt(guzergahlar_mesafe_text.getText());
                int guzergah_sure = Integer.parseInt(guzergahlar_sure_text.getText());

                Guzergah addedGuzergah = new Guzergah(sqlDateKalkis, sqlDateVaris, guzergah_mesafe, guzergah_sure, kalkis_havalimani_kod, varis_havalimani_kod);

                guzergah.guzergahEkle(addedGuzergah);
                
                
                
                Guzergah guzergah = new Guzergah();
        		Object [] guzergahData = new Object[7];
        		
        		guzergah_table_model.setRowCount(0);
        		for (Guzergah guzergah2 : guzergah.guzergahlariListele()) {
        	
        			guzergahData[0] = guzergah2.getId();
        			guzergahData[1] = guzergah2.getKalkis_tarihi();
        			guzergahData[2] = guzergah2.getVaris_tarihi();
        			guzergahData[3] = guzergah2.getMesafe();
        			guzergahData[4] = guzergah2.getSure();
        			guzergahData[5] = guzergah2.getKalkis_havalimani_kod();
        			guzergahData[6] = guzergah2.getVaris_havalimani_kod();

        	

        			guzergah_table_model.addRow(guzergahData);
                
        		}
                
                
                
                
                
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		guzergahlar_table = new JTable(guzergah_table_model);
		scrollPane_3.setViewportView(guzergahlar_table);
		DefaultTableCellRenderer guzergah_CenterRenderer = new DefaultTableCellRenderer();
		guzergah_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < guzergahlar_table.getColumnCount(); i++) {
        	guzergahlar_table.getColumnModel().getColumn(i).setCellRenderer(guzergah_CenterRenderer);
        }
		
		
        guzergahlar_table.setRowHeight(40);
        guzergahlar_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        guzergahlar_table.getColumnModel().getColumn(1).setPreferredWidth(160);

        guzergahlar_table.getColumnModel().getColumn(2).setPreferredWidth(160);
        guzergahlar_table.getColumnModel().getColumn(3).setPreferredWidth(100);

        guzergahlar_table.getColumnModel().getColumn(4).setPreferredWidth(100);

        guzergahlar_table.getColumnModel().getColumn(5).setPreferredWidth(100);
        guzergahlar_table.getColumnModel().getColumn(6).setPreferredWidth(100);


		
		
	
		musteri_ekle_button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		musteri_ekle_button_1.setBounds(134, 282, 130, 40);
		musteriler_1.add(musteri_ekle_button_1);
		
		
		
		
		Guzergah guzergah_idler = new Guzergah();
		for (String guzergahlar_idler : guzergah_idler.ProsedurGuzergahIDleriListele()) {
			guzergahlar_idler_cb.addItem(guzergahlar_idler);
        }
		
		Pilot pilot_idler = new Pilot();
		for (String pilotlar_idler : pilot_idler.ProsedurPilotIDleriListele()) {
			pilotlar_idler_cb.addItem(pilotlar_idler);
        }
		
		Ucak ucak_idler = new Ucak();
		for (String ucaklar_idler : ucak_idler.ProsedurUcakIDleriListele()) {
			ucaklar_idler_cb.addItem(ucaklar_idler);
        }
		
		
		Musteri musteri_idler = new Musteri();
		for(String musteriler_idler : musteri_idler.ProsedurMusterilerIDleriListele()) {
			biletler_musteri_idler_cb.addItem(musteriler_idler);
		}
		
		Ucus ucus_idler = new Ucus();
		for (String ucuslar_idler : ucus_idler.ProsedurUcuslarIDleriListele()) {
			biletler_ucus_idler_cb.addItem(ucuslar_idler);
			
		}
		
		String[] ucus_detay_table_colums = {"ID", "Fiyat", "Boþ K.S.","Kalkýþ T.","Varýþ T.","Kalkýþ H.A","Varýþ H.A" ,"Uçak Model"};
		biletler_ucuslar_table_model.setColumnIdentifiers(ucus_detay_table_colums);
		
		UcusDetay ucusDetay = new UcusDetay();
		Object [] ucusDetayData = new Object[8];
		
		for (UcusDetay ucusDetay2 : ucusDetay.ProsedurUcusDetayListele()) {
	
			ucusDetayData[0] = ucusDetay2.getUcus_id();
			ucusDetayData[1] = ucusDetay2.getBilet_fiyati();
			ucusDetayData[2] = ucusDetay2.getBos_koltuk_sayisi();
			ucusDetayData[3] = ucusDetay2.getKalkis_tarihi();
			ucusDetayData[4] = ucusDetay2.getVaris_tarihi();
			ucusDetayData[5] = ucusDetay2.getKalkis_havalimani_adi();
			ucusDetayData[6] = ucusDetay2.getVaris_havalimani_adi();
			ucusDetayData[7] = ucusDetay2.getUcak_model();

			biletler_ucuslar_table_model.addRow(ucusDetayData);
        
		}
		
		
        
		
		biletler_ucuslar_table = new JTable(biletler_ucuslar_table_model);
		scrollPane_2_1.setViewportView(biletler_ucuslar_table);
		
		
		DefaultTableCellRenderer ucus_detay_CenterRenderer = new DefaultTableCellRenderer();
		ucus_detay_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < biletler_ucuslar_table.getColumnCount(); i++) {
        	biletler_ucuslar_table.getColumnModel().getColumn(i).setCellRenderer(ucus_detay_CenterRenderer);
        }
		
		biletler_ucuslar_table.setRowHeight(40);
		biletler_ucuslar_table.getColumnModel().getColumn(0).setPreferredWidth(15);
		biletler_ucuslar_table.getColumnModel().getColumn(1).setPreferredWidth(50);
		biletler_ucuslar_table.getColumnModel().getColumn(2).setPreferredWidth(30);

		
		DefaultTableCellRenderer biletler_musteri_CenterRenderer = new DefaultTableCellRenderer();
		biletler_musteri_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < biletler_musteriler_table.getColumnCount(); i++) {
        	biletler_musteriler_table.getColumnModel().getColumn(i).setCellRenderer(biletler_musteri_CenterRenderer);
        }
        
        
        
		JPanel biletler = new JPanel();
		tabbedPane.addTab("Biletler", null, biletler, null);
		biletler.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 11, 859, 405);
		biletler.add(scrollPane_5);
		
		biletler_table = new JTable(biletler_table_model);
		biletler_table.setBackground(Color.WHITE);
		scrollPane_5.setViewportView(biletler_table);
		
		
		
		String[] biletler_table_colums = {"ID", "Ad", "Soyad","Satýn Alma T.","Durum","Fiyat","Uçak Model" ,"Kalkýþ T." , "Varýþ T.","Kalkýþ H." ,"Varýþ H."};
		biletler_table_model.setColumnIdentifiers(biletler_table_colums);
		
		Biletler tumBiletler = new Biletler();
		Object [] tumBiletlerData = new Object[11];
		
		for (Biletler tumBiletler2 : tumBiletler.ProsedurTumBiletleriListele()) {
	
			tumBiletlerData[0] = tumBiletler2.getId();
			tumBiletlerData[1] = tumBiletler2.getMusteri_ad();
			tumBiletlerData[2] = tumBiletler2.getMusteri_soyad();
			tumBiletlerData[3] = tumBiletler2.getSatin_alma_tarihi();
			if(tumBiletler2.getBilet_durumu().equals("satildi") ) {
				tumBiletlerData[4]  = "Satýldý";
			}else if (tumBiletler2.getBilet_durumu().equals("kullanildi") ) {
				tumBiletlerData[4]  = "Kullanýldý";
			}else {
				tumBiletlerData[4]  = "Ýptal";

			}
			tumBiletlerData[5] = tumBiletler2.getBilet_fiyati();
			tumBiletlerData[6] = tumBiletler2.getUcak_model();
			tumBiletlerData[7] = tumBiletler2.getKalkis_tarihi();
			tumBiletlerData[8] = tumBiletler2.getVaris_tarihi();
			tumBiletlerData[9] = tumBiletler2.getKalkis_havalimani();
			tumBiletlerData[10] = tumBiletler2.getVaris_havalimani();
			



			biletler_table_model.addRow(tumBiletlerData);
        
		}
		
		DefaultTableCellRenderer tum_biletler_CenterRenderer = new DefaultTableCellRenderer();
		tum_biletler_CenterRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Tüm sütunlara bu hücre düzenleyicisini ayarla
        for (int i = 0; i < biletler_table.getColumnCount(); i++) {
        	biletler_table.getColumnModel().getColumn(i).setCellRenderer(tum_biletler_CenterRenderer);
        }
		
        biletler_table.setRowHeight(40);
        biletler_table.getColumnModel().getColumn(0).setPreferredWidth(15);
        biletler_table.getColumnModel().getColumn(1).setPreferredWidth(30);
        biletler_table.getColumnModel().getColumn(2).setPreferredWidth(55);
        biletler_table.getColumnModel().getColumn(4).setPreferredWidth(30);

        biletler_table.getColumnModel().getColumn(5).setPreferredWidth(30);
        biletler_table.getColumnModel().getColumn(9).setPreferredWidth(100);

        biletler_table.getColumnModel().getColumn(10).setPreferredWidth(100);




       
		
	}
}
