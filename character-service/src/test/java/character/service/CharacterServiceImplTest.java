package character.service;

import character.TestConfig;
import character.domain.Character;
import character.repository.CharacterRepository;
import character.repository.exceptions.CharacterNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class CharacterServiceImplTest {

    private static final String CHARACTER_ID = UUID.randomUUID().toString();
    private static Character character;

    @Autowired
    private CharacterService service;

    @MockBean
    private CharacterRepository repository;

    @BeforeAll
    static void setup() {
        character = new Character();
        character.setId(CHARACTER_ID);
    }

    @Test
    void testGetCharacter() {
        when(repository.findByCharacterId(CHARACTER_ID)).thenReturn(Optional.of(character));
        Character character = service.getCharacter(CHARACTER_ID);
        assertEquals(CHARACTER_ID, character.getId());
    }

    @Test
    void testGetCharacterThrowsException() {
        when(repository.findByCharacterId(CHARACTER_ID)).thenThrow(new CharacterNotFoundException(CHARACTER_ID));
        assertThrows(CharacterNotFoundException.class, () -> service.getCharacter(CHARACTER_ID));
    }
}
