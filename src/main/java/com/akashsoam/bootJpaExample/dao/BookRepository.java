package com.akashsoam.bootJpaExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.akashsoam.bootJpaExample.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	public Book findById(int id);

}
