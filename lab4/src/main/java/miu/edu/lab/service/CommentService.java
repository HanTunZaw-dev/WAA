package miu.edu.lab.service;

import miu.edu.lab.domain.Comment;
import miu.edu.lab.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    public List<CommentDto> getByPostId(long id);
    public void addComment (CommentDto c);
    public void deleteComment(long id);


}
