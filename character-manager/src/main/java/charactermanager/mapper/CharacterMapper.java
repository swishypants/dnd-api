package charactermanager.mapper;

import charactermanager.dto.CharacterResponseDTO;

// todo - mapstruct stuff
public interface CharacterMapper {

  CharacterResponseDTO toCharacterResponseDTO(Character character);

}
