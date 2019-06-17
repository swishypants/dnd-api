package charactermanager.api;

import charactermanager.dto.CreateCharacterRequestDTO;
import charactermanager.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/characters/api/v1")
public class CharacterResource {

  private Logger logger = LoggerFactory.getLogger(CharacterResource.class);

  private CharacterService characterService;

  public CharacterResource(CharacterService characterService) {
    this.characterService = characterService;
  }

  @GetMapping("/{id}")
  public void getCharacter(@PathVariable String id) {
    characterService.getCharacter(id);
    logger.info("GET /id");
  }

  @PostMapping
  public void createNewCharacter(CreateCharacterRequestDTO createCharacterRequestDTO) {

  }
}