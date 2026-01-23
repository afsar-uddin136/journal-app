package com.afsar.myFirstProject.controller;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import com.afsar.myFirstProject.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId){
        return null;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return null;
    }
}
