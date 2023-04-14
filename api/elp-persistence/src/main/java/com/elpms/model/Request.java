package com.elpms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Author: Duncan MacLeod (101160585)
 *
 * Represents the 'request' table in the database
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request")
@Entity
public class Request {

    @Id //Primary key
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "signout_date")
    private LocalDate signout_date;

    @Column(name = "return_date")
    private LocalDate return_date;
}
