.class public Lorg/drinkless/tdlib/TdApi$SavePreparedInlineMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SavePreparedInlineMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PreparedInlineMessageId;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x38eb9727


# instance fields
.field public chatTypes:Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

.field public result:Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39756
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39757
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputInlineQueryResult;Lorg/drinkless/tdlib/TdApi$TargetChatTypes;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputInlineQueryResult"    # Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
    .param p4, "targetChatTypes"    # Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

    .line 39745
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39746
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SavePreparedInlineMessage;->userId:J

    .line 39747
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SavePreparedInlineMessage;->result:Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

    .line 39748
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SavePreparedInlineMessage;->chatTypes:Lorg/drinkless/tdlib/TdApi$TargetChatTypes;

    .line 39749
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39753
    const v0, -0x38eb9727

    return v0
.end method
