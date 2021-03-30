package com.in28minutes.junitMockito.section3.repository;

import com.project.SpringBoot.entity.Item;
import com.project.SpringBoot.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll(){
        List<Item> itemList= (List<Item>) itemRepository.findAll();
        assertEquals(4,itemList.size());
    }

    @Test
    public void testFindOne(){
        Item item=itemRepository.findById(111l).orElse(null);
        assertEquals("table",item.getItemName());
    }

}
