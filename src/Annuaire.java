import java.util.List;

import beans.Annonce;
import beans.Categorie;
import dao.AnnonceDaoImpl;
import dao.CategorieDaoImpl;
import dao.DAOFactory;

public class Annuaire {
	public void creationAnnonce(int categorie_id, String nom, String adresse, String numero) {
		Annonce annonce = new Annonce();
		DAOFactory factory = DAOFactory.getInstance();
		CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouver(categorie_id);
	    annonce.setCategorie(categorie);
	    annonce.setNom(nom);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    DaoAnnonce.creer(annonce);
	}
	
	public void modificationAnnonce(int categorie_id, String nom, String adresse, String numero, int annonce_id)  {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouver(categorie_id);
	    Annonce annonce = DaoAnnonce.trouver(annonce_id);
	    annonce.setNom(nom);
	    annonce.setCategorie(categorie);
	    annonce.setAdresse(adresse);
	    annonce.setNumero(numero);
	    DaoAnnonce.modifier(annonce);
	}
	
	public void suppressionAnnonce(int id){
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver(id);
	    DaoAnnonce.supprimer(annonce);
	}
	
	public Annonce affichageAnnonce(int id) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    Annonce annonce = DaoAnnonce.trouver(id);
		return annonce;
	}
	
	public Annonce[] affichageAnnonces() {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.lister();	    
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public Annonce[] affichageAnnonceNom(String nom) {
		DAOFactory factory = DAOFactory.getInstance();
		AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
		List<Annonce> annonces = DaoAnnonce.listerNom(nom);
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public Annonce[] affichageAnnonceAdresse(String adresse) {
		DAOFactory factory = DAOFactory.getInstance();
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerAdresse(adresse);
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public Annonce[] affichageAnnonceCategorie(String sujet) {
		DAOFactory factory = DAOFactory.getInstance();
		CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
		Categorie categorie = DaoCategorie.trouverSujet(sujet);
	    AnnonceDaoImpl DaoAnnonce = (AnnonceDaoImpl) factory.getAnnonceDao();
	    List<Annonce> annonces = DaoAnnonce.listerCategorie(categorie.getId());
	    Annonce[] list_annonce = new Annonce[annonces.size()];
	    annonces.toArray(list_annonce);
	    return list_annonce;
	}
	
	public void creationCategorie(String categorie) {
		Categorie cat = new Categorie();
	    cat.setSujet(categorie);
        DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCat = (CategorieDaoImpl) factory.getCategorieDao();
	    DaoCat.creer(cat);
	}

	public void modificationCategorie(String sujet, int id ) {
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(id);
	    categorie.setSujet(sujet);
	    DaoCategorie.modifier(categorie);
	}
	public void suppressionCategorie(int id){
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver(id);
	    DaoCategorie.supprimer(categorie);
	}
	
	public Categorie affichageCategorie(int id) {
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    Categorie categorie = DaoCategorie.trouver( id );
		return categorie;
	}
	
	public Categorie[] affichageCategories() {
		DAOFactory factory = DAOFactory.getInstance();
	    CategorieDaoImpl DaoCategorie = (CategorieDaoImpl) factory.getCategorieDao();
	    List<Categorie> categories = DaoCategorie.lister();	    
	    Categorie[] list_categorie = new Categorie[categories.size()];
	    categories.toArray(list_categorie);
	    return list_categorie;
	}
}
