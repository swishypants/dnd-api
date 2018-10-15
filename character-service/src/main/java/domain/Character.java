package domain;

import domain.enums.CharacterClass;
import domain.enums.CharacterRace;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
public class Character {
  CharacterRace characterRace;
  ClassDetails classDetails;

  @Getter
  @Setter
  private class ClassDetails {
    Map<CharacterClass, Integer> classMap;
  }
}
