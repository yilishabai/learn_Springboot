package com.sevice;

import com.model.Word;
import com.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public Word get(int id){
        return wordRepository.getOne(id);
    }

    public List<Word> findAll(){
        List<Word> all = wordRepository.findAll();
        return all;
    }

    public List<Word> findWordById(int id){
        return wordRepository.findWordByIdEquals(id);
    }

    public List<Word> getWordDaynum(int dayNum){
        List<Word> wordList = null;
        wordList = wordRepository.findDayNumWords(dayNum);
        return  wordList;
    }
}
