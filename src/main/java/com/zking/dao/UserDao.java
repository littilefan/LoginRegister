package com.zking.dao;

import com.zking.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zking.entity.User;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2017/5/12.
 */


@Repository
public interface UserDao extends CrudRepository<UserEntity,Long>{

    public UserEntity findByUsernameAndPassword(String username,String password);

}


//@Repository
//public interface UserDao extends JpaRepository<User, Long>{
//    @Query("select s from User s where s.username=?1 and s.password=?2")
//    public UserEntity findBynameAndPassword(String username,String password);
//    @Query("select s from User s where s.username=?")
//    public UserEntity findByName(String username);
//
//}
