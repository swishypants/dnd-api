package charactermanager.repository.exceptions;

public class CharacterNotFoundException extends RuntimeException {

  public CharacterNotFoundException(String message) {
    super(message);
  }
}