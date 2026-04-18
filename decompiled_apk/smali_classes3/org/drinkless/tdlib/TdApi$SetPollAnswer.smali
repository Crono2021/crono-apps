.class public Lorg/drinkless/tdlib/TdApi$SetPollAnswer;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPollAnswer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5368fa78


# instance fields
.field public chatId:J

.field public messageId:J

.field public optionIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40526
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40527
    return-void
.end method

.method public constructor <init>(JJ[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "iArr"    # [I

    .line 40515
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40516
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetPollAnswer;->chatId:J

    .line 40517
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetPollAnswer;->messageId:J

    .line 40518
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetPollAnswer;->optionIds:[I

    .line 40519
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40523
    const v0, -0x5368fa78

    return v0
.end method
