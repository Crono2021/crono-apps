.class public Lorg/drinkless/tdlib/TdApi$QuickReplyMessages;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "QuickReplyMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2c4c8d27


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18259
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;)V
    .locals 0
    .param p1, "quickReplyMessageArr"    # [Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

    .line 18249
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 18250
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessages;->messages:[Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

    .line 18251
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18255
    const v0, 0x2c4c8d27

    return v0
.end method
