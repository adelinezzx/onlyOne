package Exception;

public class PasswordException extends RuntimeException {

	/**
	 * 自己声明密码算术异常
	 */
	private static final long serialVersionUID = 1L;   

	public PasswordException() {
		super();
	}
	public PasswordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
