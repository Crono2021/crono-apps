.class public Lorg/drinkless/tdlib/TdApi$VideoChatStreams;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoChatStreams"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19e7d100


# instance fields
.field public streams:[Lorg/drinkless/tdlib/TdApi$VideoChatStream;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22592
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22593
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$VideoChatStream;)V
    .locals 0
    .param p1, "videoChatStreamArr"    # [Lorg/drinkless/tdlib/TdApi$VideoChatStream;

    .line 22583
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22584
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$VideoChatStreams;->streams:[Lorg/drinkless/tdlib/TdApi$VideoChatStream;

    .line 22585
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22589
    const v0, -0x19e7d100

    return v0
.end method
