.class public Lorg/drinkless/tdlib/TdApi$RemoveMessageSenderBotVerification;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveMessageSenderBotVerification"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x65ef30a6


# instance fields
.field public botUserId:J

.field public verifiedId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29909
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 29898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29899
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveMessageSenderBotVerification;->botUserId:J

    .line 29900
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RemoveMessageSenderBotVerification;->verifiedId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 29901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29905
    const v0, -0x65ef30a6    # -2.9946E-23f

    return v0
.end method
