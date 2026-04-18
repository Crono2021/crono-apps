.class public Lorg/drinkless/tdlib/TdApi$EditQuickReplyMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditQuickReplyMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4cc978e


# instance fields
.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public messageId:J

.field public shortcutId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36829
    return-void
.end method

.method public constructor <init>(IJLorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 36817
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36818
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EditQuickReplyMessage;->shortcutId:I

    .line 36819
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditQuickReplyMessage;->messageId:J

    .line 36820
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditQuickReplyMessage;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 36821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36825
    const v0, 0x4cc978e

    return v0
.end method
