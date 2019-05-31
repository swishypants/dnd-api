package service;

import repository.CharacterRepository;
import repository.exceptions.CharacterNotFoundException;

public class CharacterServiceImpl implements CharacterService {

  private CharacterRepository characterRepository;

  public CharacterServiceImpl(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  @Override
  public Character getCharacter(String id) {
    return (Character) characterRepository.findById(id)
        .orElseThrow(() -> new CharacterNotFoundException("Unable to find character with id=" + id));
  }
}
