package com.example.movieBE.dto;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Template for Controller return type
 */
public class ResponseTemplate extends BaseResponse {

    /**
     * Data
     */
    private Map<String, Object> data = new HashedMap<>();

    /**
     * fieldErrors
     */
    private Map<String, String> fieldErrors = new HashedMap<>();

    /**
     * Default constructor
     */
    public ResponseTemplate() {
        super();
    }

    /**
     * Call this when init response with status
     * @param result is "success"(true) or "error"(false)
     */
    public ResponseTemplate(boolean result) {
        super(result);
    }

    /**
     * Set data as whole HashMap
     * @param data HashMap<String, Object>
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * set data as key - value
     * @param key String
     * @param value Object
     */
    public void setData(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key, value);
    }

    /**
     * get Data as whole HashMap
     * @return HashMap<String, Object>
     * @author ThienPG
     */
    public Map<String, Object> getData() {
        return this.data;
    }

    /**
     * get Data by key
     * @param key String
     * @return Object
     * @author ThienPG
     */
    public Object getData(String key) {
        return MapUtils.getObject(data, key, new Object());
    }

    /**
     * replace current fieldErrors with a new fieldErrors
     * @param fieldErrors Map<String, String>
     */
    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    /**
     * Set fieldErrors as key & value
     * @param key String
     * @param value String
     */
    public void setFieldErrors(String key, String value) {
        if (fieldErrors == null) {
            fieldErrors = new HashMap<>();
        }
        fieldErrors.put(key, value);
    }

    /**
     * Get field error by key
     * @param key
     * @return
     */
    public Object getFieldErrors(String key) {
        if (fieldErrors == null) {
            return "";
        }
        return fieldErrors.get(key);
    }

    /**
     * Get whole fieldError
     * @return Object
     */
    public Object getFieldErrors() {
        return this.fieldErrors;
    }
}
