.class public Lorg/drinkless/tdlib/TdApi$BusinessFeatureOpeningHours;
.super Lorg/drinkless/tdlib/TdApi$BusinessFeature;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessFeatureOpeningHours"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1b7b22ed


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BusinessFeature;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 533
    const v0, 0x1b7b22ed

    return v0
.end method
