.class public Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResultSuccess;
.super Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InviteGroupCallParticipantResultSuccess"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x721a0b33


# instance fields
.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResult;-><init>()V

    .line 27825
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 27814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResult;-><init>()V

    .line 27815
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResultSuccess;->chatId:J

    .line 27816
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResultSuccess;->messageId:J

    .line 27817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27821
    const v0, -0x721a0b33

    return v0
.end method
