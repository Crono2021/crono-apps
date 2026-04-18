.class public Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "QuickReplyShortcut"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4202656b


# instance fields
.field public firstMessage:Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

.field public id:I

.field public messageCount:I

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44790
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44791
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "quickReplyMessage"    # Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;
    .param p4, "i10"    # I

    .line 44778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44779
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;->id:I

    .line 44780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;->name:Ljava/lang/String;

    .line 44781
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;->firstMessage:Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;

    .line 44782
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;->messageCount:I

    .line 44783
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44787
    const v0, -0x4202656b    # -0.12383f

    return v0
.end method
