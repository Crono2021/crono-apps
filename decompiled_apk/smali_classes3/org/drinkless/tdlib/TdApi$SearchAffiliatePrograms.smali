.class public Lorg/drinkless/tdlib/TdApi$SearchAffiliatePrograms;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchAffiliatePrograms"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundAffiliatePrograms;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2899a011


# instance fields
.field public affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

.field public limit:I

.field public offset:Ljava/lang/String;

.field public sortOrder:Lorg/drinkless/tdlib/TdApi$AffiliateProgramSortOrder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44982
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44983
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AffiliateType;Lorg/drinkless/tdlib/TdApi$AffiliateProgramSortOrder;Ljava/lang/String;I)V
    .locals 0
    .param p1, "affiliateType"    # Lorg/drinkless/tdlib/TdApi$AffiliateType;
    .param p2, "affiliateProgramSortOrder"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramSortOrder;
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I

    .line 44970
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44971
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchAffiliatePrograms;->affiliate:Lorg/drinkless/tdlib/TdApi$AffiliateType;

    .line 44972
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchAffiliatePrograms;->sortOrder:Lorg/drinkless/tdlib/TdApi$AffiliateProgramSortOrder;

    .line 44973
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchAffiliatePrograms;->offset:Ljava/lang/String;

    .line 44974
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$SearchAffiliatePrograms;->limit:I

    .line 44975
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44979
    const v0, 0x2899a011

    return v0
.end method
