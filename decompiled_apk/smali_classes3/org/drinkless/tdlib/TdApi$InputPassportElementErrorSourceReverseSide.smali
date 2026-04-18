.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceReverseSide;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceReverseSide"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x189efdfb


# instance fields
.field public fileHash:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14910
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14911
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14901
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14902
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceReverseSide;->fileHash:[B

    .line 14903
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14907
    const v0, 0x189efdfb

    return v0
.end method
