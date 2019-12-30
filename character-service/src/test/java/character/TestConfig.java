package character;

import character.repository.CharacterRepository;
import character.service.CharacterService;
import character.service.CharacterServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public CharacterService service(CharacterRepository repository) {
        return new CharacterServiceImpl(repository);
    }
}
