package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.entity.User;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import org.bson.types.BSONTimestamp;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void saveEntry(JournalEntry myEntry, String username){
        try{
            myEntry.setDate(LocalDateTime.now());
            User user = userService.findByUserName(username);
            JournalEntry saved = journalEntryRepository.save(myEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry.",e);
        }

    }
    public void saveNewEntry(JournalEntry myEntry){
        journalEntryRepository.save(myEntry);
    }

    public List<JournalEntry> findAllJournalEntry(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteJournalEntryById(ObjectId id, String username){
        User user = userService.findByUserName(username);
        user.getJournalEntries().removeIf(x-> x.getId().equals(id));
        userService.saveUser(user);
        journalEntryRepository.deleteById(id);
    }

}
