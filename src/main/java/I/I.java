package I;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.encoders.Base64;



public class I
  extends BufferedReader
{
  public I(Reader paramReader) { super(paramReader); }

  
  public final AsymmetricKeyParameter I() throws IOException {
    String str;
    while ((str = readLine()) != null) {
      if (str.indexOf("-----BEGIN RSA PUBLIC KEY") != -1) {
        return append("-----END RSA PUBLIC KEY");
      }
      if (str.indexOf("-----BEGIN RSA PRIVATE KEY") != -1)
        try {
          return decode("RSA", "-----END RSA PRIVATE KEY");
        } catch (Exception localException1) {
          throw new IOException("problem creating RSA private key: " + localException1.toString());
        }  
      if (str.indexOf("-----BEGIN DSA PRIVATE KEY") == -1)
        continue; 
      try {
        return decode("DSA", "-----END DSA PRIVATE KEY");
      } catch (Exception localException2) {
        throw new IOException("problem creating DSA private key: " + localException2.toString());
      } 
    } 
    return null;
  }
  
  private byte[] BDWS(String paramString) throws IOException {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    while ((str = readLine()) != null && 
      str.indexOf(paramString) == -1)
    {
      localStringBuffer.append(str.trim());
    }
    if (str == null)
      throw new IOException(String.valueOf(paramString) + " not found"); 
    return Base64.decode(localStringBuffer.toString());
  }
  
  private AsymmetricKeyParameter append(String paramString) throws IOException {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(BDWS(paramString));
    ASN1InputStream localASN1InputStream = new ASN1InputStream(localByteArrayInputStream);
    DERObject localDERObject = localASN1InputStream.readObject();
    ASN1Sequence localASN1Sequence = (ASN1Sequence)localDERObject;
    RSAPublicKeyStructure localRSAPublicKeyStructure = new RSAPublicKeyStructure(localASN1Sequence);
    RSAKeyParameters localRSAKeyParameters = new RSAKeyParameters(false, localRSAPublicKeyStructure.getModulus(), localRSAPublicKeyStructure.getPublicExponent());
    return (AsymmetricKeyParameter)localRSAKeyParameters;
  }
  
  private AsymmetricKeyParameter decode(String paramString1, String paramString2) throws IOException {
    int i = 0;
    String str1 = null;
    String str2 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    while ((str1 = readLine()) != null) {
      if (str1.startsWith("Proc-Type: 4,ENCRYPTED")) {
        i = 1; continue;
      }  if (str1.startsWith("DEK-Info:")) {
        str2 = str1.substring(10); continue;
      } 
      if (str1.indexOf(paramString2) != -1)
        break; 
      localStringBuffer.append(str1.trim());
    } 
    byte[] arrayOfByte = (byte[])null;
    if (i != 0)
      throw new IOException("unknown encryption with private key"); 
    arrayOfByte = Base64.decode(localStringBuffer.toString());
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    ASN1InputStream localASN1InputStream = new ASN1InputStream(localByteArrayInputStream);
    ASN1Sequence localASN1Sequence = (ASN1Sequence)localASN1InputStream.readObject();
    if (paramString1.equals("RSA")) {
      DERInteger localDERInteger1 = (DERInteger)localASN1Sequence.getObjectAt(1);
      DERInteger localDERInteger2 = (DERInteger)localASN1Sequence.getObjectAt(2);
      DERInteger localDERInteger3 = (DERInteger)localASN1Sequence.getObjectAt(3);
      DERInteger localDERInteger4 = (DERInteger)localASN1Sequence.getObjectAt(4);
      DERInteger localDERInteger8 = (DERInteger)localASN1Sequence.getObjectAt(5);
      DERInteger localDERInteger5 = (DERInteger)localASN1Sequence.getObjectAt(6);
      DERInteger localDERInteger6 = (DERInteger)localASN1Sequence.getObjectAt(7);
      DERInteger localDERInteger7 = (DERInteger)localASN1Sequence.getObjectAt(8);
      RSAPrivateCrtKeyParameters localRSAPrivateCrtKeyParameters = new RSAPrivateCrtKeyParameters(localDERInteger1.getValue(), localDERInteger2.getValue(), localDERInteger3.getValue(), localDERInteger4.getValue(), localDERInteger8.getValue(), localDERInteger5.getValue(), localDERInteger6.getValue(), localDERInteger7.getValue());
      return (AsymmetricKeyParameter)localRSAPrivateCrtKeyParameters;
    } 
    DERInteger localDERInteger1 = (DERInteger)localASN1Sequence.getObjectAt(1);
    DERInteger localDERInteger2 = (DERInteger)localASN1Sequence.getObjectAt(2);
    DERInteger localDERInteger3 = (DERInteger)localASN1Sequence.getObjectAt(3);
    DERInteger localDERInteger4 = (DERInteger)localASN1Sequence.getObjectAt(5);
    Object localObject = new DSAPrivateKeyParameters(localDERInteger4.getValue(), new DSAParameters(localDERInteger1.getValue(), localDERInteger2.getValue(), localDERInteger3.getValue()));
    return (AsymmetricKeyParameter)localObject;
  }
}
