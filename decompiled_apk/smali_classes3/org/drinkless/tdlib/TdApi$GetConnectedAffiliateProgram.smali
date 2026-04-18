.class public Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetConnectedAffiliateProgram"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x689e1890


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

.field public botUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26005
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AffiliateType;J)V
    .locals 0
    .param p1, "affiliateType"    # Lorg/drinkless/tdlib/TdApi$AffiliateType;
    .param p2, "j5"    # J

    .line 25994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25995
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliateProgram;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

    .line 25996
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliateProgram;->botUserId:J

    .line 25997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26001
    const v0, -0x689e1890

    return v0
.end method
