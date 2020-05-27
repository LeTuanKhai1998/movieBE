package com.example.movieBE.dto;

import com.example.movieBE.entity.CommentEntity;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private String user_name;

    private String description;

    private ImageUserDto avatar;

    private Instant update_time;

    private Long avatar_id;

    public CommentDto(CommentEntity comment, UserEntity user, ImageUserEntity imageUser){
        if(ObjectUtils.allNotNull(comment)){
            this.description = comment.getDescription();
            this.update_time = comment.getUpdate_time();
        }
        if(ObjectUtils.allNotNull(user)){
            this.user_name = user.getLastname() +" "+user.getFirstname();
        }
        if(ObjectUtils.allNotNull(imageUser)){
            this.avatar_id = imageUser.getId();
        }
    }
}
