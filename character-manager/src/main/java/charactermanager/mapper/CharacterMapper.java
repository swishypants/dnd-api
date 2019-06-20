package charactermanager.mapper;

import charactermanager.domain.Character;
import charactermanager.dto.CharacterResponseDTO;
import charactermanager.dto.CreateCharacterRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

  public abstract CharacterResponseDTO characterToCharacterResponseDTO(Character character);

  public abstract Character createCharacterRequestDTOToCharacter(CreateCharacterRequestDTO createCharacterRequestDTO);

}
