package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.entity.User;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry myEntry, String username){
        myEntry.setDate(LocalDateTime.now());
        User user = userService.findByUserName(username);
        JournalEntry saved = journalEntryRepository.save(myEntry);
        user.getJournalEntries().add(saved);
        userService.saveUser(user);
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
