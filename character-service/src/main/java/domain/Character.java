package domain;

import domain.enums.CharacterClass;
import domain.enums.CharacterRace;
import domain.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Character {

  @Id
  String id;

  // base character traits
  CharacterRace characterRace;
  ClassDetails classDetails;

  // character stats information
  int level; // total character level
  Stats stats;
  HitPoints hitPoints;

  // gameplay related traits
  int speed;
  int initiativeBonus;

  // fluff traits
  String name;
  Gender gender;
  int age;

  @Getter
  @Setter
  private class ClassDetails {
    Map<CharacterClass, Integer> classMap;
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
