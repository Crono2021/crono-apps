.class public Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarGiveawayPaymentOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x48859f87


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20076
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20077
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;)V
    .locals 0
    .param p1, "starGiveawayPaymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;

    .line 20067
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20068
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOptions;->options:[Lorg/drinkless/tdlib/TdApi$StarGiveawayPaymentOption;

    .line 20069
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20073
    const v0, -0x48859f87

    return v0
.end method
