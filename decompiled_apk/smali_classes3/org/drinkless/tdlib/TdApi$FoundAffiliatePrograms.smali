.class public Lorg/drinkless/tdlib/TdApi$FoundAffiliatePrograms;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundAffiliatePrograms"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb1af901


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public programs:[Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36960
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36961
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "foundAffiliateProgramArr"    # [Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;
    .param p3, "str"    # Ljava/lang/String;

    .line 36949
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36950
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundAffiliatePrograms;->totalCount:I

    .line 36951
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundAffiliatePrograms;->programs:[Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;

    .line 36952
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundAffiliatePrograms;->nextOffset:Ljava/lang/String;

    .line 36953
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36957
    const v0, 0xb1af901

    return v0
.end method
