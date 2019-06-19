package charactermanager.api;

import charactermanager.dto.CharacterResponseDTO;
import charactermanager.dto.CreateCharacterRequestDTO;
import charactermanager.mapper.CharacterMapper;
import charactermanager.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/characters/api/v1")
public class CharacterResource {

  private Logger logger = LoggerFactory.getLogger(CharacterResource.class);

  private CharacterService characterService;
  private CharacterMapper characterMapper;

  public CharacterResource(CharacterService characterService, CharacterMapper characterMapper) {
    this.characterService = characterService;
    this.characterMapper = characterMapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity getCharacter(@PathVariable String id) {
    logger.info("GET character with id={}", id);
    Character character = characterService.getCharacter(id);
    CharacterResponseDTO characterResponseDTO = characterMapper.toCharacterResponseDTO(character);
    return ResponseEntity.ok(characterResponseDTO);
  }

  @PostMapping
  public void createCharacter(CreateCharacterRequestDTO createCharacterRequestDTO) {

  }
}