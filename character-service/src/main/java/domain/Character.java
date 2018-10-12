package domain;

import domain.enums.CharacterClass;
import domain.enums.CharacterRace;
import lombok.Data;

@Data
public class Character {
  CharacterRace characterRace;
  CharacterClass characterClass;
}
