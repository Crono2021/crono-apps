.class public Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteDirectMessagesChatTopicHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x719c79c4


# instance fields
.field public chatId:J

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25085
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 25074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25075
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicHistory;->chatId:J

    .line 25076
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteDirectMessagesChatTopicHistory;->topicId:J

    .line 25077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25081
    const v0, -0x719c79c4

    return v0
.end method
