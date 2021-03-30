package com.project.SpringBoot.controller;

import com.project.SpringBoot.entity.Item;
import com.project.SpringBoot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {


    @Autowired
    ItemService itemService;

    @PostMapping(path="/save-one")
    public ResponseEntity<Boolean> saveItem(@RequestBody Item item){
        if(itemService.saveOne(item)){
            return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = "/get-one")
    public Item getOne(){
        return new Item(23l,"biscuits",3,10.00);
    }

    @GetMapping(path = "/get-one-by-service")
    public Item getOneItem(){
        return this.itemService.getOneItemByService();
    }

    @GetMapping(path = "/get-all")
    public List<Item> getAlItemFromRepository(){
        return itemService.getAllItemFromRepository();
    }
}
