.class public Lorg/drinkless/tdlib/TdApi$Count;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Count"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d38f104


# instance fields
.field public count:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11022
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11023
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11013
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11014
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Count;->count:I

    .line 11015
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11019
    const v0, 0x4d38f104    # 1.9392518E8f

    return v0
.end method
