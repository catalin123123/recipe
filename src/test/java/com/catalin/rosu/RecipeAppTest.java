package com.catalin.rosu;

import com.catalin.rosu.entity.Recipe;
import com.catalin.rosu.repository.RecipeRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RecipeAppTest {

    @Autowired
    RecipeRepository repo;
    @Test
    void contextLoads() {

    }

    @Test
    @Order(1)
    public void testCreate () {
        Recipe p = new Recipe("pizza", new ArrayList(List.of("Mozzarella","Bacon")), 2,true);
        repo.save(p);
        assertNotNull(repo.findById(1).get());
    }

    @Test
    @Order(3)
    public void testRead () {
       // Recipe product = repo.findById(1).get();
        Recipe p = new Recipe("pizza", new ArrayList(List.of("Mozzarella","Bacon")), 2,true);
        repo.save(p);
        Recipe q = new Recipe("pizza2", new ArrayList(List.of("Mozzarella","Bacon")), 2,true);
        repo.save(q);
        Recipe r = repo.findAll().get(1);
        assertEquals("pizza2", r.getName());
    }


}
