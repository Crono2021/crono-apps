.class public Lorg/drinkless/tdlib/TdApi$MessageChatShared;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatShared"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5139269f


# instance fields
.field public buttonId:I

.field public chat:Lorg/drinkless/tdlib/TdApi$SharedChat;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28325
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$SharedChat;I)V
    .locals 0
    .param p1, "sharedChat"    # Lorg/drinkless/tdlib/TdApi$SharedChat;
    .param p2, "i9"    # I

    .line 28314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28315
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatShared;->chat:Lorg/drinkless/tdlib/TdApi$SharedChat;

    .line 28316
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$MessageChatShared;->buttonId:I

    .line 28317
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28321
    const v0, -0x5139269f

    return v0
.end method
