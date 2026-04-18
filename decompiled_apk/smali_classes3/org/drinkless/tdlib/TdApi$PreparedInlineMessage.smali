.class public Lorg/drinkless/tdlib/TdApi$PreparedInlineMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PreparedInlineMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6bd1833e


# instance fields
.field public chatTypes:Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

.field public inlineQueryId:J

.field public result:Lorg/drinkless/tdlib/TdApi$InlineQueryResult;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 39009
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InlineQueryResult;Lorg/drinkless/tdlib/TdApi$TargetChatTypes;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inlineQueryResult"    # Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
    .param p4, "targetChatTypes"    # Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

    .line 38997
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38998
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PreparedInlineMessage;->inlineQueryId:J

    .line 38999
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PreparedInlineMessage;->result:Lorg/drinkless/tdlib/TdApi$InlineQueryResult;

    .line 39000
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PreparedInlineMessage;->chatTypes:Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

    .line 39001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39005
    const v0, -0x6bd1833e

    return v0
.end method
