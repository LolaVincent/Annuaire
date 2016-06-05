import java.util.Iterator;
import java.util.List;

import beans.Annonce;
import beans.Categorie;
import dao.AnnonceDaoImpl;
import dao.CategorieDaoImpl;
import dao.DAOFactory;

public class Annuaire {
	
	public void creationCategorie(String categorie) {
		Categorie cat = new Categorie();
	    cat.setSujet(categorie);
        DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCat = (CategorieDaoImpl) factory.getCategorieDao();
	    DaoCat.creer(cat);
	}
	
	public void creationAnnonce(Long categorie, String nom, String adresse, String numero) {
		Annonce annonce = new Annonce();
	    annonce.setCategorie(categorie);
	    annonce.setNom(nom);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
        DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    DaoAnnonce.creer(annonce);
	}
	
	public void modificationCategorie(String sujet, Long id ) {
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(id);
	    categorie.setSujet(sujet);
	    DaoCategorie.modifier(categorie);
	}
	
	public void modificationAnnonce(Long categorie, String nom, String adresse, String numero, Long id)  {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver(id);
	    annonce.setNom(nom);
	    annonce.setCategorie(categorie);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
	    DaoAnnonce.modifier(annonce);
	}
	
	public void suppressionCategorie(long id){
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(id);
	    DaoCategorie.supprimer(categorie);
	}
	
	public void suppressionAnnonce(long id){
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver(id);
	    DaoAnnonce.supprimer(annonce);
	}
	
	public void affichageAnnonceCategorie(Categorie categorie) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerCategorie(categorie.getId());
	    for (Iterator<Annonce> it = annonces.iterator() ; it.hasNext();) {
	    	System.out.print(it.next().getNom());
	    }
	}
	
	public void affichageAnnonceAdresse(String adresse) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerAdresse(adresse);
	    for (Iterator<Annonce> it = annonces.iterator() ; it.hasNext();) {
	    	System.out.print(it.next().getNom());
	    }
	}
	
	public Annonce AffichageAnnonceNom(String nom) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver_par_nom(nom);
		return annonce;
	}
	
}
