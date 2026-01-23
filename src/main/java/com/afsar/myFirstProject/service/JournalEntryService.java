package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class JournalEntryService {
    @Autowired
    JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry myEntry){
        journalEntryRepository.save(myEntry);
    }
}
