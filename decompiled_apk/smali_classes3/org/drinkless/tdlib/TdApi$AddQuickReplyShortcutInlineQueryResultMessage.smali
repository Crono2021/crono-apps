.class public Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddQuickReplyShortcutInlineQueryResultMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x783fd5fc


# instance fields
.field public hideViaBot:Z

.field public queryId:J

.field public replyToMessageId:J

.field public resultId:Ljava/lang/String;

.field public shortcutName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46552
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46553
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLjava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "z8"    # Z

    .line 46539
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46540
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;->shortcutName:Ljava/lang/String;

    .line 46541
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;->replyToMessageId:J

    .line 46542
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;->queryId:J

    .line 46543
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;->resultId:Ljava/lang/String;

    .line 46544
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$AddQuickReplyShortcutInlineQueryResultMessage;->hideViaBot:Z

    .line 46545
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46549
    const v0, -0x783fd5fc

    return v0
.end method
