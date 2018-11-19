package com.repository;

import com.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface WordRepository extends JpaRepository<Word,Integer> {

    List<Word> findWordByIdEquals(int id);

    @Query(value = "select * from word  limit ?1", nativeQuery = true)
    @Modifying
    List<Word> findDayNumWords(int dayNum);
}
