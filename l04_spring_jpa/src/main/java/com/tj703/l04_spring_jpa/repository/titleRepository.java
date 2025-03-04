package com.tj703.l04_spring_jpa.repository;

import com.tj703.l04_spring_jpa.entity.Title;
import com.tj703.l04_spring_jpa.entity.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface titleRepository extends JpaRepository<Title, TitleId> { // <엔터티, pk의 타입>

    List<Title> findByEmpNo(int enpNo);
    List<Title> findByTitle(String title);

}
