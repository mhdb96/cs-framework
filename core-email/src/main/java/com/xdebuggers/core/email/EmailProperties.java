package com.xdebuggers.core.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Objects;

/**
 * Configuration properties for email.
 */
@ConfigurationProperties(prefix = "cs.email")
public class EmailProperties {

    private String host;
    private int port;
    private String username;
    private String password;

    public EmailProperties() {
    }

    public EmailProperties(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmailProperties host(String host) {
        setHost(host);
        return this;
    }

    public EmailProperties port(int port) {
        setPort(port);
        return this;
    }

    public EmailProperties username(String username) {
        setUsername(username);
        return this;
    }

    public EmailProperties password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmailProperties)) {
            return false;
        }
        EmailProperties emailProperties = (EmailProperties) o;
        return Objects.equals(host, emailProperties.host) && port == emailProperties.port
                && Objects.equals(username, emailProperties.username)
                && Objects.equals(password, emailProperties.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, username, password);
    }

    @Override
    public String toString() {
        return "{" +
                " host='" + getHost() + "'" +
                ", port='" + getPort() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

    // Getters and Setters
}