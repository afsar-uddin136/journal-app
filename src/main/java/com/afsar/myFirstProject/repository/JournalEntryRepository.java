package com.afsar.myFirstProject.repository;

import com.afsar.myFirstProject.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {
}
