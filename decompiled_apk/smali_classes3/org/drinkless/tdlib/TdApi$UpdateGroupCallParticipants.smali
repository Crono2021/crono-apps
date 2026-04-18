.class public Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipants;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateGroupCallParticipants"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6fb31166


# instance fields
.field public groupCallId:I

.field public participantUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34549
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 34538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34539
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipants;->groupCallId:I

    .line 34540
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipants;->participantUserIds:[J

    .line 34541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34545
    const v0, -0x6fb31166

    return v0
.end method
