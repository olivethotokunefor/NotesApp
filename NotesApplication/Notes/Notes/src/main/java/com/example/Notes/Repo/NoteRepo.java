package com.example.Notes.Repo;

import com.example.Notes.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Integer> {
}
