package com.medpiper.doc.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utils
{
    // Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
    private static int workload = 12;

    public static boolean isNullOrEpty( final String s )
    {
        return s == null || s.trim().isEmpty();
    }

    public static String encryptPassword(String password)
    {

        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password, salt);
        return(hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash)
    {
        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
         return false;
        return(BCrypt.checkpw(password_plaintext, stored_hash));
    }

    public static String getRandomHash()
    {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            random.append(SALTCHARS.charAt(index));
        }
        String randomStr = random.toString();
        return generateMd5(randomStr);

    }

    public static String generateMd5(String input)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateOTP() {


        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }

    public static Date getOtpExpiryTime() {

            long fifteenMinFromNow = System.currentTimeMillis()+(3 * 60 * 1000);
        return new Date(fifteenMinFromNow);
    }

    public static ControllerResponse<String> getExceptionReturnResponse(Exception e) {

        ControllerResponse<String> controllerResponse = new ControllerResponse<String>();
        controllerResponse.setData(e.getMessage());
        controllerResponse.setErrorMessage(e.getLocalizedMessage());
        controllerResponse.setSuccess(false);
        return controllerResponse;
    }

    public static <T> ControllerResponse<List<T>> getControllerResponseAsList(List<T> collection){

        ControllerResponse<List<T>> controllerResponse = new ControllerResponse<List<T>>();
        controllerResponse.setSuccess(true);
        controllerResponse.setData(collection);
        controllerResponse.setSuccess(true);

        return controllerResponse;
    }
}
