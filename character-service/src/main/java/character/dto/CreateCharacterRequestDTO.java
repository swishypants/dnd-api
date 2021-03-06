package character.dto;

import character.domain.enums.CharacterClass;
import character.domain.enums.CharacterRace;
import lombok.Getter;
import lombok.Setter;

/**
 * For now, assume all newly created characters start at level 1.
 */
@Getter
@Setter
public class CreateCharacterRequestDTO {

  String name;
  CharacterRace characterRace;
  CharacterClass characterClass;
  int level = 1;
}
