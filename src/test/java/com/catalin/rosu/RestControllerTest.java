package com.catalin.rosu;

import com.catalin.rosu.controller.Controller;
import com.catalin.rosu.entity.Recipe;
import com.catalin.rosu.repository.RecipeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest()
public class RestControllerTest {
        @Autowired
        private MockMvc mvc;
        @MockBean
        private RecipeRepository recipeService;

    @Test
    public void getAllRecipesAPI() throws Exception
    {
        mvc.perform(get("/recipes")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.recipes").exists())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.recipes[*].Id").isNotEmpty());
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/recipes")
                        .content(asJsonString(new Recipe( "Name", new ArrayList(List.of("Mozzarella","Bacon")), 2,true)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getReceiptForOrder() throws Exception {
        Recipe recipe = new Recipe( "Name", new ArrayList(List.of("Mozzarella","Bacon")), 2,true);

        when(recipeService.getById(1)).thenReturn(recipe);

        mvc.perform(get("/recipes"))
                .andExpect(status().isOk());
    }
}
