.class public Lorg/drinkless/tdlib/TdApi$MessageGroupCall;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGroupCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x51ae9687


# instance fields
.field public duration:I

.field public isActive:Z

.field public isVideo:Z

.field public otherParticipantIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public wasMissed:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48112
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48113
    return-void
.end method

.method public constructor <init>(ZZZI[Lorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "i9"    # I
    .param p5, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48099
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48100
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGroupCall;->isActive:Z

    .line 48101
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageGroupCall;->wasMissed:Z

    .line 48102
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGroupCall;->isVideo:Z

    .line 48103
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessageGroupCall;->duration:I

    .line 48104
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGroupCall;->otherParticipantIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48105
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48109
    const v0, 0x51ae9687

    return v0
.end method
