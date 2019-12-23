package com.alignet.pasarela.crypto;

import java.io.IOException;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSAEngine;

public class I implements Signer {
	private Digest BDWS = (Digest) new SHA1Digest();
	private AsymmetricBlockCipher doFinal = (AsymmetricBlockCipher) new PKCS1Encoding(
			(AsymmetricBlockCipher) new RSAEngine());
	private final AlgorithmIdentifier getDigestSize = new AlgorithmIdentifier(getEncoded, null);
	private static final DERObjectIdentifier getEncoded = new DERObjectIdentifier("1.3.14.3.2.26");

	public final byte[] I() throws CryptoException {
		byte[] arrayOfByte1 = new byte[this.BDWS.getDigestSize()];
		this.BDWS.doFinal(arrayOfByte1, 0);
		try {
			byte[] arrayOfByte2 = BDWS(arrayOfByte1);
			return this.doFinal.processBlock(arrayOfByte2, 0, arrayOfByte2.length);
		} catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
			throw new DataLengthException("key too small for signature type");
		} catch (Exception localException) {
			throw new CryptoException(localException.toString());
		}
	}

	public final void I(boolean paramBoolean, CipherParameters paramCipherParameters) {
		this.BDWS.reset();
		this.doFinal.init(paramBoolean, paramCipherParameters);
	}

	public final void I(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
		this.BDWS.update(paramArrayOfByte, paramInt1, paramInt2);
	}

	public final boolean I(byte[] paramArrayOfByte) {
		byte[] arrayOfByte3, arrayOfByte2, arrayOfByte1 = new byte[this.BDWS.getDigestSize()];
		this.BDWS.doFinal(arrayOfByte1, 0);

		try {
			arrayOfByte2 = this.doFinal.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
			arrayOfByte3 = BDWS(arrayOfByte1);
		} catch (Exception localException) {
			return false;
		}

		if (arrayOfByte2.length == arrayOfByte3.length) {
			for (int i = 0; i < arrayOfByte2.length; i++) {
				if (arrayOfByte2[i] != arrayOfByte3[i])
					return false;
			}
		} else if (arrayOfByte2.length == arrayOfByte3.length - 2) {
			int i = arrayOfByte2.length - arrayOfByte1.length - 2;
			int j = arrayOfByte3.length - arrayOfByte1.length - 2;
			int tmp125_124 = 1;
			byte[] tmp125_122 = arrayOfByte3;
			tmp125_122[tmp125_124] = (byte) (tmp125_122[tmp125_124] - 2);
			int tmp134_133 = 3;
			byte[] tmp134_131 = arrayOfByte3;
			tmp134_131[tmp134_133] = (byte) (tmp134_131[tmp134_133] - 2);
			for (int k = 0; k < arrayOfByte1.length; k++) {
				if (arrayOfByte2[i + k] != arrayOfByte3[j + k])
					return false;
				for (k = 0; k < i; k++) {
					if (arrayOfByte2[k] != arrayOfByte3[k])
						return false;
				}
			}
		} else {
			return false;
		}

		return true;
	}

	private byte[] BDWS(byte[] paramArrayOfByte) throws IOException {
		DigestInfo localDigestInfo = new DigestInfo(this.getDigestSize, paramArrayOfByte);
		return localDigestInfo.getEncoded();
	}

	public byte[] generateSignature() throws CryptoException, DataLengthException {
		return null;
	}

	public void init(boolean arg0, CipherParameters arg1) {
	}

	public void reset() {
	}

	public void update(byte arg0) {
	}

	public void update(byte[] arg0, int arg1, int arg2) {
	}

	public boolean verifySignature(byte[] arg0) {
		return false;
	}
}