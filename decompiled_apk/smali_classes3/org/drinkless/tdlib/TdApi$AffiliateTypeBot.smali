.class public Lorg/drinkless/tdlib/TdApi$AffiliateTypeBot;
.super Lorg/drinkless/tdlib/TdApi$AffiliateType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AffiliateTypeBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d8c07c0


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8736
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AffiliateType;-><init>()V

    .line 8737
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 8727
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AffiliateType;-><init>()V

    .line 8728
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AffiliateTypeBot;->userId:J

    .line 8729
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8733
    const v0, -0x3d8c07c0

    return v0
.end method
