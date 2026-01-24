package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class JournalEntryService {
    @Autowired
    JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry myEntry){
        journalEntryRepository.save(myEntry);
    }

    public List<JournalEntry> findAllJournalEntry(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteJournalEntryById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

}
