.class public Lorg/drinkless/tdlib/TdApi$BusinessFeatures;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessFeatures"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5b579bd8


# instance fields
.field public features:[Lorg/drinkless/tdlib/TdApi$BusinessFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9222
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9223
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$BusinessFeature;)V
    .locals 0
    .param p1, "businessFeatureArr"    # [Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 9213
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9214
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessFeatures;->features:[Lorg/drinkless/tdlib/TdApi$BusinessFeature;

    .line 9215
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9219
    const v0, -0x5b579bd8

    return v0
.end method
