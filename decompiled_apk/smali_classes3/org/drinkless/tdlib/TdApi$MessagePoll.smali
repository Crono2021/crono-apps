.class public Lorg/drinkless/tdlib/TdApi$MessagePoll;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePoll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x27774db3


# instance fields
.field public poll:Lorg/drinkless/tdlib/TdApi$Poll;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16639
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Poll;)V
    .locals 0
    .param p1, "poll"    # Lorg/drinkless/tdlib/TdApi$Poll;

    .line 16629
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16630
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePoll;->poll:Lorg/drinkless/tdlib/TdApi$Poll;

    .line 16631
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16635
    const v0, -0x27774db3

    return v0
.end method
