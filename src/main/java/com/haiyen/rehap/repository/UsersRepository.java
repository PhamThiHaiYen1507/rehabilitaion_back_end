package com.haiyen.rehap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.haiyen.rehap.entities.UserInfo;

public interface UsersRepository extends JpaRepository<UserInfo, Integer> {
    @Query(value = "SELECT * FROM users WHERE phone_number = ?1 LIMIT 1", nativeQuery = true)
    UserInfo findUsersByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT * FROM users WHERE phone_number = ?1 AND password = ?2 LIMIT 1", nativeQuery = true)
    UserInfo login(String phoneNumber, String password);

}
