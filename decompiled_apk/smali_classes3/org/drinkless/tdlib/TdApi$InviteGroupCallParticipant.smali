.class public Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipant;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InviteGroupCallParticipant"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipantResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x25a47736


# instance fields
.field public groupCallId:I

.field public isVideo:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38282
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 38283
    return-void
.end method

.method public constructor <init>(IJZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "z8"    # Z

    .line 38271
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 38272
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipant;->groupCallId:I

    .line 38273
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipant;->userId:J

    .line 38274
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$InviteGroupCallParticipant;->isVideo:Z

    .line 38275
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38279
    const v0, -0x25a47736

    return v0
.end method
