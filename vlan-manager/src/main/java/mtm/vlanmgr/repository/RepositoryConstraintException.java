package mtm.vlanmgr.repository;

public class RepositoryConstraintException extends RepositoryException {

  private static final long serialVersionUID = 6440250551093174905L;

  public RepositoryConstraintException(String message) {
    super(message);
  }

  public RepositoryConstraintException(Throwable cause) {
    super(cause);
  }

  public RepositoryConstraintException(String message, Throwable cause) {
    super(message, cause);
  }

}
