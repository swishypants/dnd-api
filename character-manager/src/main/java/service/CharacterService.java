package service;

import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  public Character getCharacter(String id);

}
