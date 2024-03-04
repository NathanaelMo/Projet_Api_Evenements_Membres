package donnees;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "commentaires", schema = "Commentaires_Menou_Paugam_Monnier")
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM CommentaireEntity c"),
    @NamedQuery(name = "Commentaire.findByIdCommentaire", query = "SELECT c FROM CommentaireEntity c WHERE c.id_message = :idCommentaire")})
public class CommentaireEntity {
  @Basic
  @Column(name = "id_evenement", nullable = false)
  private int id_evenement;
  @Basic
  @Column(name = "message", nullable = false, length = 200)
  private String message;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id_message", nullable = false)
  private int id_message;

  public int getId_evenement() {
	return id_evenement;
}

public void setId_evenement(int id_evenement) {
	this.id_evenement = id_evenement;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public int getId_message() {
	return id_message;
}

public void setId_message(int id_message) {
	this.id_message = id_message;
}

@Override
public int hashCode() {
	return Objects.hash(id_evenement, id_message, message);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CommentaireEntity other = (CommentaireEntity) obj;
	return id_evenement == other.id_evenement && id_message == other.id_message
			&& Objects.equals(message, other.message);
}

@Override
public String toString() {
	return "CommentaireEntity [id_evenement=" + id_evenement + ", message=" + message + ", id_message=" + id_message
			+ "]";
}

}
