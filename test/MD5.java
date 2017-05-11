
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String encryptMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest MD = MessageDigest.getInstance("MD5");
        byte[] messageDigest = MD.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashText = number.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }
        return hashText;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                "http://android.vn/ – hướng dẫn: thanhlong90.it");
        System.out.println(
                "———– Mã hóa 1 chiều với MD5 ———–");
        System.out.println(
                "");
        System.out.println(
                "Dữ liệu mã hóa: chungcoi");
        String avc = encryptMD5("1");
        System.out.println(
                "Kết quả đã mã hóa " + avc + "     \\ | /    " + avc.length());
    }

}
