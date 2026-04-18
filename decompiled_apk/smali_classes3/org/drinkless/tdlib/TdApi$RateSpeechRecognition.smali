.class public Lorg/drinkless/tdlib/TdApi$RateSpeechRecognition;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RateSpeechRecognition"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x11233c4b


# instance fields
.field public chatId:J

.field public isGood:Z

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39316
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39317
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 39305
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39306
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RateSpeechRecognition;->chatId:J

    .line 39307
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$RateSpeechRecognition;->messageId:J

    .line 39308
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$RateSpeechRecognition;->isGood:Z

    .line 39309
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39313
    const v0, -0x11233c4b

    return v0
.end method
