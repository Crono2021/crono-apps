.class public Lorg/drinkless/tdlib/TdApi$GetChatPostedToChatPageStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatPostedToChatPageStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c438d5


# instance fields
.field public chatId:J

.field public fromStoryId:I

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37246
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37247
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 37235
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37236
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatPostedToChatPageStories;->chatId:J

    .line 37237
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatPostedToChatPageStories;->fromStoryId:I

    .line 37238
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatPostedToChatPageStories;->limit:I

    .line 37239
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37243
    const v0, -0x2c438d5    # -1.5599986E37f

    return v0
.end method
