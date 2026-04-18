.class public Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatParticipantIsMutedToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventVideoChatParticipantIsMutedToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1f1058f7


# instance fields
.field public isMuted:Z

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24125
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Z)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "z8"    # Z

    .line 24114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24115
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatParticipantIsMutedToggled;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 24116
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatParticipantIsMutedToggled;->isMuted:Z

    .line 24117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24121
    const v0, 0x1f1058f7

    return v0
.end method
