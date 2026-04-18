.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentInviteVideoChatParticipants;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentInviteVideoChatParticipants"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1eda428d


# instance fields
.field public isCurrentUser:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18151
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18141
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18142
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentInviteVideoChatParticipants;->isCurrentUser:Z

    .line 18143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18147
    const v0, 0x1eda428d

    return v0
.end method
