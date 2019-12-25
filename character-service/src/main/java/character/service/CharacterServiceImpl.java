package character.service;

import character.domain.Character;
import character.domain.CreateCharacterRequest;
import character.domain.CreateOrUpdateCharacterRequest;
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
  public Character createCharacter(CreateCharacterRequest createCharacterRequest) {
    return (Character) repository.save(createCharacterRequest);
  }

  @Override
  public Character updateCharacter(CreateOrUpdateCharacterRequest createOrUpdateCharacterRequest) {
    return (Character) repository.save(createOrUpdateCharacterRequest); // todo - this isn't how a patch request should update
  }
}
