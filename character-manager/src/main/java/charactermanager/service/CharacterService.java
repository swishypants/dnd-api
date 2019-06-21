package charactermanager.service;

import charactermanager.domain.Character;
import charactermanager.domain.CreateCharacterRequest;
import charactermanager.domain.CreateOrUpdateCharacterRequest;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String id);

  Character createCharacter(CreateCharacterRequest createCharacterRequest);

  Character updateCharacter(CreateOrUpdateCharacterRequest createOrUpdateCharacterRequest);

}
