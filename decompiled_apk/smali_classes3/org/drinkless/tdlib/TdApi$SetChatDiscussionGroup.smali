.class public Lorg/drinkless/tdlib/TdApi$SetChatDiscussionGroup;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatDiscussionGroup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x36c3cd48


# instance fields
.field public chatId:J

.field public discussionChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31229
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 31218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31219
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatDiscussionGroup;->chatId:J

    .line 31220
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatDiscussionGroup;->discussionChatId:J

    .line 31221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31225
    const v0, -0x36c3cd48    # -770859.5f

    return v0
.end method
