.class public Lorg/drinkless/tdlib/TdApi$ConnectedAffiliatePrograms;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectedAffiliatePrograms"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x59c1eb0f


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public programs:[Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36366
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36367
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "connectedAffiliateProgramArr"    # [Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;
    .param p3, "str"    # Ljava/lang/String;

    .line 36355
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36356
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliatePrograms;->totalCount:I

    .line 36357
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliatePrograms;->programs:[Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;

    .line 36358
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliatePrograms;->nextOffset:Ljava/lang/String;

    .line 36359
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36363
    const v0, 0x59c1eb0f

    return v0
.end method
