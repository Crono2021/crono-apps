.class public Lorg/drinkless/tdlib/TdApi$MessageOriginUser;
.super Lorg/drinkless/tdlib/TdApi$MessageOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageOriginUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x63ff6fbd


# instance fields
.field public senderUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16566
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageOrigin;-><init>()V

    .line 16567
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16557
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageOrigin;-><init>()V

    .line 16558
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageOriginUser;->senderUserId:J

    .line 16559
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16563
    const v0, -0x63ff6fbd

    return v0
.end method
