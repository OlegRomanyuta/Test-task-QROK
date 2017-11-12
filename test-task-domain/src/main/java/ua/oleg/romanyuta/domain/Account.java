package ua.oleg.romanyuta.domain;

import javax.persistence.*;

@Entity
public class Account extends DomainObject {

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public Account(){}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
