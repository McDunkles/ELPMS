package com.elpms.repository;

import com.elpms.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Author: Duncan MacLeod (101160585)
 *
 * JPA Repository responsible for making queries to the database that deal with the 'item' table
 * and returns the results represented by Java objects
 */
public interface ItemRepository extends JpaRepository<Item, String> {

    @RestResource(path="findByName", rel="findByName")
    List<Item> findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    List<Item> findAll();

}
