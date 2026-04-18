.class public Lorg/drinkless/tdlib/TdApi$VideoChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x51ea72d8


# instance fields
.field public defaultParticipantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public groupCallId:I

.field public hasParticipants:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42110
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42111
    return-void
.end method

.method public constructor <init>(IZLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 42099
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42100
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$VideoChat;->groupCallId:I

    .line 42101
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$VideoChat;->hasParticipants:Z

    .line 42102
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$VideoChat;->defaultParticipantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 42103
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42107
    const v0, -0x51ea72d8

    return v0
.end method
