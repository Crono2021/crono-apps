.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceDataField;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementErrorSourceDataField"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19705ffa


# instance fields
.field public dataHash:[B

.field public fieldName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 27405
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[B)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "bArr"    # [B

    .line 27394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;-><init>()V

    .line 27395
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceDataField;->fieldName:Ljava/lang/String;

    .line 27396
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSourceDataField;->dataHash:[B

    .line 27397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27401
    const v0, -0x19705ffa

    return v0
.end method
