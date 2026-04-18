.class public Lorg/drinkless/tdlib/TdApi$GetGroupsInCommon;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGroupsInCommon"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x16bdd36a


# instance fields
.field public limit:I

.field public offsetChatId:J

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37356
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37357
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 37345
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37346
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetGroupsInCommon;->userId:J

    .line 37347
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetGroupsInCommon;->offsetChatId:J

    .line 37348
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetGroupsInCommon;->limit:I

    .line 37349
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37353
    const v0, 0x16bdd36a

    return v0
.end method
