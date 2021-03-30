package com.in28minutes.junitMockito.section3.service;

import com.project.SpringBoot.entity.Item;
import com.project.SpringBoot.repository.ItemRepository;
import com.project.SpringBoot.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    // testing the business logic i.e the service layer methods
    @Test
    public void getAllItemByRepositoryTest(){
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(new Item("gloves",5,45.0),
                new Item("glasses",7,78.0),
                new Item("pot",3,60.0)));

        List<Item> itemList=itemService.getAllItemFromRepository();
        assertEquals(225.0,itemList.get(0).getTotalAmount());
        assertEquals(546.0,itemList.get(1).getTotalAmount());
        assertEquals(180.0,itemList.get(2).getTotalAmount());
    }

}
