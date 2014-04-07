package mtm.vlanmgr.repository;

public class RepositoryException extends RuntimeException {

  private static final long serialVersionUID = 7182250413044319924L;

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
