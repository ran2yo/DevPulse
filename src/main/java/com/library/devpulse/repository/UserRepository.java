package com.library.devpulse.repository;

import com.library.devpulse.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //이름 일부로 검색하는 메서드
    List<User> findByNameContaining(String name);  // LIKE 검색


    // 나이 기준 필터링
    List<User> findByAgeGreaterThan(int age);


    //이메일 단위 조회
    List<User> findByEmail(String email);

}
