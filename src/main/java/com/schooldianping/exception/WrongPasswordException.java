package com.schooldianping.exception;

/**
 * @author Ramble
 */
public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super("用户名或密码错误");
    }
}
