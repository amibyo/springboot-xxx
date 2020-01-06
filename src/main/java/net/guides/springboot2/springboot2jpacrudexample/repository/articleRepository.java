package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.article;

@Repository
public interface articleRepository extends JpaRepository<article, Long>{

List<article> findBycat(String cat); 




	
}
