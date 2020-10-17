package com.hostelregistration.hostelregistrtion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="warden")
public class Warden implements UserDetails {

    @Id
    private String wardenid;
    private String email;
    private Long mobileNumber;
    private String firstName;
    private String lastName;
    private String hostelId;
    private String password;
    private String confirmPassword;


    public String getwardenid() {
        return wardenid;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }


    public void setPassword(String password) {
        this.password = password;
    }




    public Object getFirstName() {
        return firstName;
    }

    public Object getLastName() {
        return lastName;
    }
    public Object getEmail(){
        return email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }


}
