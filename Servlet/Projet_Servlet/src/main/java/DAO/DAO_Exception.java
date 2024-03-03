package DAO;

/**
 * Exception sp�cifique aux probl�mes d'acc�s aux donn�es via un DAO.
 * @author Eric
 */
public class DAO_Exception extends Exception {
    
	private static final long serialVersionUID = 309200220164832142L;

	public DAO_Exception() {
        super();
    }
    
    public DAO_Exception(String message) {
        super(message);
    }
}
