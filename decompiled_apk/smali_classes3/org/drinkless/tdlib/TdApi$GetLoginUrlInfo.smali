.class public Lorg/drinkless/tdlib/TdApi$GetLoginUrlInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLoginUrlInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3336624d


# instance fields
.field public buttonId:J

.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37379
    return-void
.end method

.method public constructor <init>(JJJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J

    .line 37367
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37368
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrlInfo;->chatId:J

    .line 37369
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrlInfo;->messageId:J

    .line 37370
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrlInfo;->buttonId:J

    .line 37371
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37375
    const v0, -0x3336624d

    return v0
.end method
