package com.smarttechnologies.servicesqatar.Entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;



 @Entity
public class User implements Serializable {

     private static final long serialVersionUID = 1L;
       @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
       @Column(nullable = false, updatable = false)
        private Long idUser;
        private String name;
        private String email;
        private String Password;
        private String phone;
        private String imageUrl;


        public User() {
        }

        public User(Long idUser, String name, String email, String password, String phone, String imageUrl) {
            this.idUser = idUser;
            this.name = name;
            this.email = email;
            Password = password;
            this.phone = phone;
            this.imageUrl = imageUrl;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
            return "User{" +
                    "idUser=" + idUser +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", Password='" + Password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }
    }

