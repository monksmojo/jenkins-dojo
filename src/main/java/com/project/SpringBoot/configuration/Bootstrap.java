package com.project.SpringBoot.configuration;

import com.project.SpringBoot.entity.Item;
import com.project.SpringBoot.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;

    private static final Logger LOGGER=LoggerFactory.getLogger(Bootstrap.class);

    @Override
    public void run(String... args) throws Exception {
        List<Item> itemList= Arrays.asList(new Item(2l,"gloves",5,45.0),
                new Item(3l,"glasses",7,78.0),
                new Item(4l,"pot",3,60.0),
                new Item(6l,"plates",6,80.0));
        itemRepository.saveAll(itemList);
        LOGGER.info("the database has been populated");

    }
}
