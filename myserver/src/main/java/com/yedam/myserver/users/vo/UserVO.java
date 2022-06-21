package com.yedam.myserver.users.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {
   
   private String id;
   private String password;
   private String name;
   private String role;
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getRole() {
      return role;
   }
   public void setRole(String role) {
      this.role = role;
   }
   @Override
   public String toString() {
      return "UserVO [id=" + id + ", password=" + password + ", name=" + name
            + ", role=" + role + "]";
   }
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      //권한 지정
      List<GrantedAuthority> auth = new ArrayList<>();
      auth.add(new SimpleGrantedAuthority("ROLE_" + this.role.toUpperCase()));
      return null;
   }
   @Override
   public String getUsername() {
      // TODO Auto-generated method stub
      return id;
   }
   @Override
   public boolean isAccountNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isAccountNonLocked() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isCredentialsNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isEnabled() {
      // TODO Auto-generated method stub
      return true;
   }
   
}