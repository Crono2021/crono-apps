.class public final Landroidx/media3/exoplayer/util/SntpClient;
.super Ljava/lang/Object;
.source "SntpClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;,
        Landroidx/media3/exoplayer/util/SntpClient$NtpTimeLoadable;,
        Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;
    }
.end annotation


# static fields
.field public static final DEFAULT_NTP_HOST:Ljava/lang/String; = "time.android.com"

.field private static final NTP_LEAP_NOSYNC:I = 0x3

.field private static final NTP_MODE_BROADCAST:I = 0x5

.field private static final NTP_MODE_CLIENT:I = 0x3

.field private static final NTP_MODE_SERVER:I = 0x4

.field private static final NTP_PACKET_SIZE:I = 0x30

.field private static final NTP_PORT:I = 0x7b

.field private static final NTP_STRATUM_DEATH:I = 0x0

.field private static final NTP_STRATUM_MAX:I = 0xf

.field private static final NTP_VERSION:I = 0x3

.field private static final OFFSET_1900_TO_1970:J = 0x83aa7e80L

.field private static final ORIGINATE_TIME_OFFSET:I = 0x18

.field private static final RECEIVE_TIME_OFFSET:I = 0x20

.field private static final TIMEOUT_MS:I = 0x2710

.field private static final TRANSMIT_TIME_OFFSET:I = 0x28

.field private static elapsedRealtimeOffsetMs:J

.field private static isInitialized:Z

.field private static final loaderLock:Ljava/lang/Object;

.field private static ntpHost:Ljava/lang/String;

.field private static final valueLock:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 79
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/media3/exoplayer/util/SntpClient;->loaderLock:Ljava/lang/Object;

    .line 80
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    .line 89
    const-string/jumbo v0, "time.android.com"

    sput-object v0, Landroidx/media3/exoplayer/util/SntpClient;->ntpHost:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$100()Ljava/lang/Object;
    .locals 1

    .line 41
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->loaderLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/Object;
    .locals 1

    .line 41
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$300()Z
    .locals 1

    .line 41
    sget-boolean v0, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized:Z

    return v0
.end method

.method static synthetic access$302(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .line 41
    sput-boolean p0, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized:Z

    return p0
.end method

.method static synthetic access$400()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 41
    invoke-static {}, Landroidx/media3/exoplayer/util/SntpClient;->loadNtpTimeOffsetMs()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$502(J)J
    .locals 0
    .param p0, "x0"    # J

    .line 41
    sput-wide p0, Landroidx/media3/exoplayer/util/SntpClient;->elapsedRealtimeOffsetMs:J

    return-wide p0
.end method

.method private static checkValidServerReply(BBIJ)V
    .locals 3
    .param p0, "leap"    # B
    .param p1, "mode"    # B
    .param p2, "stratum"    # I
    .param p3, "transmitTime"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 272
    const/4 v0, 0x3

    if-eq p0, v0, :cond_4

    .line 275
    const/4 v0, 0x4

    if-eq p1, v0, :cond_1

    const/4 v0, 0x5

    if-ne p1, v0, :cond_0

    goto :goto_0

    .line 276
    :cond_0
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "SNTP: Untrusted mode: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 278
    :cond_1
    :goto_0
    if-eqz p2, :cond_3

    const/16 v0, 0xf

    if-gt p2, v0, :cond_3

    .line 281
    const-wide/16 v0, 0x0

    cmp-long v0, p3, v0

    if-eqz v0, :cond_2

    .line 284
    return-void

    .line 282
    :cond_2
    new-instance v0, Ljava/io/IOException;

    const-string v1, "SNTP: Zero transmitTime"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 279
    :cond_3
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "SNTP: Untrusted stratum: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 273
    :cond_4
    new-instance v0, Ljava/io/IOException;

    const-string v1, "SNTP: Unsynchronized server"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getElapsedRealtimeOffsetMs()J
    .locals 3

    .line 138
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    monitor-enter v0

    .line 139
    :try_start_0
    sget-boolean v1, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized:Z

    if-eqz v1, :cond_0

    sget-wide v1, Landroidx/media3/exoplayer/util/SntpClient;->elapsedRealtimeOffsetMs:J

    goto :goto_0

    :cond_0
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    :goto_0
    monitor-exit v0

    return-wide v1

    .line 140
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static getNtpHost()Ljava/lang/String;
    .locals 2

    .line 95
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    monitor-enter v0

    .line 96
    :try_start_0
    sget-object v1, Landroidx/media3/exoplayer/util/SntpClient;->ntpHost:Ljava/lang/String;

    monitor-exit v0

    return-object v1

    .line 97
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static initialize(Landroidx/media3/exoplayer/upstream/Loader;Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;)V
    .locals 3
    .param p0, "loader"    # Landroidx/media3/exoplayer/upstream/Loader;
    .param p1, "callback"    # Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    .line 152
    invoke-static {}, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 153
    if-eqz p1, :cond_0

    .line 154
    invoke-interface {p1}, Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;->onInitialized()V

    .line 156
    :cond_0
    return-void

    .line 158
    :cond_1
    if-nez p0, :cond_2

    .line 159
    new-instance v0, Landroidx/media3/exoplayer/upstream/Loader;

    const-string v1, "SntpClient"

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/upstream/Loader;-><init>(Ljava/lang/String;)V

    move-object p0, v0

    .line 161
    :cond_2
    new-instance v0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeLoadable;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeLoadable;-><init>(Landroidx/media3/exoplayer/util/SntpClient$1;)V

    new-instance v1, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;

    invoke-direct {v1, p1}, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;-><init>(Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;)V

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Landroidx/media3/exoplayer/upstream/Loader;->startLoading(Landroidx/media3/exoplayer/upstream/Loader$Loadable;Landroidx/media3/exoplayer/upstream/Loader$Callback;I)J

    .line 163
    return-void
.end method

.method public static isInitialized()Z
    .locals 2

    .line 126
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    monitor-enter v0

    .line 127
    :try_start_0
    sget-boolean v1, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized:Z

    monitor-exit v0

    return v1

    .line 128
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static loadNtpTimeOffsetMs()J
    .locals 30
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 166
    invoke-static {}, Landroidx/media3/exoplayer/util/SntpClient;->getNtpHost()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v1

    .line 167
    .local v1, "address":Ljava/net/InetAddress;
    new-instance v0, Ljava/net/DatagramSocket;

    invoke-direct {v0}, Ljava/net/DatagramSocket;-><init>()V

    move-object v2, v0

    .line 168
    .local v2, "socket":Ljava/net/DatagramSocket;
    const/16 v0, 0x2710

    :try_start_0
    invoke-virtual {v2, v0}, Ljava/net/DatagramSocket;->setSoTimeout(I)V

    .line 169
    const/16 v0, 0x30

    new-array v0, v0, [B

    .line 170
    .local v0, "buffer":[B
    new-instance v3, Ljava/net/DatagramPacket;

    array-length v4, v0

    const/16 v5, 0x7b

    invoke-direct {v3, v0, v4, v1, v5}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V

    .line 174
    .local v3, "request":Ljava/net/DatagramPacket;
    const/16 v4, 0x1b

    const/4 v5, 0x0

    aput-byte v4, v0, v5

    .line 177
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 178
    .local v6, "requestTime":J
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    .line 179
    .local v8, "requestTicks":J
    const/16 v4, 0x28

    invoke-static {v0, v4, v6, v7}, Landroidx/media3/exoplayer/util/SntpClient;->writeTimestamp([BIJ)V

    .line 181
    invoke-virtual {v2, v3}, Ljava/net/DatagramSocket;->send(Ljava/net/DatagramPacket;)V

    .line 184
    new-instance v10, Ljava/net/DatagramPacket;

    array-length v11, v0

    invoke-direct {v10, v0, v11}, Ljava/net/DatagramPacket;-><init>([BI)V

    .line 185
    .local v10, "response":Ljava/net/DatagramPacket;
    invoke-virtual {v2, v10}, Ljava/net/DatagramSocket;->receive(Ljava/net/DatagramPacket;)V

    .line 186
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v11

    .line 187
    .local v11, "responseTicks":J
    sub-long v13, v11, v8

    add-long/2addr v13, v6

    .line 190
    .local v13, "responseTime":J
    aget-byte v15, v0, v5

    shr-int/lit8 v15, v15, 0x6

    and-int/lit8 v15, v15, 0x3

    int-to-byte v15, v15

    .line 191
    .local v15, "leap":B
    aget-byte v5, v0, v5

    and-int/lit8 v5, v5, 0x7

    int-to-byte v5, v5

    .line 192
    .local v5, "mode":B
    const/16 v16, 0x1

    aget-byte v4, v0, v16
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    and-int/lit16 v4, v4, 0xff

    .line 193
    .local v4, "stratum":I
    move-object/from16 v16, v1

    .end local v1    # "address":Ljava/net/InetAddress;
    .local v16, "address":Ljava/net/InetAddress;
    const/16 v1, 0x18

    :try_start_1
    invoke-static {v0, v1}, Landroidx/media3/exoplayer/util/SntpClient;->readTimestamp([BI)J

    move-result-wide v18

    .line 194
    .local v18, "originateTime":J
    const/16 v1, 0x20

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/util/SntpClient;->readTimestamp([BI)J

    move-result-wide v20

    .line 195
    .local v20, "receiveTime":J
    const/16 v1, 0x28

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/util/SntpClient;->readTimestamp([BI)J

    move-result-wide v22

    move-wide/from16 v24, v22

    .line 198
    .local v24, "transmitTime":J
    move-object/from16 v17, v0

    move-wide/from16 v0, v24

    .end local v24    # "transmitTime":J
    .local v0, "transmitTime":J
    .local v17, "buffer":[B
    invoke-static {v15, v5, v4, v0, v1}, Landroidx/media3/exoplayer/util/SntpClient;->checkValidServerReply(BBIJ)V

    .line 208
    sub-long v22, v20, v18

    sub-long v24, v0, v13

    add-long v22, v22, v24

    const-wide/16 v24, 0x2

    div-long v22, v22, v24
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 212
    .local v22, "clockOffset":J
    add-long v24, v13, v22

    .line 213
    .local v24, "ntpTime":J
    move-wide/from16 v26, v11

    .line 215
    .local v26, "ntpTimeReference":J
    sub-long v28, v24, v26

    .line 216
    invoke-virtual {v2}, Ljava/net/DatagramSocket;->close()V

    .line 215
    return-wide v28

    .line 167
    .end local v0    # "transmitTime":J
    .end local v3    # "request":Ljava/net/DatagramPacket;
    .end local v4    # "stratum":I
    .end local v5    # "mode":B
    .end local v6    # "requestTime":J
    .end local v8    # "requestTicks":J
    .end local v10    # "response":Ljava/net/DatagramPacket;
    .end local v11    # "responseTicks":J
    .end local v13    # "responseTime":J
    .end local v15    # "leap":B
    .end local v17    # "buffer":[B
    .end local v18    # "originateTime":J
    .end local v20    # "receiveTime":J
    .end local v22    # "clockOffset":J
    .end local v24    # "ntpTime":J
    .end local v26    # "ntpTimeReference":J
    :catchall_0
    move-exception v0

    move-object v1, v0

    goto :goto_0

    .end local v16    # "address":Ljava/net/InetAddress;
    .restart local v1    # "address":Ljava/net/InetAddress;
    :catchall_1
    move-exception v0

    move-object/from16 v16, v1

    move-object v1, v0

    .end local v1    # "address":Ljava/net/InetAddress;
    .restart local v16    # "address":Ljava/net/InetAddress;
    :goto_0
    :try_start_2
    invoke-virtual {v2}, Ljava/net/DatagramSocket;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_1

    :catchall_2
    move-exception v0

    move-object v3, v0

    invoke-virtual {v1, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_1
    throw v1
.end method

.method private static read32([BI)J
    .locals 13
    .param p0, "buffer"    # [B
    .param p1, "offset"    # I

    .line 256
    aget-byte v0, p0, p1

    .line 257
    .local v0, "b0":B
    add-int/lit8 v1, p1, 0x1

    aget-byte v1, p0, v1

    .line 258
    .local v1, "b1":B
    add-int/lit8 v2, p1, 0x2

    aget-byte v2, p0, v2

    .line 259
    .local v2, "b2":B
    add-int/lit8 v3, p1, 0x3

    aget-byte v3, p0, v3

    .line 262
    .local v3, "b3":B
    and-int/lit16 v4, v0, 0x80

    const/16 v5, 0x80

    if-ne v4, v5, :cond_0

    and-int/lit8 v4, v0, 0x7f

    add-int/2addr v4, v5

    goto :goto_0

    :cond_0
    move v4, v0

    .line 263
    .local v4, "i0":I
    :goto_0
    and-int/lit16 v6, v1, 0x80

    if-ne v6, v5, :cond_1

    and-int/lit8 v6, v1, 0x7f

    add-int/2addr v6, v5

    goto :goto_1

    :cond_1
    move v6, v1

    .line 264
    .local v6, "i1":I
    :goto_1
    and-int/lit16 v7, v2, 0x80

    if-ne v7, v5, :cond_2

    and-int/lit8 v7, v2, 0x7f

    add-int/2addr v7, v5

    goto :goto_2

    :cond_2
    move v7, v2

    .line 265
    .local v7, "i2":I
    :goto_2
    and-int/lit16 v8, v3, 0x80

    if-ne v8, v5, :cond_3

    and-int/lit8 v8, v3, 0x7f

    add-int/2addr v8, v5

    goto :goto_3

    :cond_3
    move v8, v3

    :goto_3
    move v5, v8

    .line 267
    .local v5, "i3":I
    int-to-long v8, v4

    const/16 v10, 0x18

    shl-long/2addr v8, v10

    int-to-long v10, v6

    const/16 v12, 0x10

    shl-long/2addr v10, v12

    add-long/2addr v8, v10

    int-to-long v10, v7

    const/16 v12, 0x8

    shl-long/2addr v10, v12

    add-long/2addr v8, v10

    int-to-long v10, v5

    add-long/2addr v8, v10

    return-wide v8
.end method

.method private static readTimestamp([BI)J
    .locals 10
    .param p0, "buffer"    # [B
    .param p1, "offset"    # I

    .line 220
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/util/SntpClient;->read32([BI)J

    move-result-wide v0

    .line 221
    .local v0, "seconds":J
    add-int/lit8 v2, p1, 0x4

    invoke-static {p0, v2}, Landroidx/media3/exoplayer/util/SntpClient;->read32([BI)J

    move-result-wide v2

    .line 223
    .local v2, "fraction":J
    const-wide/16 v4, 0x0

    cmp-long v6, v0, v4

    if-nez v6, :cond_0

    cmp-long v6, v2, v4

    if-nez v6, :cond_0

    .line 224
    return-wide v4

    .line 226
    :cond_0
    const-wide v4, 0x83aa7e80L

    sub-long v4, v0, v4

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    mul-long/2addr v6, v2

    const-wide v8, 0x100000000L

    div-long/2addr v6, v8

    add-long/2addr v4, v6

    return-wide v4
.end method

.method public static setNtpHost(Ljava/lang/String;)V
    .locals 2
    .param p0, "ntpHost"    # Ljava/lang/String;

    .line 111
    sget-object v0, Landroidx/media3/exoplayer/util/SntpClient;->valueLock:Ljava/lang/Object;

    monitor-enter v0

    .line 112
    :try_start_0
    sget-object v1, Landroidx/media3/exoplayer/util/SntpClient;->ntpHost:Ljava/lang/String;

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 113
    sput-object p0, Landroidx/media3/exoplayer/util/SntpClient;->ntpHost:Ljava/lang/String;

    .line 114
    const/4 v1, 0x0

    sput-boolean v1, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized:Z

    .line 116
    :cond_0
    monitor-exit v0

    .line 117
    return-void

    .line 116
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static writeTimestamp([BIJ)V
    .locals 15
    .param p0, "buffer"    # [B
    .param p1, "offset"    # I
    .param p2, "time"    # J

    .line 231
    move-object v0, p0

    move/from16 v1, p1

    const-wide/16 v2, 0x0

    cmp-long v2, p2, v2

    const/4 v3, 0x0

    if-nez v2, :cond_0

    .line 232
    add-int/lit8 v2, v1, 0x8

    invoke-static {p0, v1, v2, v3}, Ljava/util/Arrays;->fill([BIIB)V

    .line 233
    return-void

    .line 236
    :cond_0
    const-wide/16 v4, 0x3e8

    div-long v6, p2, v4

    .line 237
    .local v6, "seconds":J
    mul-long v8, v6, v4

    sub-long v8, p2, v8

    .line 238
    .local v8, "milliseconds":J
    const-wide v10, 0x83aa7e80L

    add-long/2addr v6, v10

    .line 241
    add-int/lit8 v2, v1, 0x1

    .end local p1    # "offset":I
    .local v2, "offset":I
    const/16 v10, 0x18

    shr-long v11, v6, v10

    long-to-int v11, v11

    int-to-byte v11, v11

    aput-byte v11, v0, v1

    .line 242
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "offset":I
    .local v1, "offset":I
    const/16 v11, 0x10

    shr-long v12, v6, v11

    long-to-int v12, v12

    int-to-byte v12, v12

    aput-byte v12, v0, v2

    .line 243
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "offset":I
    .restart local v2    # "offset":I
    const/16 v12, 0x8

    shr-long v13, v6, v12

    long-to-int v13, v13

    int-to-byte v13, v13

    aput-byte v13, v0, v1

    .line 244
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "offset":I
    .restart local v1    # "offset":I
    shr-long v13, v6, v3

    long-to-int v3, v13

    int-to-byte v3, v3

    aput-byte v3, v0, v2

    .line 246
    const-wide v2, 0x100000000L

    mul-long/2addr v2, v8

    div-long/2addr v2, v4

    .line 248
    .local v2, "fraction":J
    add-int/lit8 v4, v1, 0x1

    .end local v1    # "offset":I
    .local v4, "offset":I
    shr-long v13, v2, v10

    long-to-int v5, v13

    int-to-byte v5, v5

    aput-byte v5, v0, v1

    .line 249
    add-int/lit8 v1, v4, 0x1

    .end local v4    # "offset":I
    .restart local v1    # "offset":I
    shr-long v10, v2, v11

    long-to-int v5, v10

    int-to-byte v5, v5

    aput-byte v5, v0, v4

    .line 250
    add-int/lit8 v4, v1, 0x1

    .end local v1    # "offset":I
    .restart local v4    # "offset":I
    shr-long v10, v2, v12

    long-to-int v5, v10

    int-to-byte v5, v5

    aput-byte v5, v0, v1

    .line 252
    add-int/lit8 v1, v4, 0x1

    .end local v4    # "offset":I
    .restart local v1    # "offset":I
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide v12, 0x406fe00000000000L    # 255.0

    mul-double/2addr v10, v12

    double-to-int v5, v10

    int-to-byte v5, v5

    aput-byte v5, v0, v4

    .line 253
    return-void
.end method
