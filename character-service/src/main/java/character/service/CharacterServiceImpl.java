package charactermanager.service;

import charactermanager.domain.Character;
import charactermanager.domain.CreateCharacterRequest;
import charactermanager.domain.CreateOrUpdateCharacterRequest;
import charactermanager.repository.CharacterRepository;
import charactermanager.repository.exceptions.CharacterNotFoundException;
import java.util.Optional;

public class CharacterServiceImpl implements CharacterService {

  private CharacterRepository repository;

  public CharacterServiceImpl(CharacterRepository repository) {
    this.repository = repository;
  }

  @Override
  public Character getCharacter(String id) {
    return (Character) Optional.ofNullable(repository.findById(id))
        .orElseThrow(() -> new CharacterNotFoundException(id)).get();
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
