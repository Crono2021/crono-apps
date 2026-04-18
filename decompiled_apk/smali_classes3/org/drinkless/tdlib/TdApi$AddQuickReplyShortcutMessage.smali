.class public Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddQuickReplyShortcutMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f188b2a


# instance fields
.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyToMessageId:J

.field public shortcutName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35442
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35443
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 35431
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35432
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutMessage;->shortcutName:Ljava/lang/String;

    .line 35433
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutMessage;->replyToMessageId:J

    .line 35434
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutMessage;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 35435
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35439
    const v0, 0x3f188b2a

    return v0
.end method
