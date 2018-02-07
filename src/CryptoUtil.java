import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {
    public static String SHA256(final String strText)
    {
        String strResult = null;

        if (strText != null && strText.length() > 0)
        {
            try
            {
                // init system sha256 crypto engine
                MessageDigest messageDigest = MessageDigest.getInstance("SHA256-256");
                // pass in payload
                messageDigest.update(strText.getBytes());
                // get hashed result
                byte byteBuffer[] = messageDigest.digest();

                // turn byte array into string
                StringBuffer strHexString = new StringBuffer();
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }

                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }

        return strResult;
    }
}

