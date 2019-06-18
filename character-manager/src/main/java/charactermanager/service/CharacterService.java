package charactermanager.service;

import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String id);

}
