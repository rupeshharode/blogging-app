package com.blog.blogging.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class post {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private int id;
private String title;
private String content;
private String author;
public post() {
    
}
public post(int id, String title, String content, String author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}


}
