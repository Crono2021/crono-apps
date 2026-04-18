.class public Lorg/drinkless/tdlib/TdApi$EditStoryCover;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditStoryCover"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3dbd68a2


# instance fields
.field public coverFrameTimestamp:D

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36850
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36851
    return-void
.end method

.method public constructor <init>(JID)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "d9"    # D

    .line 36839
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36840
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditStoryCover;->storyPosterChatId:J

    .line 36841
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$EditStoryCover;->storyId:I

    .line 36842
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditStoryCover;->coverFrameTimestamp:D

    .line 36843
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36847
    const v0, -0x3dbd68a2

    return v0
.end method
