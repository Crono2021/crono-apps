.class public Lorg/drinkless/tdlib/TdApi$TargetChatTypes;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TargetChatTypes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a300e51


# instance fields
.field public allowBotChats:Z

.field public allowChannelChats:Z

.field public allowGroupChats:Z

.field public allowUserChats:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45775
    return-void
.end method

.method public constructor <init>(ZZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z

    .line 45762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45763
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$TargetChatTypes;->allowUserChats:Z

    .line 45764
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$TargetChatTypes;->allowBotChats:Z

    .line 45765
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$TargetChatTypes;->allowGroupChats:Z

    .line 45766
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$TargetChatTypes;->allowChannelChats:Z

    .line 45767
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45771
    const v0, 0x5a300e51

    return v0
.end method
