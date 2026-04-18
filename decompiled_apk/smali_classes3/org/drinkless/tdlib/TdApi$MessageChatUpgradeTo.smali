.class public Lorg/drinkless/tdlib/TdApi$MessageChatUpgradeTo;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatUpgradeTo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63f549b


# instance fields
.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16350
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16351
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16341
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16342
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatUpgradeTo;->supergroupId:J

    .line 16343
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16347
    const v0, 0x63f549b

    return v0
.end method
