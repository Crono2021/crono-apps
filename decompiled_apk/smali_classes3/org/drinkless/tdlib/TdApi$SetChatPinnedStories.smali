.class public Lorg/drinkless/tdlib/TdApi$SetChatPinnedStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatPinnedStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x27e114d3


# instance fields
.field public chatId:J

.field public storyIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31408
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31409
    return-void
.end method

.method public constructor <init>(J[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "iArr"    # [I

    .line 31398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31399
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatPinnedStories;->chatId:J

    .line 31400
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatPinnedStories;->storyIds:[I

    .line 31401
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31405
    const v0, -0x27e114d3

    return v0
.end method
