.class public Lorg/drinkless/tdlib/TdApi$TransferChatOwnership;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TransferChatOwnership"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x77a00a13


# instance fields
.field public chatId:J

.field public password:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41340
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41341
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;

    .line 41329
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41330
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TransferChatOwnership;->chatId:J

    .line 41331
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$TransferChatOwnership;->userId:J

    .line 41332
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$TransferChatOwnership;->password:Ljava/lang/String;

    .line 41333
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41337
    const v0, 0x77a00a13

    return v0
.end method
