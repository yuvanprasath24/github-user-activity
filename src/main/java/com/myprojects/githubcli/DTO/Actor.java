package com.myprojects.githubcli.DTO;

public class Actor {

    private int id;
    private String login;
    private String display_login;
    private String gravatar_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDisplay_login() {
        return display_login;
    }

    public void setDisplay_login(String display_login) {
        this.display_login = display_login;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }
}
