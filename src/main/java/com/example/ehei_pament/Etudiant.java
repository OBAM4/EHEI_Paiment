package com.example.ehei_pament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Etudiant {
	private String Nom;
	private String Prenom;
	private String Email;
	private String Password;
	private int AnneScolaireDebut;
	private int AnneScolaireFin;
	
	private Connection cnx;
	public Etudiant() {
		try {
			cnx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ehei_paiment"
					, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Etudiant(String nom, String prenom, String email, String password, int anneScolaireDebut,
			int anneScolaireFin) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Password = password;
		AnneScolaireDebut = anneScolaireDebut;
		AnneScolaireFin = anneScolaireFin;
		try {
			cnx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ehei_paiment"
					, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAnnneScolaireDebut() {
		return AnneScolaireDebut;
	}
	public void setAnnneScolaireDebut(int anneScolaireDebut) {
		AnneScolaireDebut = anneScolaireDebut;
	}
	public int getAnnneScolaireFin() {
		return AnneScolaireFin;
	}
	public void setAnnneScolaireFin(int anneScolaireFin) {
		AnneScolaireFin = anneScolaireFin;
	}
	public ArrayList<Etudiant> getAll() {
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		try {
			PreparedStatement stmt = cnx.prepareStatement(
					"SELECT * FROM Etudiant"
					);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nom = rs.getString("Nom");
				String prenom = rs.getString("Prenom");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				int annee_scolaire_debut = rs.getInt("Annee_Scolaire_Debut");
				int annee_scolaire_fin = rs.getInt("Annee_Scolaire_Fin");
				Etudiant etudiant = new Etudiant(nom, prenom, email, password, 
						annee_scolaire_debut, annee_scolaire_fin);
				etudiants.add(etudiant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiants;
	}
}
