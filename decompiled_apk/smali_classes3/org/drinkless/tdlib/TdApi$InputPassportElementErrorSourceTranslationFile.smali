.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceTranslationFile;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceTranslationFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e268a7b


# instance fields
.field public fileHash:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14946
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14947
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14937
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 14938
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceTranslationFile;->fileHash:[B

    .line 14939
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14943
    const v0, 0x1e268a7b

    return v0
.end method
