.class public Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AffiliateProgramParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61e90c54


# instance fields
.field public commissionPerMille:I

.field public monthCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22804
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22805
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 22794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22795
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;->commissionPerMille:I

    .line 22796
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;->monthCount:I

    .line 22797
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22801
    const v0, 0x61e90c54

    return v0
.end method
