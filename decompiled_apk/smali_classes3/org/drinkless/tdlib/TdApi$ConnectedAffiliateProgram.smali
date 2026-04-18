.class public Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConnectedAffiliateProgram"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58bf7415


# instance fields
.field public botUserId:J

.field public connectionDate:I

.field public isDisconnected:Z

.field public parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;

.field public revenueStarCount:J

.field public url:Ljava/lang/String;

.field public userCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51165
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;IZJJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "affiliateProgramParameters"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;
    .param p5, "i9"    # I
    .param p6, "z8"    # Z
    .param p7, "j9"    # J
    .param p9, "j10"    # J

    .line 51149
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51150
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->url:Ljava/lang/String;

    .line 51151
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->botUserId:J

    .line 51152
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;

    .line 51153
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->connectionDate:I

    .line 51154
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->isDisconnected:Z

    .line 51155
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->userCount:J

    .line 51156
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$ConnectedAffiliateProgram;->revenueStarCount:J

    .line 51157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51161
    const v0, 0x58bf7415

    return v0
.end method
