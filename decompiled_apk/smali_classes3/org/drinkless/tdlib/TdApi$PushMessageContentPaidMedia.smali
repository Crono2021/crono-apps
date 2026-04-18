.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentPaidMedia;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentPaidMedia"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4aa918b6


# instance fields
.field public isPinned:Z

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29609
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 29598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29599
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPaidMedia;->starCount:J

    .line 29600
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPaidMedia;->isPinned:Z

    .line 29601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29605
    const v0, -0x4aa918b6

    return v0
.end method
