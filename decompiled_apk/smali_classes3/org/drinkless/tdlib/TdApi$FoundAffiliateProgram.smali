.class public Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundAffiliateProgram"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x399c9d7a


# instance fields
.field public botUserId:J

.field public info:Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25605
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "affiliateProgramInfo"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;

    .line 25594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25595
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;->botUserId:J

    .line 25596
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundAffiliateProgram;->info:Lorg/drinkless/tdlib/TdApi$AffiliateProgramInfo;

    .line 25597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25601
    const v0, -0x399c9d7a

    return v0
.end method
