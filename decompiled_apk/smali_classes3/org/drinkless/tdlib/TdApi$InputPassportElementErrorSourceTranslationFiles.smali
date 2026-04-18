.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceTranslationFiles;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceTranslationFiles"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1f6d4220


# instance fields
.field public fileHashes:[[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14965
    return-void
.end method

.method public constructor <init>([[B)V
    .locals 0
    .param p1, "bArr"    # [[B

    .line 14955
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14956
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceTranslationFiles;->fileHashes:[[B

    .line 14957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14961
    const v0, -0x1f6d4220

    return v0
.end method
