package pl.recruitmentservice.restapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class RecruitmentControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "fooClientIdPassword");
        params.add("username", username);
        params.add("password", password);

        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic("fooClientIdPassword","secret"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    public void login() throws Exception{
    }

    @Test
    public void whenLogged_getPersons_returnsOk() throws Exception{
/*        String accessToken = obtainAccessToken("admin","admin");
        mockMvc.perform(get("/persons")
                .header("Authorization", "Bearer " + accessToken)
                .param("", ""))
                .andExpect(status().isOk());*/
    }

    @Test
    public void whenNotLogged_getPersons_returnsForbidden() throws Exception{
        mockMvc.perform(get("/persons")).
                andExpect(status().isForbidden());
    }

    @Test
    public void whenNotLogged_getSkills_returnsForbidden() throws Exception{
        mockMvc.perform(get("/skills")).
                andExpect(status().isForbidden());
    }

    @Test
    public void whenNotLogged_getLevels_returnsForbidden() throws Exception{
        mockMvc.perform(get("/levels")).
                andExpect(status().isForbidden());
    }

    @Test
    public void whenNotLogged_getPersonsSkills_returnsForbidden() throws Exception{
        mockMvc.perform(get("/personSkills")).
                andExpect(status().isForbidden());
    }

    @Test
    public void whenLogged_getPersonsSkills_returnsOk() throws Exception{
        String accessToken = obtainAccessToken("admin","admin");


    }

    @Test
    public void whenNotLogged_getPersonBySkills_returnsForbidden() throws Exception{
        mockMvc.perform(get("/personsBySkills")).
                andExpect(status().isForbidden());
    }

    @Test
    public void whenNotLogged_getPersonCities_returnsForbidden() throws Exception{
        mockMvc.perform(get("/personsCities")).
                andExpect(status().isForbidden());
    }
}