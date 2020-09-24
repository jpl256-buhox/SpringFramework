// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Crypt.java

package mx.com.cfe.cfecontigo.auth.server.support;

import java.io.IOException;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypt
{


    public Crypt(String password)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance(DIGEST);
            _password = new SecretKeySpec(digest.digest(password.getBytes()), ALGORITHM);
            _cipher = Cipher.getInstance(TRANSFORMATION);
            _IVParamSpec = new IvParameterSpec(IV);
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println((new StringBuilder("No such algorithm ")).append(ALGORITHM).append(" ").append(e).toString());
        }
        catch(NoSuchPaddingException e)
        {
            System.out.println((new StringBuilder("No such padding PKCS7 ")).append(e).toString());
        }
    }

    public String encrypt(byte text[])
    {
        byte encryptedData[];
        try
        {
            _cipher.init(1, _password, _IVParamSpec);
            encryptedData = _cipher.doFinal(text);
        }
        catch(InvalidKeyException e)
        {
            System.out.println((new StringBuilder("Invalid key  (invalid encoding, wrong length, uninitialized, etc). ")).append(e).toString());
            return null;
        }
        catch(InvalidAlgorithmParameterException e)
        {
            System.out.println((new StringBuilder("Invalid or inappropriate algorithm parameters for ")).append(ALGORITHM).append(" ").append(e).toString());
            return null;
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println((new StringBuilder("The length of data provided to a block cipher is incorrect ")).append(e).toString());
            return null;
        }
        catch(BadPaddingException e)
        {
            System.out.println((new StringBuilder("The input data but the data is not padded properly. ")).append(e).toString());
            return null;
        }
        return Base64.encodeBytes(encryptedData);
    }

    public String decrypt(String text)
    {
        try
        {
            _cipher.init(2, _password, _IVParamSpec);
            byte decodedValue[] = Base64.decode(text);
            byte decryptedVal[] = _cipher.doFinal(decodedValue);
            return new String(decryptedVal);
        }
        catch(InvalidKeyException e)
        {
            System.out.println((new StringBuilder("Invalid key  (invalid encoding, wrong length, uninitialized, etc). ")).append(e).toString());
            return null;
        }
        catch(InvalidAlgorithmParameterException e)
        {
            System.out.println((new StringBuilder("Invalid or inappropriate algorithm parameters for ")).append(ALGORITHM).append(" ").append(e).toString());
            return null;
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println((new StringBuilder("The length of data provided to a block cipher is incorrect ")).append(e).toString());
            return null;
        }
        catch(BadPaddingException e)
        {
            System.out.println((new StringBuilder("The input data but the data is not padded properly. ")).append(e).toString());
            return null;
        }
        catch(IOException e)
        {
            System.out.println((new StringBuilder("IOException ")).append(e).toString());
        }
        return null;
    }

    public static final String TAG = "ldapWebBroker";
    private static String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static String ALGORITHM = "AES";
    private static String DIGEST = "MD5";
    private static Cipher _cipher;
    private static SecretKey _password;
    private static IvParameterSpec _IVParamSpec;
    private static byte IV[] = "BrokerCryptedAes".getBytes();

}
