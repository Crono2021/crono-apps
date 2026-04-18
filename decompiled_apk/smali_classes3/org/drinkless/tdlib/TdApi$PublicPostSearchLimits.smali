.class public Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PublicPostSearchLimits"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5ced4794


# instance fields
.field public dailyFreeQueryCount:I

.field public isCurrentQueryFree:Z

.field public nextFreeQueryIn:I

.field public remainingFreeQueryCount:I

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48451
    return-void
.end method

.method public constructor <init>(IIIJZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "j5"    # J
    .param p6, "z8"    # Z

    .line 48437
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48438
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;->dailyFreeQueryCount:I

    .line 48439
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;->remainingFreeQueryCount:I

    .line 48440
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;->nextFreeQueryIn:I

    .line 48441
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;->starCount:J

    .line 48442
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;->isCurrentQueryFree:Z

    .line 48443
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48447
    const v0, -0x5ced4794

    return v0
.end method
