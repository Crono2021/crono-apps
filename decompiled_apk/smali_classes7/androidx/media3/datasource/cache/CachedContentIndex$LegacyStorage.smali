.class Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;
.super Ljava/lang/Object;
.source "CachedContentIndex.java"

# interfaces
.implements Landroidx/media3/datasource/cache/CachedContentIndex$Storage;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/datasource/cache/CachedContentIndex;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LegacyStorage"
.end annotation


# static fields
.field private static final FLAG_ENCRYPTED_INDEX:I = 0x1

.field private static final VERSION:I = 0x2

.field private static final VERSION_METADATA_INTRODUCED:I = 0x2


# instance fields
.field private final atomicFile:Landroidx/media3/common/util/AtomicFile;

.field private bufferedOutputStream:Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;

.field private changed:Z

.field private final cipher:Ljavax/crypto/Cipher;

.field private final encrypt:Z

.field private final random:Ljava/security/SecureRandom;

.field private final secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;


# direct methods
.method public constructor <init>(Ljava/io/File;[BZ)V
    .locals 6
    .param p1, "file"    # Ljava/io/File;
    .param p2, "secretKey"    # [B
    .param p3, "encrypt"    # Z

    .line 522
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 523
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-nez p2, :cond_1

    if-nez p3, :cond_0

    goto :goto_0

    :cond_0
    move v2, v0

    goto :goto_1

    :cond_1
    :goto_0
    move v2, v1

    :goto_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 524
    const/4 v2, 0x0

    .line 525
    .local v2, "cipher":Ljavax/crypto/Cipher;
    const/4 v3, 0x0

    .line 526
    .local v3, "secretKeySpec":Ljavax/crypto/spec/SecretKeySpec;
    if-eqz p2, :cond_3

    .line 527
    array-length v4, p2

    const/16 v5, 0x10

    if-ne v4, v5, :cond_2

    move v0, v1

    :cond_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 529
    :try_start_0
    invoke-static {}, Landroidx/media3/datasource/cache/CachedContentIndex;->access$000()Ljavax/crypto/Cipher;

    move-result-object v0

    move-object v2, v0

    .line 530
    new-instance v0, Ljavax/crypto/spec/SecretKeySpec;

    const-string v1, "AES"

    invoke-direct {v0, p2, v1}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v3, v0

    .line 533
    goto :goto_3

    .line 531
    :catch_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    .line 532
    .local v0, "e":Ljava/security/GeneralSecurityException;
    :goto_2
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 535
    .end local v0    # "e":Ljava/security/GeneralSecurityException;
    :cond_3
    xor-int/lit8 v0, p3, 0x1

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 537
    :goto_3
    iput-boolean p3, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->encrypt:Z

    .line 538
    iput-object v2, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;

    .line 539
    iput-object v3, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    .line 540
    if-eqz p3, :cond_4

    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    goto :goto_4

    :cond_4
    const/4 v0, 0x0

    :goto_4
    iput-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->random:Ljava/security/SecureRandom;

    .line 541
    new-instance v0, Landroidx/media3/common/util/AtomicFile;

    invoke-direct {v0, p1}, Landroidx/media3/common/util/AtomicFile;-><init>(Ljava/io/File;)V

    iput-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    .line 542
    return-void
.end method

.method private hashCachedContent(Landroidx/media3/datasource/cache/CachedContent;I)I
    .locals 6
    .param p1, "cachedContent"    # Landroidx/media3/datasource/cache/CachedContent;
    .param p2, "version"    # I

    .line 702
    iget v0, p1, Landroidx/media3/datasource/cache/CachedContent;->id:I

    .line 703
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p1, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 704
    .end local v0    # "result":I
    .local v1, "result":I
    const/4 v0, 0x2

    if-ge p2, v0, :cond_0

    .line 705
    invoke-virtual {p1}, Landroidx/media3/datasource/cache/CachedContent;->getMetadata()Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/datasource/cache/ContentMetadata;->getContentLength(Landroidx/media3/datasource/cache/ContentMetadata;)J

    move-result-wide v2

    .line 706
    .local v2, "length":J
    mul-int/lit8 v0, v1, 0x1f

    const/16 v4, 0x20

    ushr-long v4, v2, v4

    xor-long/2addr v4, v2

    long-to-int v4, v4

    add-int/2addr v0, v4

    .line 707
    .end local v1    # "result":I
    .end local v2    # "length":J
    .restart local v0    # "result":I
    goto :goto_0

    .line 708
    .end local v0    # "result":I
    .restart local v1    # "result":I
    :cond_0
    mul-int/lit8 v0, v1, 0x1f

    invoke-virtual {p1}, Landroidx/media3/datasource/cache/CachedContent;->getMetadata()Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/datasource/cache/DefaultContentMetadata;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    .line 710
    .end local v1    # "result":I
    .restart local v0    # "result":I
    :goto_0
    return v0
.end method

.method private readCachedContent(ILjava/io/DataInputStream;)Landroidx/media3/datasource/cache/CachedContent;
    .locals 6
    .param p1, "version"    # I
    .param p2, "input"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 721
    invoke-virtual {p2}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    .line 722
    .local v0, "id":I
    invoke-virtual {p2}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v1

    .line 724
    .local v1, "key":Ljava/lang/String;
    const/4 v2, 0x2

    if-ge p1, v2, :cond_0

    .line 725
    invoke-virtual {p2}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v2

    .line 726
    .local v2, "length":J
    new-instance v4, Landroidx/media3/datasource/cache/ContentMetadataMutations;

    invoke-direct {v4}, Landroidx/media3/datasource/cache/ContentMetadataMutations;-><init>()V

    .line 727
    .local v4, "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    invoke-static {v4, v2, v3}, Landroidx/media3/datasource/cache/ContentMetadataMutations;->setContentLength(Landroidx/media3/datasource/cache/ContentMetadataMutations;J)Landroidx/media3/datasource/cache/ContentMetadataMutations;

    .line 728
    sget-object v5, Landroidx/media3/datasource/cache/DefaultContentMetadata;->EMPTY:Landroidx/media3/datasource/cache/DefaultContentMetadata;

    invoke-virtual {v5, v4}, Landroidx/media3/datasource/cache/DefaultContentMetadata;->copyWithMutationsApplied(Landroidx/media3/datasource/cache/ContentMetadataMutations;)Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v2

    .line 729
    .end local v4    # "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    .local v2, "metadata":Landroidx/media3/datasource/cache/DefaultContentMetadata;
    goto :goto_0

    .line 730
    .end local v2    # "metadata":Landroidx/media3/datasource/cache/DefaultContentMetadata;
    :cond_0
    invoke-static {p2}, Landroidx/media3/datasource/cache/CachedContentIndex;->access$100(Ljava/io/DataInputStream;)Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v2

    .line 732
    .restart local v2    # "metadata":Landroidx/media3/datasource/cache/DefaultContentMetadata;
    :goto_0
    new-instance v3, Landroidx/media3/datasource/cache/CachedContent;

    invoke-direct {v3, v0, v1, v2}, Landroidx/media3/datasource/cache/CachedContent;-><init>(ILjava/lang/String;Landroidx/media3/datasource/cache/DefaultContentMetadata;)V

    return-object v3
.end method

.method private readFile(Ljava/util/HashMap;Landroid/util/SparseArray;)Z
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CachedContent;",
            ">;",
            "Landroid/util/SparseArray<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .line 596
    .local p1, "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    .local p2, "idToKey":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Ljava/lang/String;>;"
    iget-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v0}, Landroidx/media3/common/util/AtomicFile;->exists()Z

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 597
    return v1

    .line 600
    :cond_0
    const/4 v0, 0x0

    .line 602
    .local v0, "input":Ljava/io/DataInputStream;
    const/4 v2, 0x0

    :try_start_0
    new-instance v3, Ljava/io/BufferedInputStream;

    iget-object v4, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v4}, Landroidx/media3/common/util/AtomicFile;->openRead()Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 603
    .local v3, "inputStream":Ljava/io/InputStream;
    new-instance v4, Ljava/io/DataInputStream;

    invoke-direct {v4, v3}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    move-object v0, v4

    .line 604
    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v4

    .line 605
    .local v4, "version":I
    if-ltz v4, :cond_9

    const/4 v5, 0x2

    if-le v4, v5, :cond_1

    goto/16 :goto_5

    .line 609
    :cond_1
    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v6

    .line 610
    .local v6, "flags":I
    and-int/lit8 v7, v6, 0x1

    if-eqz v7, :cond_4

    .line 611
    iget-object v7, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v7, :cond_2

    .line 612
    nop

    .line 643
    nop

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 612
    return v2

    .line 614
    :cond_2
    const/16 v7, 0x10

    :try_start_1
    new-array v7, v7, [B

    .line 615
    .local v7, "initializationVector":[B
    invoke-virtual {v0, v7}, Ljava/io/DataInputStream;->readFully([B)V

    .line 616
    new-instance v8, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v8, v7}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 618
    .local v8, "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    :try_start_2
    iget-object v9, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;

    iget-object v10, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    invoke-static {v10}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/security/Key;

    invoke-virtual {v9, v5, v10, v8}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    :try_end_2
    .catch Ljava/security/InvalidKeyException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/security/InvalidAlgorithmParameterException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 621
    nop

    .line 622
    :try_start_3
    new-instance v5, Ljava/io/DataInputStream;

    new-instance v9, Ljavax/crypto/CipherInputStream;

    iget-object v10, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;

    invoke-direct {v9, v3, v10}, Ljavax/crypto/CipherInputStream;-><init>(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V

    invoke-direct {v5, v9}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    move-object v0, v5

    .line 623
    .end local v7    # "initializationVector":[B
    .end local v8    # "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    :cond_3
    goto :goto_1

    .line 619
    .restart local v7    # "initializationVector":[B
    .restart local v8    # "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    :catch_0
    move-exception v1

    goto :goto_0

    :catch_1
    move-exception v1

    .line 620
    .local v1, "e":Ljava/security/GeneralSecurityException;
    :goto_0
    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    .end local v0    # "input":Ljava/io/DataInputStream;
    .end local p1    # "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    .end local p2    # "idToKey":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Ljava/lang/String;>;"
    throw v5

    .line 623
    .end local v1    # "e":Ljava/security/GeneralSecurityException;
    .end local v7    # "initializationVector":[B
    .end local v8    # "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    .restart local v0    # "input":Ljava/io/DataInputStream;
    .restart local p1    # "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    .restart local p2    # "idToKey":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Ljava/lang/String;>;"
    :cond_4
    iget-boolean v5, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->encrypt:Z

    if-eqz v5, :cond_3

    .line 624
    iput-boolean v1, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    .line 627
    :goto_1
    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v5

    .line 628
    .local v5, "count":I
    const/4 v7, 0x0

    .line 629
    .local v7, "hashCode":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_2
    if-ge v8, v5, :cond_5

    .line 630
    invoke-direct {p0, v4, v0}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->readCachedContent(ILjava/io/DataInputStream;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v9

    .line 631
    .local v9, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    iget-object v10, v9, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {p1, v10, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 632
    iget v10, v9, Landroidx/media3/datasource/cache/CachedContent;->id:I

    iget-object v11, v9, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {p2, v10, v11}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 633
    invoke-direct {p0, v9, v4}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->hashCachedContent(Landroidx/media3/datasource/cache/CachedContent;I)I

    move-result v10

    add-int/2addr v7, v10

    .line 629
    .end local v9    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 635
    .end local v8    # "i":I
    :cond_5
    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v8

    .line 636
    .local v8, "fileHashCode":I
    invoke-virtual {v0}, Ljava/io/DataInputStream;->read()I

    move-result v9
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    const/4 v10, -0x1

    if-ne v9, v10, :cond_6

    move v9, v1

    goto :goto_3

    :cond_6
    move v9, v2

    .line 637
    .local v9, "isEOF":Z
    :goto_3
    if-ne v8, v7, :cond_8

    if-nez v9, :cond_7

    goto :goto_4

    .line 643
    .end local v3    # "inputStream":Ljava/io/InputStream;
    .end local v4    # "version":I
    .end local v5    # "count":I
    .end local v6    # "flags":I
    .end local v7    # "hashCode":I
    .end local v8    # "fileHashCode":I
    .end local v9    # "isEOF":Z
    :cond_7
    nop

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 647
    return v1

    .line 638
    .restart local v3    # "inputStream":Ljava/io/InputStream;
    .restart local v4    # "version":I
    .restart local v5    # "count":I
    .restart local v6    # "flags":I
    .restart local v7    # "hashCode":I
    .restart local v8    # "fileHashCode":I
    .restart local v9    # "isEOF":Z
    :cond_8
    :goto_4
    nop

    .line 643
    nop

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 638
    return v2

    .line 606
    .end local v5    # "count":I
    .end local v6    # "flags":I
    .end local v7    # "hashCode":I
    .end local v8    # "fileHashCode":I
    .end local v9    # "isEOF":Z
    :cond_9
    :goto_5
    nop

    .line 643
    nop

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 606
    return v2

    .line 643
    .end local v3    # "inputStream":Ljava/io/InputStream;
    .end local v4    # "version":I
    :catchall_0
    move-exception v1

    if-eqz v0, :cond_a

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 646
    :cond_a
    throw v1

    .line 640
    :catch_2
    move-exception v1

    .line 641
    .local v1, "e":Ljava/io/IOException;
    nop

    .line 643
    if-eqz v0, :cond_b

    .line 644
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 641
    :cond_b
    return v2
.end method

.method private writeCachedContent(Landroidx/media3/datasource/cache/CachedContent;Ljava/io/DataOutputStream;)V
    .locals 1
    .param p1, "cachedContent"    # Landroidx/media3/datasource/cache/CachedContent;
    .param p2, "output"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 743
    iget v0, p1, Landroidx/media3/datasource/cache/CachedContent;->id:I

    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 744
    iget-object v0, p1, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 745
    invoke-virtual {p1}, Landroidx/media3/datasource/cache/CachedContent;->getMetadata()Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v0

    invoke-static {v0, p2}, Landroidx/media3/datasource/cache/CachedContentIndex;->access$200(Landroidx/media3/datasource/cache/DefaultContentMetadata;Ljava/io/DataOutputStream;)V

    .line 746
    return-void
.end method

.method private writeFile(Ljava/util/HashMap;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CachedContent;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 651
    .local p1, "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    const/4 v0, 0x0

    .line 653
    .local v0, "output":Ljava/io/DataOutputStream;
    :try_start_0
    iget-object v1, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v1}, Landroidx/media3/common/util/AtomicFile;->startWrite()Ljava/io/OutputStream;

    move-result-object v1

    .line 654
    .local v1, "outputStream":Ljava/io/OutputStream;
    iget-object v2, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->bufferedOutputStream:Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;

    if-nez v2, :cond_0

    .line 655
    new-instance v2, Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;

    invoke-direct {v2, v1}, Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v2, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->bufferedOutputStream:Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;

    goto :goto_0

    .line 657
    :cond_0
    invoke-virtual {v2, v1}, Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;->reset(Ljava/io/OutputStream;)V

    .line 659
    :goto_0
    iget-object v2, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->bufferedOutputStream:Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;

    .line 660
    .local v2, "bufferedOutputStream":Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;
    new-instance v3, Ljava/io/DataOutputStream;

    invoke-direct {v3, v2}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    move-object v0, v3

    .line 661
    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 663
    iget-boolean v4, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->encrypt:Z

    const/4 v5, 0x1

    if-eqz v4, :cond_1

    move v4, v5

    goto :goto_1

    :cond_1
    const/4 v4, 0x0

    .line 664
    .local v4, "flags":I
    :goto_1
    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 666
    iget-boolean v6, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->encrypt:Z

    if-eqz v6, :cond_2

    .line 667
    const/16 v6, 0x10

    new-array v6, v6, [B

    .line 668
    .local v6, "initializationVector":[B
    iget-object v7, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->random:Ljava/security/SecureRandom;

    invoke-static {v7}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/security/SecureRandom;

    invoke-virtual {v7, v6}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 669
    invoke-virtual {v0, v6}, Ljava/io/DataOutputStream;->write([B)V

    .line 670
    new-instance v7, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v7, v6}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 672
    .local v7, "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    :try_start_1
    iget-object v8, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;

    invoke-static {v8}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljavax/crypto/Cipher;

    iget-object v9, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->secretKeySpec:Ljavax/crypto/spec/SecretKeySpec;

    .line 673
    invoke-static {v9}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/security/Key;

    invoke-virtual {v8, v5, v9, v7}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    :try_end_1
    .catch Ljava/security/InvalidKeyException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/security/InvalidAlgorithmParameterException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 676
    nop

    .line 677
    :try_start_2
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 678
    new-instance v5, Ljava/io/DataOutputStream;

    new-instance v8, Ljavax/crypto/CipherOutputStream;

    iget-object v9, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->cipher:Ljavax/crypto/Cipher;

    invoke-direct {v8, v2, v9}, Ljavax/crypto/CipherOutputStream;-><init>(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V

    invoke-direct {v5, v8}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    move-object v0, v5

    goto :goto_3

    .line 674
    :catch_0
    move-exception v3

    goto :goto_2

    :catch_1
    move-exception v3

    .line 675
    .local v3, "e":Ljava/security/GeneralSecurityException;
    :goto_2
    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    .end local v0    # "output":Ljava/io/DataOutputStream;
    .end local p1    # "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    throw v5

    .line 681
    .end local v3    # "e":Ljava/security/GeneralSecurityException;
    .end local v6    # "initializationVector":[B
    .end local v7    # "ivParameterSpec":Ljavax/crypto/spec/IvParameterSpec;
    .restart local v0    # "output":Ljava/io/DataOutputStream;
    .restart local p1    # "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    :cond_2
    :goto_3
    invoke-virtual {p1}, Ljava/util/HashMap;->size()I

    move-result v5

    invoke-virtual {v0, v5}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 682
    const/4 v5, 0x0

    .line 683
    .local v5, "hashCode":I
    invoke-virtual {p1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_4
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/media3/datasource/cache/CachedContent;

    .line 684
    .local v7, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    invoke-direct {p0, v7, v0}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->writeCachedContent(Landroidx/media3/datasource/cache/CachedContent;Ljava/io/DataOutputStream;)V

    .line 685
    invoke-direct {p0, v7, v3}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->hashCachedContent(Landroidx/media3/datasource/cache/CachedContent;I)I

    move-result v8

    add-int/2addr v5, v8

    .line 686
    .end local v7    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    goto :goto_4

    .line 687
    :cond_3
    invoke-virtual {v0, v5}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 688
    iget-object v3, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v3, v0}, Landroidx/media3/common/util/AtomicFile;->endWrite(Ljava/io/OutputStream;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 691
    const/4 v0, 0x0

    .line 693
    .end local v1    # "outputStream":Ljava/io/OutputStream;
    .end local v2    # "bufferedOutputStream":Landroidx/media3/datasource/cache/ReusableBufferedOutputStream;
    .end local v4    # "flags":I
    .end local v5    # "hashCode":I
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 694
    nop

    .line 695
    return-void

    .line 693
    :catchall_0
    move-exception v1

    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 694
    throw v1
.end method


# virtual methods
.method public delete()V
    .locals 1

    .line 556
    iget-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v0}, Landroidx/media3/common/util/AtomicFile;->delete()V

    .line 557
    return-void
.end method

.method public exists()Z
    .locals 1

    .line 551
    iget-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v0}, Landroidx/media3/common/util/AtomicFile;->exists()Z

    move-result v0

    return v0
.end method

.method public initialize(J)V
    .locals 0
    .param p1, "uid"    # J

    .line 547
    return-void
.end method

.method public load(Ljava/util/HashMap;Landroid/util/SparseArray;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CachedContent;",
            ">;",
            "Landroid/util/SparseArray<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 562
    .local p1, "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    .local p2, "idToKey":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Ljava/lang/String;>;"
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    xor-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 563
    invoke-direct {p0, p1, p2}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->readFile(Ljava/util/HashMap;Landroid/util/SparseArray;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 564
    invoke-virtual {p1}, Ljava/util/HashMap;->clear()V

    .line 565
    invoke-virtual {p2}, Landroid/util/SparseArray;->clear()V

    .line 566
    iget-object v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->atomicFile:Landroidx/media3/common/util/AtomicFile;

    invoke-virtual {v0}, Landroidx/media3/common/util/AtomicFile;->delete()V

    .line 568
    :cond_0
    return-void
.end method

.method public onRemove(Landroidx/media3/datasource/cache/CachedContent;Z)V
    .locals 1
    .param p1, "cachedContent"    # Landroidx/media3/datasource/cache/CachedContent;
    .param p2, "neverStored"    # Z

    .line 591
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    .line 592
    return-void
.end method

.method public onUpdate(Landroidx/media3/datasource/cache/CachedContent;)V
    .locals 1
    .param p1, "cachedContent"    # Landroidx/media3/datasource/cache/CachedContent;

    .line 586
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    .line 587
    return-void
.end method

.method public storeFully(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CachedContent;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 572
    .local p1, "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    invoke-direct {p0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->writeFile(Ljava/util/HashMap;)V

    .line 573
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    .line 574
    return-void
.end method

.method public storeIncremental(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CachedContent;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 578
    .local p1, "content":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroidx/media3/datasource/cache/CachedContent;>;"
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->changed:Z

    if-nez v0, :cond_0

    .line 579
    return-void

    .line 581
    :cond_0
    invoke-virtual {p0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex$LegacyStorage;->storeFully(Ljava/util/HashMap;)V

    .line 582
    return-void
.end method
