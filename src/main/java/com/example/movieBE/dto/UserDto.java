package com.example.movieBE.dto;

import com.example.movieBE.converter.CountryConverter;
import com.example.movieBE.converter.ImageUserConverter;
import com.example.movieBE.converter.UserRoleConverter;
import com.example.movieBE.entity.CountryEntity;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

     private Long id;

     private String username;

     private String firstname;

     private String lastname;

     private String password;

     private String email;

      private CountryDto country;

      private ImageUserDto avatar;

      private UserRoleDto role;

     public UserDto(UserEntity user, CountryEntity country, ImageUserEntity imageUser, UserRoleEntity userRole){
         this.id = user.getId();
         this.username = user.getUsername();
         this.firstname = user.getFirstname();
         this.lastname = user.getLastname();
         this.email = user.getEmail();
         CountryConverter countryConverter = new CountryConverter();
         this.country = countryConverter.toDTO(country);
         ImageUserConverter imageUserConverter = new ImageUserConverter();
         this.avatar = imageUserConverter.toDTO(imageUser);
         UserRoleConverter userRoleConverter =  new UserRoleConverter();
         this.role = userRoleConverter.toDTO(userRole);
     }
}
