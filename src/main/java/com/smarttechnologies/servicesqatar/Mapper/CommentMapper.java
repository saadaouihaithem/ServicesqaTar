package com.smarttechnologies.servicesqatar.Mapper;



import com.smarttechnologies.servicesqatar.Entities.Comments;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.dto.CommentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "Post", source = "postId")
    @Mapping(target = "Id", source = "id")
    Comments  map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comments comment);
}