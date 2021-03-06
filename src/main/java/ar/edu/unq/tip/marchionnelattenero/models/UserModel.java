package ar.edu.unq.tip.marchionnelattenero.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "UserModel")
@XmlRootElement(name = "userModel")
public class UserModel {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue()
    @Column(name = "USER_MODEL_ID")
    private int id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "name")
    private String name;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    private Place place;

    public UserModel() {
    }

    public UserModel(String name, String nickname, String email) {
        super();
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getUserId();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getUserId().equals(((UserModel) obj).getUserId());
    }

    @Override
    public int hashCode() {
        return this.getUserId().hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
