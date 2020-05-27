package com.example.movieBE.dto;


import com.example.movieBE.constant.APIConst;
import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

@Data
public class BaseResponse {

    /**
     */
    private String status;

    /**
     * Error messages, if any
     */
    private String message;

    /**
     * To show or hide message popup after call API at FE client
     */
    private Boolean isShowMessage;

    /**
     *
     */
    private Instant timestamp;

    /**
     *
     */
    private String requestPath;

    public BaseResponse() {
        this.setStatus(APIConst.SUCCESS);
        this.setMessage("");
        this.setIsShowMessage(false);
        this.setTimestamp(new Date().toInstant());
        HttpServletRequest currentHttpRequest = this.getCurrentHttpRequest();
        if (currentHttpRequest != null) {
            this.setRequestPath(currentHttpRequest.getRequestURL().toString());
        } else {
            this.setRequestPath("");
        }
    }
    public BaseResponse(boolean isSuccess) {
        if (isSuccess) {
            this.setStatus(APIConst.SUCCESS);
            this.setMessage("");
            this.setIsShowMessage(false);
        } else {
            this.setStatus(APIConst.ERROR);
            this.setMessage(APIConst.ERROR_MESSAGE);
            this.setIsShowMessage(false);
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
