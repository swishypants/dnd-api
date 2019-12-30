package character.mapper;

import character.domain.Character;
import character.dto.CharacterResponseDTO;
import character.dto.CreateCharacterRequestDTO;
import character.dto.CreateOrUpdateCharacterRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

  public abstract CharacterResponseDTO toCharacterResponseDTO(Character character);

  public abstract Character toCharacter(CreateCharacterRequestDTO createCharacterRequestDTO);

  public abstract Character toCharacter(CreateOrUpdateCharacterRequestDTO createOrUpdateCharacterRequestDTO);

  /**
   * Mappers for subclasses
   **/
  abstract CharacterResponseDTO.ClassDetails toClassDetails(Character.ClassDetails classDetails);

  abstract CharacterResponseDTO.Stats toStats(Character.Stats stats);

  abstract CharacterResponseDTO.HitPoints toHitPoints(Character.HitPoints hitPoints);
}
