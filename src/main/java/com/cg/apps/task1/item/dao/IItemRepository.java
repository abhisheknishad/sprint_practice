package com.cg.apps.task1.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.task1.item.entites.Item;

public interface IItemRepository extends JpaRepository<Item,String>{

}
