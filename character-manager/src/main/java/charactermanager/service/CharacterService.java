package charactermanager.service;

import charactermanager.domain.Character;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String id);

  Character createCharacter(Character character);

}
