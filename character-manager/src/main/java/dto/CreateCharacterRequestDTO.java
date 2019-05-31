package dto;

import domain.enums.CharacterClass;
import domain.enums.CharacterRace;

/**
 * For now, assume all newly created characters start at level 1.
 */
public class CreateCharacterRequestDTO {

  String name;
  CharacterRace characterRace;
  CharacterClass characterClass;
  int level = 1;
}
