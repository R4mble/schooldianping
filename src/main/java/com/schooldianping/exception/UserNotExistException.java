package com.schooldianping.exception;

/**
 * @author Ramble
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("该用户不存在");
    }
}
