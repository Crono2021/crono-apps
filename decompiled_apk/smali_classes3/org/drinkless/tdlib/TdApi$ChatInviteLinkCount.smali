.class public Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatInviteLinkCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3cea786a


# instance fields
.field public inviteLinkCount:I

.field public revokedInviteLinkCount:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36146
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36147
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 36135
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36136
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;->userId:J

    .line 36137
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;->inviteLinkCount:I

    .line 36138
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatInviteLinkCount;->revokedInviteLinkCount:I

    .line 36139
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36143
    const v0, -0x3cea786a

    return v0
.end method
