.class public Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcutMessages;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateQuickReplyShortcutMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x533fb9a9


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

.field public shortcutId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34809
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "quickReplyMessageArr"    # [Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

    .line 34798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34799
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcutMessages;->shortcutId:I

    .line 34800
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcutMessages;->messages:[Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

    .line 34801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34805
    const v0, -0x533fb9a9

    return v0
.end method
