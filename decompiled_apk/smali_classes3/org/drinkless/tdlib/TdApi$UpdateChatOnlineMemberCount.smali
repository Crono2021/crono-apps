.class public Lorg/drinkless/tdlib/TdApi$UpdateChatOnlineMemberCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatOnlineMemberCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d0caa9d


# instance fields
.field public chatId:J

.field public onlineMemberCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34169
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 34158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34159
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatOnlineMemberCount;->chatId:J

    .line 34160
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatOnlineMemberCount;->onlineMemberCount:I

    .line 34161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34165
    const v0, 0x1d0caa9d

    return v0
.end method
