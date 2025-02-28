package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.title;
import com.tj703.l04_spring_jpa.entity.titleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface titleRepository extends JpaRepository<title, titleId> { // <엔터티, pk의 타입>

    List<title> findByEmpNo(int enpNo);
    List<title> findByTitle(String title);

}
