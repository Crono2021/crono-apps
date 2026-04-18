.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2a396965


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15504
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15505
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15495
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15496
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeUpgradedGift;->name:Ljava/lang/String;

    .line 15497
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15501
    const v0, -0x2a396965

    return v0
.end method
