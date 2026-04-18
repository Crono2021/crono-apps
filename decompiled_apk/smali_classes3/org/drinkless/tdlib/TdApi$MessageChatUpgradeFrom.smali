.class public Lorg/drinkless/tdlib/TdApi$MessageChatUpgradeFrom;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatUpgradeFrom"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x136daadc


# instance fields
.field public basicGroupId:J

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28345
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 28334
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28335
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatUpgradeFrom;->title:Ljava/lang/String;

    .line 28336
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessageChatUpgradeFrom;->basicGroupId:J

    .line 28337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28341
    const v0, 0x136daadc    # 2.9997846E-27f

    return v0
.end method
