.class public Lorg/drinkless/tdlib/TdApi$SetChatAvailableReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatAvailableReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xfeb3e06


# instance fields
.field public availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31169
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatAvailableReactions;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatAvailableReactions"    # Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 31158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31159
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatAvailableReactions;->chatId:J

    .line 31160
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatAvailableReactions;->availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 31161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31165
    const v0, 0xfeb3e06

    return v0
.end method
