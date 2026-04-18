.class public Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliatePrograms;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetConnectedAffiliatePrograms"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ConnectedAffiliatePrograms;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x74d3ad8e


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

.field public limit:I

.field public offset:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37290
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37291
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AffiliateType;Ljava/lang/String;I)V
    .locals 0
    .param p1, "affiliateType"    # Lorg/drinkless/tdlib/TdApi$AffiliateType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 37279
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37280
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliatePrograms;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

    .line 37281
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliatePrograms;->offset:Ljava/lang/String;

    .line 37282
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetConnectedAffiliatePrograms;->limit:I

    .line 37283
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37287
    const v0, -0x74d3ad8e    # -3.318802E-32f

    return v0
.end method
