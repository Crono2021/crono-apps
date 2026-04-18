.class public Lorg/drinkless/tdlib/TdApi$SetProfileAudioPosition;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetProfileAudioPosition"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x481e945e


# instance fields
.field public afterFileId:I

.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31789
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 31778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31779
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetProfileAudioPosition;->fileId:I

    .line 31780
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SetProfileAudioPosition;->afterFileId:I

    .line 31781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31785
    const v0, 0x481e945e

    return v0
.end method
