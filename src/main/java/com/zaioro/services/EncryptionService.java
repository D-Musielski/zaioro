package com.zaioro.services;

/**
 * Created by Val on 2017-05-15.
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
