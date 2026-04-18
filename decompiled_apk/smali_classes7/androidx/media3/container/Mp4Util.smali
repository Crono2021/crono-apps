.class public final Landroidx/media3/container/Mp4Util;
.super Ljava/lang/Object;
.source "Mp4Util.java"


# static fields
.field private static final UNIX_EPOCH_TO_MP4_TIME_DELTA_SECONDS:I = 0x7c25b080


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static mp4TimeToUnixTimeMs(J)J
    .locals 4
    .param p0, "mp4TimestampSeconds"    # J

    .line 41
    const-wide/32 v0, 0x7c25b080

    sub-long v0, p0, v0

    const-wide/16 v2, 0x3e8

    mul-long/2addr v0, v2

    return-wide v0
.end method

.method public static unixTimeToMp4TimeSeconds(J)J
    .locals 4
    .param p0, "unixTimestampMs"    # J

    .line 33
    const-wide/16 v0, 0x3e8

    div-long v0, p0, v0

    const-wide/32 v2, 0x7c25b080

    add-long/2addr v0, v2

    return-wide v0
.end method
