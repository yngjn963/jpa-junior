package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // DB 테이블과 매핑 대상
@Table(name = "user") // user 테이블과 매핑
public class User {
    @Id
    private String email;
    private String name;
    @Column(name = "create_date")
    private LocalDateTime createDate;

    protected User() {

    }

    public User(String email, String name, LocalDateTime createDate) {
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
