package com.cassur.fortscale.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cassur.fortscale.domain.User;


/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    //User findUserById(String id);
    Page<User> findAll(Pageable pageable);
}
