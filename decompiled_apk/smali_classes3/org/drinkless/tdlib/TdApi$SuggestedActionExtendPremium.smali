.class public Lorg/drinkless/tdlib/TdApi$SuggestedActionExtendPremium;
.super Lorg/drinkless/tdlib/TdApi$SuggestedAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedActionExtendPremium"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x21bfa336


# instance fields
.field public managePremiumSubscriptionUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20580
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 20581
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20571
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 20572
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionExtendPremium;->managePremiumSubscriptionUrl:Ljava/lang/String;

    .line 20573
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20577
    const v0, -0x21bfa336

    return v0
.end method
