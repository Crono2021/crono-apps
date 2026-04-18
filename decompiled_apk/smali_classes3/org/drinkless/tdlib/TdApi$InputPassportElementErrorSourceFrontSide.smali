.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceFrontSide;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceFrontSide"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x230c87bd


# instance fields
.field public fileHash:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14892
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14893
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14883
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14884
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceFrontSide;->fileHash:[B

    .line 14885
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14889
    const v0, 0x230c87bd

    return v0
.end method
