.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceSelfie;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceSelfie"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e1bd368


# instance fields
.field public fileHash:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14929
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14919
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14920
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceSelfie;->fileHash:[B

    .line 14921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14925
    const v0, -0x2e1bd368    # -1.2250009E11f

    return v0
.end method
