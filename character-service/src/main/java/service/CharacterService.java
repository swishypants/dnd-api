package service;

import domain.Character;
import repository.CharacterRepository;

import java.util.Optional;

public class CharacterService {

  private CharacterRepository repository;

  public CharacterService(CharacterRepository repository) {
    this.repository = repository;
  }

  String createCharacter(Character character) {
    return repository.insert(character).getId();
  }

  Optional<Character> getCharacter(String id) {
    return repository.findById(id);
  }

  Character updateCharacter(Character character) {
    return repository.save(character);
  }

  void deleteCharacter(String id) {
    repository.deleteById(id);
  }
}
