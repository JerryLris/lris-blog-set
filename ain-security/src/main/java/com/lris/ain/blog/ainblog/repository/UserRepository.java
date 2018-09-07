package com.lris.ain.blog.ainblog.repository;

import org.springframework.data.repository.CrudRepository;

import com.lris.ain.blog.ainblog.domain.User;

/**
 * 用户仓库.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
