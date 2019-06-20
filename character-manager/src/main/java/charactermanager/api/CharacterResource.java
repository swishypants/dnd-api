package charactermanager.api;

import charactermanager.domain.Character;
import charactermanager.dto.CharacterResponseDTO;
import charactermanager.dto.CreateCharacterRequestDTO;
import charactermanager.dto.UpdateCharacterRequestDTO;
import charactermanager.mapper.CharacterMapper;
import charactermanager.service.CharacterService;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    logger.info("Retrieving character with id={}", id);
    Character character = characterService.getCharacter(id);
    CharacterResponseDTO characterResponseDTO = characterMapper.characterToCharacterResponseDTO(character);
    return ResponseEntity
        .ok(characterResponseDTO);
  }

  @PostMapping
  public ResponseEntity<CharacterResponseDTO> createCharacter(CreateCharacterRequestDTO createCharacterRequestDTO) {
    logger.info("Creating character with createCharacterRequestDTO={}", createCharacterRequestDTO);
    Character character = characterMapper.createCharacterRequestDTOToCharacter(createCharacterRequestDTO);
    characterService.createCharacter(character);
    CharacterResponseDTO characterResponseDTO = characterMapper.characterToCharacterResponseDTO(character);
    return ResponseEntity
        .created(URI.create("")) // todo - return id here
        .body(characterResponseDTO);
  }

  @PatchMapping
  public ResponseEntity updateCharacter(UpdateCharacterRequestDTO updateCharacterRequestDTO) {
    logger.info("Updating character with updateCharacterRequestDTO={}", updateCharacterRequestDTO);

    return ResponseEntity
        .noContent()
        .location(URI.create("")) // todo - return id here
        .build();
  }
}