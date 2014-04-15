package mtm.vlanmgr.repository;

public class RepositoryException extends RuntimeException {

	private static final long serialVersionUID = -311564795466742065L;
	
	public RepositoryException(String message) {
		super(message);
	}
	
	public RepositoryException(Throwable cause) {
		super(cause);
	}
	
	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
