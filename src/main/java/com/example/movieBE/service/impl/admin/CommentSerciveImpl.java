package com.example.movieBE.service.impl.admin;

import com.example.movieBE.constant.StringConstant;
import com.example.movieBE.converter.ImageUserConverter;
import com.example.movieBE.dto.CommentDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.CommentEntity;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.form.CommentForm;
import com.example.movieBE.form.CommentPostForm;
import com.example.movieBE.repository.CommentRepository;
import com.example.movieBE.repository.ImageUserRepository;
import com.example.movieBE.service.admin.CommentSercive;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class CommentSerciveImpl implements CommentSercive {

    /**
     *
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     *
     */
    @Autowired
    private ImageUserRepository imageUserRepository;

    /**
     *
     */
    @Autowired
    private ImageUserConverter imageUserConverter;

    @Override
    public ResponseTemplate postComment(CommentPostForm form) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(form, form.getMovie_id(), form.getUser_id())) {
            CommentEntity entity = new CommentEntity(form.getMovie_id(), form.getUser_id(), form.getDescription(), Instant.now(), Instant.now());
            entity = commentRepository.save(entity);
            if (ObjectUtils.allNotNull(entity)) {
                response.setData("message", StringConstant.Successful);
            } else {
                response.setData("message", StringConstant.Fail);
            }
        } else {
            response.setData("message", StringConstant.Fail);
        }
        return response;
    }

    @Override
    public ResponseTemplate getCommentByMovieId(CommentForm form) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(form, form.getMovie_id(), form.getPagination())) {
            Page<CommentDto> commentDtos = commentRepository.getCommentByMovieId(form.getMovie_id(), PageRequest.of(form.getPagination().getCurrentPage(), form.getPagination().getItemsPerPage()));
            Optional<ImageUserEntity> imageUser;
            for (CommentDto commentDto : commentDtos.getContent()) {
                imageUser = imageUserRepository.findById(commentDto.getAvatar_id());
                if (ObjectUtils.allNotNull(imageUser) && imageUser.isPresent()) {
                    commentDto.setAvatar(imageUserConverter.toDTO(imageUser.get()));
                }
            }
            response.setData("data", commentDtos.getContent());
            response.setData("TotalPages", commentDtos.getTotalPages());
        }
        return response;
    }
}
