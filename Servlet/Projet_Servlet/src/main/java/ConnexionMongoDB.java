import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import donnees.CommentaireEntity;


public class ConnexionMongoDB {

	public static void main(String[] args) {

		// connexion à la base Mongo 
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		ConnectionString connectionString = new ConnectionString("mongodb://obiwan.univ-brest.fr:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		MongoDatabase database = mongoClient.getDatabase("Commentaires_Menou_Paugam_Monnier").withCodecRegistry(pojoCodecRegistry);
		System.out.println("Connexion établie\n");
		
		MongoCollection<CommentaireEntity> commentaires = database.getCollection("commentaires", CommentaireEntity.class);
		
		for(CommentaireEntity com : commentaires.find()) {
			System.out.println("Id evenement: " +com.getId_evenement()+ "\nCommentaire: "+com.getMessage());
		}
	       
		// ajout d'un commentaire
		CommentaireEntity newCom = new CommentaireEntity();
		newCom.setId_evenement(2);
		newCom.setMessage("tesssttt");
		commentaires.insertOne(newCom);
	}
}
