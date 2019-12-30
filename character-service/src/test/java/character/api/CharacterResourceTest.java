package character.api;

import character.domain.Character;
import character.dto.CharacterResponseDTO;
import character.mapper.CharacterMapper;
import character.repository.exceptions.CharacterNotFoundException;
import character.service.CharacterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CharacterResource.class)
class CharacterResourceTest {

    private static final String CHARACTER_ID = UUID.randomUUID().toString();
    private static Character character;
    private static CharacterResponseDTO characterResponseDTO;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService service;

    @MockBean
    private CharacterMapper mapper;

    @BeforeAll
    static void setup() {
        character = new Character();
        characterResponseDTO = new CharacterResponseDTO();
    }

    @Test
    void testGetCharacter() throws Exception {
        when(service.getCharacter(CHARACTER_ID)).thenReturn(character);
        when(mapper.toCharacterResponseDTO(character)).thenReturn(characterResponseDTO);

        mockMvc.perform(get("/characters/api/v1/" + CHARACTER_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCharacterReturns404() throws Exception {
        when(service.getCharacter(CHARACTER_ID)).thenThrow(CharacterNotFoundException.class);

        mockMvc.perform(get("/characters/api/v1/" + CHARACTER_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
