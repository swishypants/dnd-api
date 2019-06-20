package charactermanager.dto;

import charactermanager.domain.enums.CharacterClass;
import charactermanager.domain.enums.CharacterRace;
import java.util.Map;
import lombok.Data;

@Data
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

  private class ClassDetails {

    // key=class value=levels
    Map<CharacterClass, Integer> classLevelsMap;
  }

  private class Stats {

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

  private class HitPoints {

    int max;
    int curr;
  }
}
