package com.example.VueDemo.service;


import com.example.VueDemo.Enum.ResultEnum;
import com.example.VueDemo.entity.Item;
import com.example.VueDemo.exception.BusinessException;
import com.example.VueDemo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItem(){
        return itemRepository.findAll();
    }

    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }

    public void addNewItem(Item newItem) {
        List<Item> items=getAllItem();
        long num=items.stream().filter(item->
            item.getTitle().equals(newItem.getTitle())
        ).count();
        if(num>0){
            throw new BusinessException(ResultEnum.INSERT_ERROR);
        }
        itemRepository.saveAndFlush(newItem);
    }


    public void changeStatusByID(String id,Item item) {
        Item changeItem= itemRepository.findById(id).get();
        changeItem.setCompleted(item.getCompleted());
        itemRepository.saveAndFlush(changeItem);
    }
}
