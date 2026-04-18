.class public Lorg/drinkless/tdlib/TdApi$SetMessageSenderBotVerification;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMessageSenderBotVerification"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4b3e25b6


# instance fields
.field public botUserId:J

.field public customDescription:Ljava/lang/String;

.field public verifiedId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40482
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40483
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "str"    # Ljava/lang/String;

    .line 40471
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40472
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetMessageSenderBotVerification;->botUserId:J

    .line 40473
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetMessageSenderBotVerification;->verifiedId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 40474
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetMessageSenderBotVerification;->customDescription:Ljava/lang/String;

    .line 40475
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40479
    const v0, -0x4b3e25b6

    return v0
.end method
