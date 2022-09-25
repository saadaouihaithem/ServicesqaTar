package com.smarttechnologies.servicesqatar.Entities;


import javax.persistence.*;

@Entity
public class NotificationEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String subject;
        private String recipient;
        private String body;


    public NotificationEmail(String subject, String recipient, String body) {
        this.subject = subject;
        this.recipient = recipient;
        this.body = body;
    }

    public NotificationEmail() {

    }









    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }





}

