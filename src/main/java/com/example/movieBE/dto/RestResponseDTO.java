package com.example.movieBE.dto;

import com.example.movieBE.constant.APIConst;
import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 *
 * @param <DTO>
 */
@Data
public class RestResponseDTO<DTO> {

    /**
     *
     */
    private String status;

    /**
     * Error messages, if any
     */
    private String message;

    /**
     *
     */
    private Instant timestamp;

    /**
     *
     */
    private String requestPath;

    /**
     */
    private DTO data;

    private Map<String, String> fieldErrors;

    public RestResponseDTO() {
        this.setStatus(APIConst.SUCCESS);
        this.setMessage("");
        this.setTimestamp(new Date().toInstant());
        HttpServletRequest currentHttpRequest = this.getCurrentHttpRequest();
        if (currentHttpRequest != null) {
            this.setRequestPath(currentHttpRequest.getRequestURL().toString());
        } else {
            this.setRequestPath("");
        }

        this.setFieldErrors(null);
    }
    public RestResponseDTO(boolean isSuccess) {
        if (isSuccess) {
            this.setStatus(APIConst.SUCCESS);
            this.setMessage("");
        } else {
            this.setStatus(APIConst.ERROR);
            this.setMessage(APIConst.ERROR_MESSAGE);
        }

        this.setTimestamp(new Date().toInstant());
        HttpServletRequest currentHttpRequest = this.getCurrentHttpRequest();
        if (currentHttpRequest != null) {
            this.setRequestPath(currentHttpRequest.getRequestURL().toString());
        } else {
            this.setRequestPath("");
        }

    }

    private HttpServletRequest getCurrentHttpRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request;
        }
        return null;
    }
}
