.class public Lorg/drinkless/tdlib/TdApi$StarAmount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarAmount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f0e6d80


# instance fields
.field public nanostarCount:I

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32289
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32279
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarAmount;->starCount:J

    .line 32280
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarAmount;->nanostarCount:I

    .line 32281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32285
    const v0, 0x6f0e6d80

    return v0
.end method
