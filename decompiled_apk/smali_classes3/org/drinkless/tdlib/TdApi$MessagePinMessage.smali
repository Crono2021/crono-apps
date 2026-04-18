.class public Lorg/drinkless/tdlib/TdApi$MessagePinMessage;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePinMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38d55039


# instance fields
.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16620
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16621
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16611
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16612
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePinMessage;->messageId:J

    .line 16613
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16617
    const v0, 0x38d55039

    return v0
.end method
