package charactermanager.api;

import charactermanager.domain.Character;
import charactermanager.domain.CreateCharacterRequest;
import charactermanager.domain.CreateOrUpdateCharacterRequest;
import charactermanager.dto.CharacterResponseDTO;
import charactermanager.dto.CreateCharacterRequestDTO;
import charactermanager.dto.CreateOrUpdateCharacterRequestDTO;
import charactermanager.mapper.CharacterMapper;
import charactermanager.repository.exceptions.CharacterNotFoundException;
import charactermanager.service.CharacterService;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/characters/api/v1")
public class CharacterResource {

  private Logger logger = LoggerFactory.getLogger(CharacterResource.class);

  private CharacterService service;
  private CharacterMapper mapper;

  public CharacterResource(CharacterService service, CharacterMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity getCharacter(@PathVariable String id) {
    logger.info("Retrieving character with id={}", id);

    Character character = service.getCharacter(id);
    CharacterResponseDTO characterResponseDTO = mapper.toCharacterResponseDTO(character);

    return ResponseEntity
        .ok(characterResponseDTO);
  }

  @PostMapping
  public ResponseEntity<CharacterResponseDTO> createCharacter(CreateCharacterRequestDTO createCharacterRequestDTO) {
    logger.info("Creating character with createCharacterRequestDTO={}", createCharacterRequestDTO);

    CreateCharacterRequest createCharacterRequest = mapper.toCreateCharacterRequest(createCharacterRequestDTO);
    Character character = service.createCharacter(createCharacterRequest);
    CharacterResponseDTO characterResponseDTO = mapper.toCharacterResponseDTO(character);

    logger.debug("Created character with createCharacterRequestDTO={}", createCharacterRequestDTO);

    return ResponseEntity
        .created(URI.create("")) // todo - return id here
        .body(characterResponseDTO);
  }

  @PutMapping
  public ResponseEntity createOrUpdateCharacter(CreateOrUpdateCharacterRequestDTO createOrUpdateCharacterRequestDTO) {
    logger.info("Creating or updating character with createOrUpdateCharacterRequestDTO={}", createOrUpdateCharacterRequestDTO);

    CreateOrUpdateCharacterRequest createOrUpdateCharacterRequest = mapper.toUpdateCharacterRequest(createOrUpdateCharacterRequestDTO);
    Character character = service.updateCharacter(createOrUpdateCharacterRequest);
    CharacterResponseDTO characterResponseDTO = mapper.toCharacterResponseDTO(character);

    if (isValidId(createOrUpdateCharacterRequestDTO.getId())) {
      logger.debug("Updated character with createOrUpdateCharacterRequestDTO={}", createOrUpdateCharacterRequestDTO);
      return ResponseEntity
          .noContent()
          .location(URI.create("")) // todo - return id here
          .build();
    } else {
      logger.debug("Created character with createOrUpdateCharacterRequestDTO={}", createOrUpdateCharacterRequestDTO);
      return ResponseEntity
          .created(URI.create("")) // todo - return id here
          .body(characterResponseDTO);
    }
  }

  private boolean isValidId(String id) {
    try {
      service.getCharacter(id);
      return true;
    } catch (CharacterNotFoundException e) {
      return false;
    }
  }
}