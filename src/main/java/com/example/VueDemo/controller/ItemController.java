package com.example.VueDemo.controller;

import com.example.VueDemo.entity.Item;
import com.example.VueDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    public ResponseEntity getAllItem(){
        List<Item> allItem=itemService.getAllItem();
        return ResponseEntity.ok().body(allItem);
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity addNewItem(@RequestBody Item newItem){
        itemService.addNewItem(newItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
//    @GetMapping(params = {"page","pageSize"})
//    public  ResponseEntity getAll(@RequestParam int page,int pageSize){
//        Page<ParkingLot> parkingLot= parkingLotService.findAll(page,pageSize);
//        List<ParkingLot> parkingLotList=parkingLot.getContent();
//        return ResponseEntity.ok().body(parkingLotList);
//    }








}
