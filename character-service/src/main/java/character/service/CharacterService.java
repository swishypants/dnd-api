package character.service;

import character.domain.Character;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String id);

  Character createCharacter(Character createCharacterRequest);

  Character updateCharacter(Character updateCharacterRequest);
}
