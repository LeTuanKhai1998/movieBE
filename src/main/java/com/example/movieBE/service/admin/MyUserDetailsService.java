package com.example.movieBE.service.admin;


import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.entity.UserRoleEntity;
import com.example.movieBE.service.impl.admin.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        UserEntity user = userService.findUserByUserName(userName);
        List<UserRoleEntity> userRoles = userService.findRole();
        List<GrantedAuthority> authorities = new ArrayList();
        for (UserRoleEntity role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        UserDetails userDetails = buildUserForAuthentication(user, authorities);

        return userDetails;
    }

    private List<GrantedAuthority> getUserAuthority(Set<UserRoleEntity> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (UserRoleEntity role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword()
                , authorities);
    }
}