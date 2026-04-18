.class public Lorg/drinkless/tdlib/TdApi$VerificationStatus;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VerificationStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ae6a18c


# instance fields
.field public botVerificationIconCustomEmojiId:J

.field public isFake:Z

.field public isScam:Z

.field public isVerified:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46375
    return-void
.end method

.method public constructor <init>(ZZZJ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "j5"    # J

    .line 46362
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46363
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$VerificationStatus;->isVerified:Z

    .line 46364
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$VerificationStatus;->isScam:Z

    .line 46365
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$VerificationStatus;->isFake:Z

    .line 46366
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$VerificationStatus;->botVerificationIconCustomEmojiId:J

    .line 46367
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46371
    const v0, 0x3ae6a18c

    return v0
.end method
