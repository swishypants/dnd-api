package charactermanager.domain;

import charactermanager.domain.enums.CharacterClass;
import charactermanager.domain.enums.CharacterRace;
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
