package BookManageSystem.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;

public class CipherUtil {
    private static final SecretKeySpec key;
    private static final IvParameterSpec iv;
    private static final String algorithm = "AES/CBC/PKCS5Padding";

    static {
        // 添加BouncyCastle作为安全提供者
        Security.addProvider(new BouncyCastleProvider());

        String keyString = "1234567890123456";  // 密钥
        String ivString = "abcdefghijklmnop";   // 向量
        key = new SecretKeySpec(keyString.getBytes(), "AES");
        iv = new IvParameterSpec(ivString.getBytes());
    }

    // AES加密
    public static String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    // AES解密
    public static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }

    public static String hashSHA256(String input) throws Exception {
        // 使用 BouncyCastle 提供的 SHA-256 算法
        MessageDigest digest = MessageDigest.getInstance("SHA-256", "BC");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // 将字节数组转换为十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
