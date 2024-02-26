package Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostImageUploadDTO {
    private List<MultipartFile> files;
}
