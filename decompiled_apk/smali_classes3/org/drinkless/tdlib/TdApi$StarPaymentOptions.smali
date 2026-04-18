.class public Lorg/drinkless/tdlib/TdApi$StarPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarPaymentOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19417632


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$StarPaymentOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20095
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$StarPaymentOption;)V
    .locals 0
    .param p1, "starPaymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$StarPaymentOption;

    .line 20085
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20086
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarPaymentOptions;->options:[Lorg/drinkless/tdlib/TdApi$StarPaymentOption;

    .line 20087
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20091
    const v0, -0x19417632

    return v0
.end method
