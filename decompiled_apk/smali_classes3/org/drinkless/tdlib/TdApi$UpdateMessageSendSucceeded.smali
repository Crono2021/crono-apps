.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageSendSucceeded;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageSendSucceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6c399d7d


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;

.field public oldMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34669
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;J)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "j5"    # J

    .line 34658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34659
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendSucceeded;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 34660
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendSucceeded;->oldMessageId:J

    .line 34661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34665
    const v0, 0x6c399d7d

    return v0
.end method
