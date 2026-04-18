.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageLiveLocationViewed;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageLiveLocationViewed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4dfa7a6b


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34629
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 34618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34619
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageLiveLocationViewed;->chatId:J

    .line 34620
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageLiveLocationViewed;->messageId:J

    .line 34621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34625
    const v0, -0x4dfa7a6b

    return v0
.end method
