package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class CryptoOptions {
    private final SFrame sframe;
    private final Srtp srtp;

    private CryptoOptions(boolean z8, boolean z9, boolean z10, boolean z11) {
        this.srtp = new Srtp(this, z8, z9, z10, 0);
        this.sframe = new SFrame(this, z11, 0);
    }

    public static Builder builder() {
        return new Builder(0);
    }

    @CalledByNative
    public SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public Srtp getSrtp() {
        return this.srtp;
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Builder {
        private boolean enableAes128Sha1_32CryptoCipher;
        private boolean enableEncryptedRtpHeaderExtensions;
        private boolean enableGcmCryptoSuites;
        private boolean requireFrameEncryption;

        public /* synthetic */ Builder(int i9) {
            this();
        }

        public CryptoOptions createCryptoOptions() {
            return new CryptoOptions(0, this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption);
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z8) {
            this.enableAes128Sha1_32CryptoCipher = z8;
            return this;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z8) {
            this.enableEncryptedRtpHeaderExtensions = z8;
            return this;
        }

        public Builder setEnableGcmCryptoSuites(boolean z8) {
            this.enableGcmCryptoSuites = z8;
            return this;
        }

        public Builder setRequireFrameEncryption(boolean z8) {
            this.requireFrameEncryption = z8;
            return this;
        }

        private Builder() {
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public final class SFrame {
        private final boolean requireFrameEncryption;

        private SFrame(CryptoOptions cryptoOptions, boolean z8) {
            this.requireFrameEncryption = z8;
        }

        @CalledByNative("SFrame")
        public boolean getRequireFrameEncryption() {
            return this.requireFrameEncryption;
        }

        public /* synthetic */ SFrame(CryptoOptions cryptoOptions, boolean z8, int i9) {
            this(cryptoOptions, z8);
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public final class Srtp {
        private final boolean enableAes128Sha1_32CryptoCipher;
        private final boolean enableEncryptedRtpHeaderExtensions;
        private final boolean enableGcmCryptoSuites;

        private Srtp(CryptoOptions cryptoOptions, boolean z8, boolean z9, boolean z10) {
            this.enableGcmCryptoSuites = z8;
            this.enableAes128Sha1_32CryptoCipher = z9;
            this.enableEncryptedRtpHeaderExtensions = z10;
        }

        @CalledByNative("Srtp")
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            return this.enableAes128Sha1_32CryptoCipher;
        }

        @CalledByNative("Srtp")
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            return this.enableEncryptedRtpHeaderExtensions;
        }

        @CalledByNative("Srtp")
        public boolean getEnableGcmCryptoSuites() {
            return this.enableGcmCryptoSuites;
        }

        public /* synthetic */ Srtp(CryptoOptions cryptoOptions, boolean z8, boolean z9, boolean z10, int i9) {
            this(cryptoOptions, z8, z9, z10);
        }
    }

    public /* synthetic */ CryptoOptions(int i9, boolean z8, boolean z9, boolean z10, boolean z11) {
        this(z8, z9, z10, z11);
    }
}
