package character.repository.exceptions;

public class CharacterNotFoundException extends RuntimeException {

  public CharacterNotFoundException(String id) {
    super("Unable to find character with id=" + id);
  }
}
