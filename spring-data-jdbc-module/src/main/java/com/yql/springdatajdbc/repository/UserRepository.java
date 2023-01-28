package com.yql.springdatajdbc.repository;

import com.yql.springdatajdbc.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Package com.yql.springdatajdbc.repository
 * @ClassName UserRepository
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/20
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
}
