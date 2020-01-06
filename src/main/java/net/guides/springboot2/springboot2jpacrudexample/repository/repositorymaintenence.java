package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.guides.springboot2.springboot2jpacrudexample.model.maintenance;

public interface repositorymaintenence  extends JpaRepository<maintenance, Long> {

}
