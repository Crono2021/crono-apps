.class public Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatMuteNewParticipantsToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventVideoChatMuteNewParticipantsToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78af802


# instance fields
.field public muteNewParticipants:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10122
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10123
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10113
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 10114
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventVideoChatMuteNewParticipantsToggled;->muteNewParticipants:Z

    .line 10115
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10119
    const v0, -0x78af802

    return v0
.end method
