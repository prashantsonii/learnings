package marsrover.validator;

public interface Validator {
	boolean valid(String data);
	String getValidationError();
}
