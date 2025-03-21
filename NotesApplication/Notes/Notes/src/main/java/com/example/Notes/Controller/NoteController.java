package com.example.Notes.Controller;

import com.example.Notes.Model.Note;
import com.example.Notes.Repo.NoteRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/notes")
public class NoteController {

    private final NoteRepo noteRepo;


    public NoteController(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    record CreateNoteRequest(String title, String note){}


    @PostMapping("/register")
    private void registerNote(@RequestBody Note note){
        noteRepo.save(note);

    }

    @GetMapping("/get")
    private List<Note> getNotes(){
       return noteRepo.findAll();

    }
    @GetMapping("/get/{id}")
    public Note getOneNote(@PathVariable("id") Integer id) {
        return noteRepo.findById(id).orElse(null);
    }


    @DeleteMapping("/delete/{name}")
    public void deleteItems(@PathVariable Integer id,
                            @RequestBody CreateNoteRequest request){
        Note note= new Note();
        note= noteRepo.findById(id).get();
        noteRepo.delete(note);
    }


    @PutMapping("/update/{name}")
    public void update(@PathVariable Integer id,
                       @RequestBody CreateNoteRequest updateRequest){
        Note note = noteRepo.findById(id).get();
        note.setTitle(updateRequest.title());
        note.setNote(updateRequest.note());

        noteRepo.save(note);
    }
}

