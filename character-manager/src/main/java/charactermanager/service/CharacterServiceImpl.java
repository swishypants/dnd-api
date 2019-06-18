package charactermanager.service;

import charactermanager.repository.CharacterRepository;
import charactermanager.repository.exceptions.CharacterNotFoundException;
import java.util.Optional;

public class CharacterServiceImpl implements CharacterService {

  private CharacterRepository characterRepository;

  public CharacterServiceImpl(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  @Override
  public Character getCharacter(String id) {
    return (Character) Optional.ofNullable(characterRepository.findById(id))
        .orElseThrow(() -> new CharacterNotFoundException(id)).get();
  }
}
