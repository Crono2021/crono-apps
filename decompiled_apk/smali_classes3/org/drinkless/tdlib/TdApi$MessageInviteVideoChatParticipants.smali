.class public Lorg/drinkless/tdlib/TdApi$MessageInviteVideoChatParticipants;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageInviteVideoChatParticipants"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x56f792f1


# instance fields
.field public groupCallId:I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28465
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 28454
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28455
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageInviteVideoChatParticipants;->groupCallId:I

    .line 28456
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageInviteVideoChatParticipants;->userIds:[J

    .line 28457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28461
    const v0, -0x56f792f1

    return v0
.end method
