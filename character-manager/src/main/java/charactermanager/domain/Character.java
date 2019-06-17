package charactermanager.domain;

import charactermanager.domain.enums.CharacterClass;
import charactermanager.domain.enums.CharacterRace;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
public class Character {

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
  private class ClassDetails {
    // key=class value=levels
    Map<CharacterClass, Integer> classLevelsMap;
  }

  @Getter
  @Setter
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

  @Getter
  @Setter
  private class HitPoints {
    int max;
    int curr;
  }
}
