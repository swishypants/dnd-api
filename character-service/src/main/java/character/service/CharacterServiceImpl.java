package character.service;

import character.domain.Character;
import character.repository.CharacterRepository;
import character.repository.exceptions.CharacterNotFoundException;

public class CharacterServiceImpl implements CharacterService {

  private CharacterRepository repository;

  public CharacterServiceImpl(CharacterRepository repository) {
    this.repository = repository;
  }

  @Override
  public Character getCharacter(String id) {
    return repository.findByCharacterId(id)
            .orElseThrow(() -> new CharacterNotFoundException(id));
  }

  @Override
  public Character createCharacter(Character createCharacterRequest) {
    return null; // todo - flesh this out
  }

  @Override
  public Character updateCharacter(Character updateCharacterRequest) {
    return null; // todo - flesh this out
  }
}
