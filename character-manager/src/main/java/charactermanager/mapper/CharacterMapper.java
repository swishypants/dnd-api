package charactermanager.mapper;

import charactermanager.domain.Character;
import charactermanager.domain.CreateCharacterRequest;
import charactermanager.domain.CreateOrUpdateCharacterRequest;
import charactermanager.dto.CharacterResponseDTO;
import charactermanager.dto.CreateCharacterRequestDTO;
import charactermanager.dto.CreateOrUpdateCharacterRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

  public abstract CharacterResponseDTO toCharacterResponseDTO(Character character);

  public abstract CreateCharacterRequest toCreateCharacterRequest(CreateCharacterRequestDTO createCharacterRequestDTO);

  public abstract CreateOrUpdateCharacterRequest toUpdateCharacterRequest(CreateOrUpdateCharacterRequestDTO createOrUpdateCharacterRequestDTO);

  /**
   * Mappers for subclasses
   **/
  abstract CharacterResponseDTO.ClassDetails toClassDetails(Character.ClassDetails classDetails);

  abstract CharacterResponseDTO.Stats toStats(Character.Stats stats);

  abstract CharacterResponseDTO.HitPoints toHitPoints(Character.HitPoints hitPoints);

  abstract CreateOrUpdateCharacterRequest.ClassDetails toClassDetails(CreateOrUpdateCharacterRequestDTO.ClassDetails classDetails);

  abstract CreateOrUpdateCharacterRequest.Stats toStats(CreateOrUpdateCharacterRequestDTO.Stats stats);

  abstract CreateOrUpdateCharacterRequest.HitPoints toHitPoints(CreateOrUpdateCharacterRequestDTO.HitPoints hitPoints);

}
