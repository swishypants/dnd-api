package character.domain;

import character.domain.enums.CharacterClass;
import character.domain.enums.CharacterRace;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCharacterRequest {

  String name;
  CharacterRace characterRace;
  CharacterClass characterClass;
  int level = 1;
}
