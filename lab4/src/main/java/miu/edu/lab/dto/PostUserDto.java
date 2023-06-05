package miu.edu.lab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab.domain.Post;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUserDto {
    private long id;
    private String name;
}
