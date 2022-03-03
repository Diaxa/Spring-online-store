package com.example.Springonlinestore.repositories;

import com.example.Springonlinestore.entities.Goods;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<Goods, Long> {
}
