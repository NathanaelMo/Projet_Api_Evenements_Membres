package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import DAO.DAO_Exception;
import DAO.DAO_Lieu;
import donnees.CommentaireEntity;
import donnees.LieuEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class LieuServlet
 */
public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CommentaireServlet() {
        super();
    }
    
    public static void connexionMongoDB() {

		// connexion à la base Mongo 
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		ConnectionString connectionString = new ConnectionString("mongodb://obiwan.univ-brest.fr:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		MongoDatabase database = mongoClient.getDatabase("Commentaires_Menou_Paugam_Monnier").withCodecRegistry(pojoCodecRegistry);
		System.out.println("Connexion établie\n");
		
		//MongoCollection<CommentaireEntity> commentaires = database.getCollection("commentaires", CommentaireEntity.class);
	}
    
    @SuppressWarnings("unchecked")
	public List<CommentaireEntity> getListeCommentaires(HttpServletResponse response) throws IOException {
    	
    	this.connexionMongoDB();
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AssociationPU");
		EntityManager em = emf.createEntityManager();
		Query requete = (Query) em.createQuery("SELECT c FROM CommentaireEntity c");
		
		Gson gson = new GsonBuilder().create();
        String jsonLieux = gson.toJson(requete.getResultList());

        // Définir le type de contenu de la réponse en JSON
        response.setContentType("application/json");

        // Écrire la réponse JSON
        response.getWriter().write(jsonLieux);
        
        return (List<CommentaireEntity>) requete.getResultList();
    }
    
    public void insertNewLieu(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AssociationPU");
		    EntityManager em = emf.createEntityManager();
		    EntityTransaction transaction = em.getTransaction();

		    try {
		    	// Récupérer les données du formulaire
		        String nom = request.getParameter("nom");
		        String adresse = request.getParameter("adresse");
		        int nbMaxPers = Integer.parseInt(request.getParameter("nbMaxPers"));

		        // Créer un nouvel objet LieuEntity avec les données du formulaire
		        LieuEntity nouveauLieu = new LieuEntity();
		        nouveauLieu.setNom(nom);
		        nouveauLieu.setAdresse(adresse);
		        nouveauLieu.setNbMaxPers(nbMaxPers);
		        
		        // Démarrer une transaction
		        transaction.begin();

		        // Insérer le nouveau lieu dans la base de données
		        em.persist(nouveauLieu);

		        // Valider la transaction
		        transaction.commit();
		        
		        response.sendRedirect("confirmation.jsp");
		    } catch (Exception e) {
		        // En cas d'erreur, annuler la transaction
		        if (transaction != null && transaction.isActive()) {
		            transaction.rollback();
		        }
		        e.printStackTrace(); // Gérer l'exception de manière appropriée dans votre application
		        
		        response.sendRedirect("erreur.jsp");
		    } finally {
		        // Fermer l'EntityManager
		        em.close();
		        // Fermer l'EntityManagerFactory
		        emf.close();
		    }
    }
    
    public void supprimeLieu(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AssociationPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            // Récupérer l'identifiant du lieu à supprimer depuis les paramètres de la requête
            int idLieu = Integer.parseInt(request.getParameter("id"));

            // Démarrer une transaction
            transaction.begin();

            // Récupérer le lieu à supprimer
            LieuEntity lieuASupprimer = em.find(LieuEntity.class, idLieu);

            // Vérifier si le lieu existe avant de tenter la suppression
            if (lieuASupprimer != null) {
                // Supprimer le lieu de la base de données
                em.remove(lieuASupprimer);

                // Valider la transaction
                transaction.commit();

                response.sendRedirect("confirmation.jsp");
            } else {
                // Le lieu n'existe pas, annuler la transaction
                transaction.rollback();
                
                response.sendRedirect("erreur.jsp");
            }
        } catch (Exception e) {
            // En cas d'erreur, annuler la transaction
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Gérer l'exception de manière appropriée dans votre application

            response.sendRedirect("erreur.jsp");
        } finally {
            // Fermer l'EntityManager
            em.close();
            // Fermer l'EntityManagerFactory
            emf.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("listeCommentaires")) {
			request.setAttribute("lieux", this.getListeCommentaires(response));
			
		} else if (operation.equals("ajouterLieu")) {
			this.insertNewLieu(request, response);
		} else if (operation.equals("supprimerLieu")) {
			this.supprimeLieu(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
