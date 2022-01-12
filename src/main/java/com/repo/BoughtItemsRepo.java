package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.BoughtItems;


@Repository
@EnableJpaRepositories
public interface BoughtItemsRepo extends JpaRepository<BoughtItems, Integer>  {

	
		public List<BoughtItems> findAllByOrderByNumsDesc();
	
}
