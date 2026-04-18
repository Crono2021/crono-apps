.class public Lorg/drinkless/tdlib/TdApi$GroupCallParticipants;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallParticipants"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3e2328b2


# instance fields
.field public participantIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27005
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 26994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26995
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipants;->totalCount:I

    .line 26996
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipants;->participantIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 26997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27001
    const v0, -0x3e2328b2

    return v0
.end method
