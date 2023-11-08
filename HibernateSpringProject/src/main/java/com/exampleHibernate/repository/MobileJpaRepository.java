package com.exampleHibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.exampleHibernate.model.Mobile;
public interface MobileJpaRepository extends JpaRepository<Mobile,Integer>
{
 
}
