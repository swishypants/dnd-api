package character.service;

import character.domain.Character;
import character.domain.CreateCharacterRequest;
import character.domain.CreateOrUpdateCharacterRequest;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String id);

  Character createCharacter(CreateCharacterRequest createCharacterRequest);

  Character updateCharacter(CreateOrUpdateCharacterRequest createOrUpdateCharacterRequest);
}
