.class public Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NewChatPrivacySettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x75fc260


# instance fields
.field public allowNewChatsFromUnknownUsers:Z

.field public incomingPaidMessageStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28845
    return-void
.end method

.method public constructor <init>(ZJ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "j5"    # J

    .line 28834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28835
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;->allowNewChatsFromUnknownUsers:Z

    .line 28836
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;->incomingPaidMessageStarCount:J

    .line 28837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28841
    const v0, 0x75fc260

    return v0
.end method
