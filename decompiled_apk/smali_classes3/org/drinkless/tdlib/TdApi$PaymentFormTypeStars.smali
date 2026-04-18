.class public Lorg/drinkless/tdlib/TdApi$PaymentFormTypeStars;
.super Lorg/drinkless/tdlib/TdApi$PaymentFormType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentFormTypeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56b9d3d


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 17719
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 17709
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 17710
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeStars;->starCount:J

    .line 17711
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17715
    const v0, 0x56b9d3d

    return v0
.end method
