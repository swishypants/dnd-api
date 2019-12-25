package character.dto;

import character.domain.enums.CharacterClass;
import character.domain.enums.CharacterRace;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CharacterResponseDTO {

  String id;

  String name;

  // base character traits
  CharacterRace characterRace;
  ClassDetails classDetails;

  // character stats information
  int level; // total character level
  Stats stats;
  HitPoints hitPoints;

  // gameplay related stats
  int speed;
  int initiativeBonus;

  @Getter
  @Setter
  public static class ClassDetails {

    // key=class value=levels
    Map<CharacterClass, Integer> classLevelsMap;
  }

  @Getter
  @Setter
  public static class Stats {

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    // todo - should this live in the service layer?
    int getModifier(int stat) {
      return (stat / 2) - 5;
    }
  }

  @Getter
  @Setter
  public static class HitPoints {

    int max;
    int curr;
  }
}
