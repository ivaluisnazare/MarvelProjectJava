package com.projectmarvel.projectmarvelDio.repository;

import com.projectmarvel.projectmarvelDio.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {
}
