.class public Lorg/drinkless/tdlib/TdApi$FailedToAddMember;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FailedToAddMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10dc933e


# instance fields
.field public premiumRequiredToSendMessages:Z

.field public premiumWouldAllowInvite:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36939
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 36927
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36928
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$FailedToAddMember;->userId:J

    .line 36929
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$FailedToAddMember;->premiumWouldAllowInvite:Z

    .line 36930
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$FailedToAddMember;->premiumRequiredToSendMessages:Z

    .line 36931
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36935
    const v0, -0x10dc933e

    return v0
.end method
