.class public Lorg/drinkless/tdlib/TdApi$SecretChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SecretChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2858f435


# instance fields
.field public id:I

.field public isOutbound:Z

.field public keyHash:[B

.field public layer:I

.field public state:Lorg/drinkless/tdlib/TdApi$SecretChatState;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50682
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50683
    return-void
.end method

.method public constructor <init>(IJLorg/drinkless/tdlib/TdApi$SecretChatState;Z[BI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "secretChatState"    # Lorg/drinkless/tdlib/TdApi$SecretChatState;
    .param p5, "z8"    # Z
    .param p6, "bArr"    # [B
    .param p7, "i10"    # I

    .line 50668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50669
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->id:I

    .line 50670
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->userId:J

    .line 50671
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->state:Lorg/drinkless/tdlib/TdApi$SecretChatState;

    .line 50672
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->isOutbound:Z

    .line 50673
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->keyHash:[B

    .line 50674
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$SecretChat;->layer:I

    .line 50675
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50679
    const v0, -0x2858f435

    return v0
.end method
