.class public Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallJoinParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x691bede6


# instance fields
.field public audioSourceId:I

.field public isMuted:Z

.field public isMyVideoEnabled:Z

.field public payload:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43710
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43711
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;ZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 43698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43699
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;->audioSourceId:I

    .line 43700
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;->payload:Ljava/lang/String;

    .line 43701
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;->isMuted:Z

    .line 43702
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;->isMyVideoEnabled:Z

    .line 43703
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43707
    const v0, 0x691bede6

    return v0
.end method
