package com.alignet.pasarela.crypto;

import java.io.IOException;
import java.security.SecureRandom;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptoUtil {

	private static final Logger logger = LoggerFactory.getLogger(CryptoUtil.class);

	
	private CryptoUtil() {
	}
	
	public static final byte[] I() {
		byte[] arrayOfByte = new byte[16];
		SecureRandom localSecureRandom = new SecureRandom();
		localSecureRandom.nextBytes(arrayOfByte);
		return arrayOfByte;
	}

	public static final byte[] I(byte[] paramArrayOfByte, AsymmetricKeyParameter paramAsymmetricKeyParameter) {
		RSAKeyParameters localRSAKeyParameters = null;
		if (paramAsymmetricKeyParameter instanceof RSAKeyParameters) {
			localRSAKeyParameters = (RSAKeyParameters) paramAsymmetricKeyParameter;
		} else {
			throw new IllegalArgumentException("La llave no pertenece al tipo RSA");
		}
		PKCS1Encoding localPKCS1Encoding = new PKCS1Encoding((AsymmetricBlockCipher) new RSAEngine());
		localPKCS1Encoding.init(true, (CipherParameters) localRSAKeyParameters);
		byte[] arrayOfByte = (byte[]) null;
		try {
			arrayOfByte = localPKCS1Encoding.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
		} catch (InvalidCipherTextException localInvalidCipherTextException) {
			logger.error("Error al cifrar asimetricamente", (Throwable) localInvalidCipherTextException);
		}
		return arrayOfByte;
	}

	public static final byte[] Z(byte[] paramArrayOfByte, AsymmetricKeyParameter paramAsymmetricKeyParameter)
			throws InvalidCipherTextException {
		if (paramAsymmetricKeyParameter instanceof org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters) {
			if (!paramAsymmetricKeyParameter.isPrivate()) {
				throw new IllegalArgumentException("La llave debe ser privada");
			}
		} else {
			throw new IllegalArgumentException("La llave no pertenece al tipo RSA");
		}
		PKCS1Encoding localPKCS1Encoding = new PKCS1Encoding((AsymmetricBlockCipher) new RSAEngine());
		localPKCS1Encoding.init(false, (CipherParameters) paramAsymmetricKeyParameter);
		byte[] arrayOfByte = (byte[]) null;
		arrayOfByte = localPKCS1Encoding.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
		return arrayOfByte;
	}

	public static final byte[] I(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
			throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		byte[] arrayOfByte1 = (byte[]) null;
		if (paramArrayOfByte2.length != 24) {
			if (paramArrayOfByte2.length == 16) {
				arrayOfByte1 = new byte[24];
				for (int i = 0; i < paramArrayOfByte2.length; i++) {
					arrayOfByte1[i] = paramArrayOfByte2[i];
				}
				for (int i = 0; i < 8; i++) {
					arrayOfByte1[i + 16] = paramArrayOfByte2[i];
				}
			}
		} else {
			arrayOfByte1 = paramArrayOfByte2;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("LLAVE: " + (new String(Hex.encode(paramArrayOfByte2))).toUpperCase());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("VI: " + (new String(Hex.encode(paramArrayOfByte3))).toUpperCase());
		}
		CBCBlockCipher localCBCBlockCipher = new CBCBlockCipher((BlockCipher) new DESedeEngine());
		PaddedBufferedBlockCipher localPaddedBufferedBlockCipher = new PaddedBufferedBlockCipher(
				(BlockCipher) localCBCBlockCipher);
		localPaddedBufferedBlockCipher
				.init(true,
						(CipherParameters) new ParametersWithRandom(
								(CipherParameters) new ParametersWithIV(
										(CipherParameters) new KeyParameter(arrayOfByte1), paramArrayOfByte3),
								new SecureRandom()));
		localPaddedBufferedBlockCipher.reset();
		int j = localPaddedBufferedBlockCipher.getOutputSize(paramArrayOfByte1.length);
		byte[] arrayOfByte2 = new byte[j];
		int k = localPaddedBufferedBlockCipher.processBytes(paramArrayOfByte1, 0, paramArrayOfByte1.length,
				arrayOfByte2, 0);
		k += localPaddedBufferedBlockCipher.doFinal(arrayOfByte2, k);
		byte[] arrayOfByte3 = new byte[k];
		System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, k);
		return arrayOfByte3;
	}

	public static final byte[] Z(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
			throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		byte[] arrayOfByte1 = (byte[]) null;
		if (paramArrayOfByte2.length != 24) {
			if (paramArrayOfByte2.length == 16) {
				arrayOfByte1 = new byte[24];
				for (int i = 0; i < paramArrayOfByte2.length; i++)
					arrayOfByte1[i] = paramArrayOfByte2[i];
				for (int i = 0; i < 8; i++) {
					arrayOfByte1[i + 16] = paramArrayOfByte2[i];
				}
			}
		} else {
			arrayOfByte1 = paramArrayOfByte2;
		}
		CBCBlockCipher localCBCBlockCipher = new CBCBlockCipher((BlockCipher) new DESedeEngine());
		PaddedBufferedBlockCipher localPaddedBufferedBlockCipher = new PaddedBufferedBlockCipher(
				(BlockCipher) localCBCBlockCipher);
		localPaddedBufferedBlockCipher
				.init(false,
						(CipherParameters) new ParametersWithRandom(
								(CipherParameters) new ParametersWithIV(
										(CipherParameters) new KeyParameter(arrayOfByte1), paramArrayOfByte3),
								new SecureRandom()));
		localPaddedBufferedBlockCipher.reset();
		int j = localPaddedBufferedBlockCipher.getOutputSize(paramArrayOfByte1.length);
		byte[] arrayOfByte2 = new byte[j];
		int k = localPaddedBufferedBlockCipher.processBytes(paramArrayOfByte1, 0, paramArrayOfByte1.length,
				arrayOfByte2, 0);
		k += localPaddedBufferedBlockCipher.doFinal(arrayOfByte2, k);
		byte[] arrayOfByte3 = new byte[k];
		System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, k);
		return arrayOfByte3;
	}

	public static final boolean I(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2,
			AsymmetricKeyParameter paramAsymmetricKeyParameter) {
		boolean bool = false;
		I localI = new I();
		localI.I(false, (CipherParameters) paramAsymmetricKeyParameter);
		localI.I(paramArrayOfByte1, 0, paramArrayOfByte1.length);
		bool = localI.I(paramArrayOfByte2);
		return bool;
	}

	public static final byte[] C(byte[] paramArrayOfByte, AsymmetricKeyParameter paramAsymmetricKeyParameter)
			throws IOException, CryptoException {
		byte[] arrayOfByte = (byte[]) null;
		I localI = new I();
		localI.I(true, (CipherParameters) paramAsymmetricKeyParameter);
		localI.I(paramArrayOfByte, 0, paramArrayOfByte.length);
		arrayOfByte = localI.I();
		return arrayOfByte;
	}
}
