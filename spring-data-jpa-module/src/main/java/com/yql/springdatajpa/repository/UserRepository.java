package com.yql.springdatajpa.repository;

import com.yql.springdatajpa.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Package com.yql.springdatajpa.repository
 * @ClassName UserRepository
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
}
