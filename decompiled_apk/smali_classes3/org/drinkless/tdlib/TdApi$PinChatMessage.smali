.class public Lorg/drinkless/tdlib/TdApi$PinChatMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PinChatMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79475baf


# instance fields
.field public chatId:J

.field public disableNotification:Z

.field public messageId:J

.field public onlyForSelf:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44670
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44671
    return-void
.end method

.method public constructor <init>(JJZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z

    .line 44658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44659
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PinChatMessage;->chatId:J

    .line 44660
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$PinChatMessage;->messageId:J

    .line 44661
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$PinChatMessage;->disableNotification:Z

    .line 44662
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$PinChatMessage;->onlyForSelf:Z

    .line 44663
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44667
    const v0, 0x79475baf

    return v0
.end method
