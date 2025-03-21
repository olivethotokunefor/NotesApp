package com.example.Notes.Model;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private int id;
    private String note;
    private String title;

    public Note() {
    }

    public Note(String note, String title) {
        this.note = note;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
