package Servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AccesMongoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MongoCollection<Document> commentaires;

	public void connexionMongo() {
		ConnectionString connectionString = new ConnectionString("mongodb://obiwan.univ-brest.fr:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		// utilise la base sports
		MongoDatabase database = mongoClient.getDatabase("Commentaires_Menou_Paugam_Monnier");
		// récupère la collection sportifs
		commentaires = database.getCollection("commentaires");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.connexionMongo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String operation = request.getParameter("operation");
		String json = "";
		if (operation.equals("listeCommentaires")) {
			json += "[";
			for (Document doc : this.commentaires.find()) {
				json += doc.toJson() + ",";
			}
			if (json.length() > 1)
				json = json.substring(0, json.length() - 1);
			json += "]";
			out.write(json);
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}