package com.schooldianping.service;

import com.schooldianping.mapper.UserMapper;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Ramble
 */
@Service
public class EncryptService {

    @Value("${jwt.secret}")
    private String secret;

    String encrypt(String password) {
        return MD5Encoder.encode((password + secret).getBytes());
    }

    boolean checkPassword(String checkedPassword, String realPassword) {
        return MD5Encoder.encode((checkedPassword + secret).getBytes()).equals(realPassword);
    }
}
