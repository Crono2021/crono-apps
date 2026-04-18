.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPremiumPurchase;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateWaitPremiumPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7d071585


# instance fields
.field public storeProductId:Ljava/lang/String;

.field public supportEmailAddress:Ljava/lang/String;

.field public supportEmailSubject:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35750
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 35751
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;

    .line 35739
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    .line 35740
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPremiumPurchase;->storeProductId:Ljava/lang/String;

    .line 35741
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPremiumPurchase;->supportEmailAddress:Ljava/lang/String;

    .line 35742
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AuthorizationStateWaitPremiumPurchase;->supportEmailSubject:Ljava/lang/String;

    .line 35743
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35747
    const v0, 0x7d071585

    return v0
.end method
