package com.example.NumberGame.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity //create Entity for DB
@Table(name = "request_table")
public class RequestTable {

    @Column(name = "real_n")
    private int real;
    @Column(name = "guess_n")
    private int guess;
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Column(name = "request_id")
    private UUID id;

    public RequestTable() {

    }

    public RequestTable(int real, int guess) {
        this.real = real;
        this.guess = guess;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestTable that = (RequestTable) o;
        return real == that.real &&
                guess == that.guess &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(real, guess, id);
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}
