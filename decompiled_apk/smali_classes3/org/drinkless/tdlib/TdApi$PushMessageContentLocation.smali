.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentLocation;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4cc5684d


# instance fields
.field public isLive:Z

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29589
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 29578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29579
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentLocation;->isLive:Z

    .line 29580
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentLocation;->isPinned:Z

    .line 29581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29585
    const v0, -0x4cc5684d

    return v0
.end method
