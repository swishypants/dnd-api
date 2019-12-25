package character.repository;

import character.domain.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public abstract class CharacterRepository implements MongoRepository {

    public abstract Optional<Character> findByCharacterId(String characterId);
}
