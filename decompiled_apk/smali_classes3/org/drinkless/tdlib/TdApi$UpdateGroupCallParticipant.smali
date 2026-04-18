.class public Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipant;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateGroupCallParticipant"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2fdec307


# instance fields
.field public groupCallId:I

.field public participant:Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34529
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$GroupCallParticipant;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "groupCallParticipant"    # Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;

    .line 34518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34519
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipant;->groupCallId:I

    .line 34520
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallParticipant;->participant:Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;

    .line 34521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34525
    const v0, -0x2fdec307

    return v0
.end method
