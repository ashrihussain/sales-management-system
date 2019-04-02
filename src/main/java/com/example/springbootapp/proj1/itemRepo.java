package com.example.springbootapp.proj1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface itemRepo extends CrudRepository<items, String> {

    List<items> findAll();
    List<items> findByItemname(String itemname);
    List<items> findDistinctItempriceByItemname(String Itemname);
    

    @Query("Select i.itemname from items i")
    List<items> itemNames();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("Update items i set i.itemprice=:#{#newVal} where i.itemname=:#{#itemName}")
    void updateItem(@Param("newVal") int newVal, @Param("itemName") String itemname);





    // update item price where itemname = black shirt
}